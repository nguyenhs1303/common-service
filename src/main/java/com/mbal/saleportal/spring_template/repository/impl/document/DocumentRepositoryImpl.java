package com.mbal.saleportal.spring_template.repository.impl.document;

import com.mbal.saleportal.spring_template.entity.Document;
import com.mbal.saleportal.spring_template.enums.document.DocumentCategory;
import com.mbal.saleportal.spring_template.enums.document.DocumentNotificationStatus;
import com.mbal.saleportal.spring_template.enums.document.DocumentType;
import com.mbal.saleportal.spring_template.repository.impl.RepositoryImpl;
import com.mbal.saleportal.spring_template.repository.primary.document.DocumentPrimaryRepository;
import com.mbal.saleportal.spring_template.repository.secondary.document.DocumentSecondaryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentRepositoryImpl extends RepositoryImpl<Document, Long> implements DocumentPrimaryRepository, DocumentSecondaryRepository {

    private DocumentPrimaryRepository documentPrimaryRepository;
    private DocumentSecondaryRepository documentSecondaryRepository;

    public DocumentRepositoryImpl(DocumentSecondaryRepository documentSecondaryRepository,
                                  DocumentPrimaryRepository documentPrimaryRepository) {
        super(documentSecondaryRepository, documentPrimaryRepository);
        this.documentPrimaryRepository = documentPrimaryRepository;
        this.documentSecondaryRepository = documentSecondaryRepository;
    }

    @Override
    public void updateUploadStatusByDocumentNameId(Long documentCategoryId, boolean status) {
        this.documentPrimaryRepository.updateUploadStatusByDocumentNameId(documentCategoryId, status);
    }

    @Override
    public Page<Document> filter(String keyword, DocumentType documentType, DocumentCategory documentCategory, Boolean uploadStatus, DocumentNotificationStatus notificationStatus, Pageable pageable) {
        return this.documentSecondaryRepository.filter(keyword, documentType, documentCategory, uploadStatus, notificationStatus, pageable);
    }
}
