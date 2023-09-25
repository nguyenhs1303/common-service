package com.mbal.saleportal.spring_template.repository.impl.document;

import com.mbal.saleportal.spring_template.entity.DocumentCategory;
import com.mbal.saleportal.spring_template.enums.document.DocumentType;
import com.mbal.saleportal.spring_template.repository.impl.RepositoryImpl;
import com.mbal.saleportal.spring_template.repository.primary.document.DocumentCategoryPrimaryRepository;
import com.mbal.saleportal.spring_template.repository.secondary.document.DocumentCategorySecondaryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentCategoryRepositoryImpl extends RepositoryImpl<DocumentCategory, Long> implements DocumentCategorySecondaryRepository, DocumentCategoryPrimaryRepository {

    private DocumentCategorySecondaryRepository documentCategorySecondaryRepository;
    private DocumentCategoryPrimaryRepository documentCategoryPrimaryRepository;

    public DocumentCategoryRepositoryImpl(DocumentCategorySecondaryRepository documentCategorySecondaryRepository,
                                          DocumentCategoryPrimaryRepository documentCategoryPrimaryRepository) {
        super(documentCategorySecondaryRepository,documentCategoryPrimaryRepository);
        this.documentCategorySecondaryRepository = documentCategorySecondaryRepository;
        this.documentCategoryPrimaryRepository = documentCategoryPrimaryRepository;
    }

    @Override
    public Page<DocumentCategory> filter(List<DocumentType> types, Pageable pageable) {
        return this.documentCategorySecondaryRepository.filter(types, pageable);
    }
}
