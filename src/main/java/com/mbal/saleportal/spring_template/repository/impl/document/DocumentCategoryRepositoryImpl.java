package com.mbal.saleportal.spring_template.repository.impl.document;

import com.mbal.saleportal.spring_template.dto.document.request.CategoryFilter;
import com.mbal.saleportal.spring_template.entity.DocumentCategory;
import com.mbal.saleportal.spring_template.repository.impl.RepositoryImpl;
import com.mbal.saleportal.spring_template.repository.secondary.document.DocumentCategorySecondaryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentCategoryRepositoryImpl extends RepositoryImpl<DocumentCategory, Long> implements DocumentCategorySecondaryRepository {

    private DocumentCategorySecondaryRepository documentCategorySecondaryRepository;

    public DocumentCategoryRepositoryImpl(DocumentCategorySecondaryRepository documentCategorySecondaryRepository) {
        super(documentCategorySecondaryRepository);
        this.documentCategorySecondaryRepository = documentCategorySecondaryRepository;
    }

    @Override
    public Page<DocumentCategory> filter(CategoryFilter filter, Pageable pageable) {
        return this.documentCategorySecondaryRepository.filter(filter, pageable);
    }
}
