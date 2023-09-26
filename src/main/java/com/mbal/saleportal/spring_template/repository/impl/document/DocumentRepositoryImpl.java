package com.mbal.saleportal.spring_template.repository.impl.document;

import com.mbal.saleportal.spring_template.dto.document.response.CountDocument;
import com.mbal.saleportal.spring_template.entity.Document;
import com.mbal.saleportal.spring_template.enums.SalePortalChannel;
import com.mbal.saleportal.spring_template.enums.document.DocumentCategory;
import com.mbal.saleportal.spring_template.enums.document.DocumentNotificationStatus;
import com.mbal.saleportal.spring_template.enums.document.DocumentType;
import com.mbal.saleportal.spring_template.repository.impl.RepositoryImpl;
import com.mbal.saleportal.spring_template.repository.primary.document.DocumentPrimaryRepository;
import com.mbal.saleportal.spring_template.repository.secondary.document.DocumentSecondaryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class DocumentRepositoryImpl extends RepositoryImpl<Document, Long> implements DocumentPrimaryRepository, DocumentSecondaryRepository {

    private final DocumentPrimaryRepository documentPrimaryRepository;
    private final DocumentSecondaryRepository documentSecondaryRepository;

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
    public void updateStatusByInIds(List<Long> ids, Boolean status) {
        this.documentPrimaryRepository.updateStatusByInIds(ids, status);
    }

    @Override
    public Page<Document> filter(String keyword, DocumentType documentType, DocumentCategory documentCategory, SalePortalChannel channel, Boolean uploadStatus, DocumentNotificationStatus notificationStatus, Timestamp startCreatedAt, Timestamp endCreatedAt, Timestamp startUpdateAt, Timestamp endUpdateAt, Timestamp startEffectiveDate, Timestamp endEffectiveDate, Timestamp startExpirationDate, Timestamp endExpirationDate, Pageable pageable) {
        return this.documentSecondaryRepository.filter(keyword, documentType, documentCategory, channel, uploadStatus, notificationStatus, startCreatedAt, endCreatedAt, startUpdateAt, endUpdateAt, startEffectiveDate, endEffectiveDate, startExpirationDate, endExpirationDate, pageable);
    }

    @Override
    public List<CountDocument> countDocumentByTypeAndUploadStatusAndGroupByCategory(DocumentType type, Boolean uploadStatus) {
        return documentSecondaryRepository.countDocumentByTypeAndUploadStatusAndGroupByCategory(type, uploadStatus);
    }

    @Override
    public List<Document> findByIds(List<Long> ids) {
        return documentSecondaryRepository.findByIds(ids);
    }
}
