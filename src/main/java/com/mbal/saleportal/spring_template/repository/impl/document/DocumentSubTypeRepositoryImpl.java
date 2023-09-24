package com.mbal.saleportal.spring_template.repository.impl.document;

import com.mbal.saleportal.spring_template.entity.DocumentSubType;
import com.mbal.saleportal.spring_template.repository.impl.RepositoryImpl;
import com.mbal.saleportal.spring_template.repository.secondary.document.DocumentSubTypeSecondaryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentSubTypeRepositoryImpl extends RepositoryImpl<DocumentSubType, Long> implements DocumentSubTypeSecondaryRepository {

    private DocumentSubTypeSecondaryRepository documentSubTypeSecondaryRepository;

    public DocumentSubTypeRepositoryImpl(DocumentSubTypeSecondaryRepository documentSubTypeSecondaryRepository) {
        super(documentSubTypeSecondaryRepository);
        this.documentSubTypeSecondaryRepository = documentSubTypeSecondaryRepository;
    }

}
