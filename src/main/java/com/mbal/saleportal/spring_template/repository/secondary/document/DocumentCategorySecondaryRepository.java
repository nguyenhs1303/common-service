package com.mbal.saleportal.spring_template.repository.secondary.document;


import com.mbal.saleportal.spring_template.dto.document.request.CategoryFilter;
import com.mbal.saleportal.spring_template.entity.DocumentCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DocumentCategorySecondaryRepository extends JpaRepository<DocumentCategory, Long> {

    @Query("SELECT c FROM DocumentCategory c WHERE " +
            "(:#{#filter.type} IS NULL OR c.documentType = :#{#filter.type})")
    Page<DocumentCategory> filter(@Param("filter") CategoryFilter filter, Pageable pageable);

}
