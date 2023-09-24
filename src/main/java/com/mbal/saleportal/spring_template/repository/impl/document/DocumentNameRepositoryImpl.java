package com.mbal.saleportal.spring_template.repository.impl.document;

import com.mbal.saleportal.spring_template.entity.DocumentName;
import com.mbal.saleportal.spring_template.repository.impl.RepositoryImpl;
import com.mbal.saleportal.spring_template.repository.secondary.document.DocumentNameSecondaryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentNameRepositoryImpl extends RepositoryImpl<DocumentName, Long> implements DocumentNameSecondaryRepository {

    private DocumentNameSecondaryRepository documentNameSecondaryRepository;

    public DocumentNameRepositoryImpl(DocumentNameSecondaryRepository documentNameSecondaryRepository) {
        super(documentNameSecondaryRepository);
        this.documentNameSecondaryRepository = documentNameSecondaryRepository;
    }

}
