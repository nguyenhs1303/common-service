package com.mbal.saleportal.spring_template.repository.impl.document;

import com.mbal.saleportal.spring_template.entity.DocumentName;
import com.mbal.saleportal.spring_template.repository.impl.RepositoryImpl;
import com.mbal.saleportal.spring_template.repository.primary.document.DocumentNamePrimaryRepository;
import com.mbal.saleportal.spring_template.repository.secondary.document.DocumentNameSecondaryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentNameRepositoryImpl extends RepositoryImpl<DocumentName, Long> implements DocumentNameSecondaryRepository, DocumentNamePrimaryRepository {

    private DocumentNameSecondaryRepository documentNameSecondaryRepository;
    private DocumentNamePrimaryRepository documentNamePrimaryRepository;

    public DocumentNameRepositoryImpl(DocumentNameSecondaryRepository documentNameSecondaryRepository, DocumentNamePrimaryRepository documentNamePrimaryRepository) {
        super(documentNameSecondaryRepository, documentNamePrimaryRepository);
        this.documentNameSecondaryRepository = documentNameSecondaryRepository;
        this.documentNamePrimaryRepository = documentNamePrimaryRepository;
    }

}
