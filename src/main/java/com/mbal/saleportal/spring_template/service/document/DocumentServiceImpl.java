package com.mbal.saleportal.spring_template.service.document;

import com.mbal.saleportal.spring_template.converter.document.DocumentMapper;
import com.mbal.saleportal.spring_template.dto.ApiBaseResponse;
import com.mbal.saleportal.spring_template.dto.PageBaseDto;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentRequest;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentUpdateRequest;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentFilterRequest;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentNameFilterRequest;
import com.mbal.saleportal.spring_template.dto.document.response.DocumentResponse;
import com.mbal.saleportal.spring_template.dto.document.response.DocumentFileResponse;
import com.mbal.saleportal.spring_template.dto.document.response.SummaryDocument;
import com.mbal.saleportal.spring_template.entity.Document;
import com.mbal.saleportal.spring_template.entity.DocumentFile;
import com.mbal.saleportal.spring_template.entity.DocumentName;
import com.mbal.saleportal.spring_template.enums.SalePortalChannel;
import com.mbal.saleportal.spring_template.enums.document.DocumentCategory;
import com.mbal.saleportal.spring_template.enums.document.DocumentResponseMessage;
import com.mbal.saleportal.spring_template.enums.document.DocumentType;
import com.mbal.saleportal.spring_template.enums.document.DocumentUserType;
import com.mbal.saleportal.spring_template.enums.document.DocumentNotificationStatus;
import com.mbal.saleportal.spring_template.exception.BadRequestException;
import com.mbal.saleportal.spring_template.repository.impl.document.DocumentFileRepositoryImpl;
import com.mbal.saleportal.spring_template.repository.impl.document.DocumentNameRepositoryImpl;
import com.mbal.saleportal.spring_template.repository.impl.document.DocumentRepositoryImpl;
import com.mbal.saleportal.spring_template.util.DateUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepositoryImpl documentRepository;
    private final DocumentFileRepositoryImpl documentFileRepository;
    private final DocumentNameRepositoryImpl documentNameRepository;


    @Override
    public ApiBaseResponse<PageBaseDto<Document>> getDocuments(DocumentFilterRequest filter) {
        Pageable pageable = PageRequest.of(filter.getPageRequest().getPage(), filter.getPageRequest().getSize());
        Page<Document> page = documentRepository
                .filter(filter.getKeyword(),
                        DocumentType.convertFromString(filter.getDocumentType()),
                        DocumentCategory.convertFromString(filter.getDocumentCategory()),
                        filter.getUploadStatus(),
                        DocumentNotificationStatus.convertFromString(filter.getNotificationStatus()),
                        pageable);
        PageBaseDto<Document> pageBaseDto = PageBaseDto.<Document>builder()
                .page(filter.getPageRequest().getPage())
                .size(filter.getPageRequest().getSize())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .content(page.getContent())
                .build();
        return ApiBaseResponse.<PageBaseDto<Document>>builder()
                .statusCode(String.valueOf(HttpStatus.OK.value()))
                .message(HttpStatus.OK.name())
                .data(pageBaseDto)
                .build();
    }

    @Override
    public ApiBaseResponse<PageBaseDto<DocumentName>> NameDocumentResponse(DocumentNameFilterRequest filter) {
        Sort sort = Sort.by(Sort.Order.asc("order"), Sort.Order.desc("createdAt"));
        Pageable pageable = PageRequest.of(filter.getPageRequest().getPage(), filter.getPageRequest().getSize(), sort);
        Page<DocumentName> page = documentNameRepository.filter(filter, pageable);
        PageBaseDto<DocumentName> pageBaseDto = PageBaseDto.<DocumentName>builder()
                .page(filter.getPageRequest().getPage())
                .size(filter.getPageRequest().getSize())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .content(page.getContent())
                .build();
        return ApiBaseResponse.<PageBaseDto<DocumentName>>builder()
                .statusCode(String.valueOf(HttpStatus.OK.value()))
                .message(HttpStatus.OK.name())
                .data(pageBaseDto)
                .build();
    }


    @Override
    public ApiBaseResponse<Document> getDetailDocument(Long id) {
        ApiBaseResponse<Document> response = ApiBaseResponse.<Document>builder()
                .statusCode(String.valueOf(HttpStatus.OK.value()))
                .message(HttpStatus.OK.name())
                .build();
        Document document = documentRepository.findById(id).orElse(null);
        DocumentResponse documentResponse = DocumentMapper.INSTANCE.documentEntityToResponse(document);
        if (document == null){
            return response;
        }
        List<DocumentFile> fileList = documentFileRepository.findByDocumentId(document.getId());
        List<DocumentFileResponse> filesResponse = fileList.stream().map(DocumentMapper.INSTANCE::documentFileEntityToResponse).collect(Collectors.toList());
        documentResponse.setFiles(filesResponse);
        response.setData(document);
        return response;
    }

    @Override
    public ApiBaseResponse<?> updateStatusDocuments(DocumentUpdateRequest request) {
        return null;
    }

    @Override
    public ApiBaseResponse<?> createDocument(DocumentRequest request) {
        validationDocumentRequest(request);
        Document document = DocumentMapper.INSTANCE.documentRequestToEntity(request);
        document.setNotificationStatus(processNotificationStatus(request));
        List<DocumentFile> documentFile = request.getFiles().stream()
                .map(d -> {
                    DocumentFile file = DocumentMapper.INSTANCE.documentFileRequestToEntity(d);
                    file.setDocumentId(document.getDocumentNameId());
                    return file;
                }).collect(Collectors.toList());
        if (DocumentType.FORM.equals(DocumentType.valueOf(request.getType()))) {
            if (request.getDocumentNameId() != null) {
                documentRepository.updateUploadStatusByDocumentNameId(request.getDocumentNameId(), false);
            }
        }

        document.setUploadStatus(true);
        documentRepository.save(document);
        documentFileRepository.saveAll(documentFile);
        return ApiBaseResponse.builder()
                .message(HttpStatus.OK.name())
                .statusCode(String.valueOf(HttpStatus.OK.value()))
                .build();
    }

    private DocumentNotificationStatus processNotificationStatus(DocumentRequest request) {
        if (DocumentType.NOTIFICATION.equals(DocumentType.valueOf(request.getType()))) {
            LocalDate now = LocalDate.now();
            LocalDate expirationDate = DateUtils.stringToLocalDate(request.getExpirationDate(), DateUtils.PATTERN_DDmmyyyy);
            if (expirationDate == null) return null;
            if (expirationDate.isAfter(now)) return DocumentNotificationStatus.ACTIVE;
            return DocumentNotificationStatus.DE_ACTIVE;
        }
        return null;
    }

    private void validationDocumentRequest(DocumentRequest request) {
        DocumentType.checkDocumentType(request.getType());
        SalePortalChannel.checkChannel(request.getChannel());
        DocumentUserType.checkUserType(request.getUserType());
        DocumentCategory.checkCategory(request.getDocumentCategory());

        // validate thông báo
        if (DocumentType.valueOf(request.getType()).equals(DocumentType.NOTIFICATION)) {
            // Kiểm tra category có thuộc notification không
            List<DocumentType> typeListNotification = List.of(DocumentType.ALL, DocumentType.NOTIFICATION);
            DocumentCategory documentCategory = DocumentCategory.valueOf(request.getDocumentCategory());
            if (!typeListNotification.contains(documentCategory.getDocumentType())) {
                throw new BadRequestException(DocumentResponseMessage.DOCUMENT_CATEGORY_NOT_BELONG_TO_NOTIFICATION);
            }
            LocalDate now = LocalDate.now();
            request.setDocumentNameId(null);
            LocalDate effectiveDate = DateUtils.stringToLocalDate(request.getEffectiveDate(), DateUtils.PATTERN_DDmmyyyy);
            if (effectiveDate == null) throw new BadRequestException(DocumentResponseMessage.DATE_FORMAT);
            if (effectiveDate.isAfter(now))
                throw new BadRequestException(DocumentResponseMessage.EFFECTIVE_DATE_NOT_AFTER_NOW);

            LocalDate expirationDate = DateUtils.stringToLocalDate(request.getExpirationDate(), DateUtils.PATTERN_DDmmyyyy);
            if (expirationDate == null) throw new BadRequestException(DocumentResponseMessage.DATE_FORMAT);

            if (effectiveDate.isAfter(expirationDate))
                throw new BadRequestException(DocumentResponseMessage.EFFECTIVE_DATE_NOT_AFTER_EXPIRATION_DATE);

        }


        if (DocumentType.valueOf(request.getType()).equals(DocumentType.FORM)) {

            // Kiểm tra category có thuộc form không
            List<DocumentType> typeListForm = List.of(DocumentType.ALL, DocumentType.FORM);
            DocumentCategory categoryRequest = DocumentCategory.valueOf(request.getDocumentCategory());
            if (!typeListForm.contains(categoryRequest.getDocumentType())) {
                throw new BadRequestException(DocumentResponseMessage.DOCUMENT_CATEGORY_NOT_BELONG_TO_FORM);
            }
            //validate name document ( Danh sách name chỉ `Biểu mẫu` (FORM) mới có )
            if (request.getDocumentNameId() != null) {
                DocumentName documentNameExist = documentNameRepository.findById(request.getDocumentNameId()).orElse(null);
                if (documentNameExist == null) {
                    throw new BadRequestException(DocumentResponseMessage.DOCUMENT_NAME_NOT_EXIST);
                }

                if (!documentNameExist.getDocumentCategory().equals(DocumentCategory.convertFromString(request.getDocumentCategory()))) {
                    throw new BadRequestException(DocumentResponseMessage.DOCUMENT_NAME_NOT_BELONG_TO_DOCUMENT_CATEGORY);
                }

                // Set name và category theo thông tin của documentName
                request.setName(documentNameExist.getName());
                request.setDocumentCategory(documentNameExist.getDocumentCategory().name());
            }

            // Nếu là Biểu mẫu thì không có ngày hiệu lực(effectiveDate) và ngày hết hiệu lực(expirationDate)
            request.setEffectiveDate(null);
            request.setExpirationDate(null);
        }
    }

    @Override
    public ApiBaseResponse<SummaryDocument> summaryDocument() {
        return null;
    }
}
