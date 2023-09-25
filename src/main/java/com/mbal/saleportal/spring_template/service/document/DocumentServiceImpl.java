package com.mbal.saleportal.spring_template.service.document;

import com.mbal.saleportal.spring_template.converter.document.DocumentMapper;
import com.mbal.saleportal.spring_template.dto.ApiBaseResponse;
import com.mbal.saleportal.spring_template.dto.PageBaseDto;
import com.mbal.saleportal.spring_template.dto.document.request.CategoryFilter;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentRequest;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentUpdateRequest;
import com.mbal.saleportal.spring_template.dto.document.request.FilterDocumentRequest;
import com.mbal.saleportal.spring_template.dto.document.request.FilterNameDocumentRequest;
import com.mbal.saleportal.spring_template.dto.document.response.DocumentResponse;
import com.mbal.saleportal.spring_template.dto.document.response.NameDocumentResponse;
import com.mbal.saleportal.spring_template.dto.document.response.SubTypeDocumentResponse;
import com.mbal.saleportal.spring_template.dto.document.response.SummaryDocument;
import com.mbal.saleportal.spring_template.entity.Document;
import com.mbal.saleportal.spring_template.entity.DocumentCategory;
import com.mbal.saleportal.spring_template.entity.DocumentFile;
import com.mbal.saleportal.spring_template.entity.DocumentName;
import com.mbal.saleportal.spring_template.enums.document.DocumentResponseMessage;
import com.mbal.saleportal.spring_template.enums.document.DocumentType;
import com.mbal.saleportal.spring_template.exception.BadRequestException;
import com.mbal.saleportal.spring_template.repository.impl.document.DocumentCategoryRepositoryImpl;
import com.mbal.saleportal.spring_template.repository.impl.document.DocumentFileRepositoryImpl;
import com.mbal.saleportal.spring_template.repository.impl.document.DocumentNameRepositoryImpl;
import com.mbal.saleportal.spring_template.repository.impl.document.DocumentRepositoryImpl;
import com.mbal.saleportal.spring_template.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepositoryImpl documentRepository;

    @Autowired
    private DocumentFileRepositoryImpl documentFileRepository;

    @Autowired
    private DocumentNameRepositoryImpl documentNameRepository;

    @Autowired
    private DocumentCategoryRepositoryImpl documentCategoryRepository;


    @Override
    public ApiBaseResponse<DocumentResponse> getDocuments(FilterDocumentRequest request) {
        return null;
    }

    @Override
    public ApiBaseResponse<PageBaseDto<NameDocumentResponse>> NameDocumentResponse(FilterNameDocumentRequest filter) {
        Pageable pageable = PageRequest.of(filter.getPageRequest().getPage(), filter.getPageRequest().getSize());
        Page<NameDocumentResponse> nameDocumentResponses = documentNameRepository.filter(filter, pageable);
    }

    @Override
    public ApiBaseResponse<PageBaseDto<DocumentCategory>> getCategories(CategoryFilter filter) {
        Pageable pageable = PageRequest.of(filter.getPageRequest().getPage(), filter.getPageRequest().getSize());
        if (!DocumentType.checkDocumentType(filter.getType())){
            throw new BadRequestException("Vui lòng chọn `FORM` hoặc `NOTIFICATION` cho type");
        }
        Page<DocumentCategory> categoryPage = documentCategoryRepository.filter(List.of(DocumentType.ALL, DocumentType.valueOf(filter.getType())), pageable);
        PageBaseDto<DocumentCategory> pageBaseDto = PageBaseDto.<DocumentCategory>builder()
                .page(filter.getPageRequest().getPage())
                .size(filter.getPageRequest().getSize())
                .totalPages(categoryPage.getTotalPages())
                .totalElements(categoryPage.getTotalElements())
                .content(categoryPage.getContent())
                .build();
        return ApiBaseResponse.<PageBaseDto<DocumentCategory>>builder()
                .statusCode(String.valueOf(HttpStatus.OK.value()))
                .message(HttpStatus.OK.name())
                .data(pageBaseDto)
                .build();
    }

    @Override
    public ApiBaseResponse<?> getDetailDocument(Long id) {
        return null;
    }

    @Override
    public ApiBaseResponse<?> updateStatusDocuments(DocumentUpdateRequest request) {
        return null;
    }

    @Override
    public ApiBaseResponse<?> createDocument(DocumentRequest request) {
        processValidationDocumentName(request);
        Document document = DocumentMapper.INSTANCE.documentRequestToEntity(request);
        List<DocumentFile> documentFile = request.getFiles().stream().map(DocumentMapper.INSTANCE::documentFileRequestToEntity).collect(Collectors.toList());
        documentRepository.save(document);
        documentFileRepository.saveAll(documentFile);
        return ApiBaseResponse.builder()
                .message(HttpStatus.OK.name())
                .statusCode(String.valueOf(HttpStatus.OK.value()))
                .build();
    }

    private void processValidationDocumentName(DocumentRequest request) {
        if (request == null) throw new BadRequestException(DocumentResponseMessage.SOMETHING_WHEN_WRONG);

        if (request.getNameDocumentId() == null && StringUtils.isNullOrEmptyWithTrim(request.getName())) {
            documentNameRepository.save(new DocumentName(request.getName()));
        } else if (request.getNameDocumentId() != null && !StringUtils.isNullOrEmptyWithTrim(request.getName())) {
            DocumentName documentNameExist = documentNameRepository.findById(request.getNameDocumentId()).orElse(null);
            if (documentNameExist == null) {
                throw new BadRequestException(DocumentResponseMessage.DOCUMENT_NAME_NOT_EXIST);
            }

            if (!StringUtils.isNullOrEmptyWithTrim(request.getName()) && !documentNameExist.getName().equals(request.getName())) {
                throw new BadRequestException(DocumentResponseMessage.DOCUMENT_NAME_NOT_EXIST);
            }
        }
    }

    @Override
    public ApiBaseResponse<SummaryDocument> summaryDocument() {
        return null;
    }
}
