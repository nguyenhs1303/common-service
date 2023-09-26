package com.mbal.saleportal.spring_template.repository.impl.document;

import com.mbal.saleportal.spring_template.entity.DocumentFile;
import com.mbal.saleportal.spring_template.repository.impl.RepositoryImpl;
import com.mbal.saleportal.spring_template.repository.primary.document.DocumentFilePrimaryRepository;
import com.mbal.saleportal.spring_template.repository.secondary.document.DocumentFileSecondaryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentFileRepositoryImpl extends RepositoryImpl<DocumentFile, Long> implements DocumentFilePrimaryRepository, DocumentFileSecondaryRepository {

    private final DocumentFilePrimaryRepository documentFilePrimaryRepository;
    private final DocumentFileSecondaryRepository documentFileSecondaryRepository;

    public DocumentFileRepositoryImpl(DocumentFileSecondaryRepository documentFileSecondaryRepository,
                                      DocumentFilePrimaryRepository documentFilePrimaryRepository) {
        super(documentFileSecondaryRepository, documentFilePrimaryRepository);
        this.documentFilePrimaryRepository = documentFilePrimaryRepository;
        this.documentFileSecondaryRepository = documentFileSecondaryRepository;
    }

    @Override
    public List<DocumentFile> findByDocumentId(Long documentId) {
        return this.documentFileSecondaryRepository.findByDocumentId(documentId);
    }

    @Override
    public void deleteByDocumentId(Long documentId) {
        this.documentFilePrimaryRepository.deleteByDocumentId(documentId);
    }
}
