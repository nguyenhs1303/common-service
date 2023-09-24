package com.mbal.saleportal.spring_template.repository.impl.document;

import com.mbal.saleportal.spring_template.entity.Document;
import com.mbal.saleportal.spring_template.repository.impl.RepositoryImpl;
import com.mbal.saleportal.spring_template.repository.primary.document.DocumentPrimaryRepository;
import com.mbal.saleportal.spring_template.repository.secondary.document.DocumentSecondaryRepository;
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

}
