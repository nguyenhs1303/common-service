package com.mbal.saleportal.spring_template.repository.secondary.document;


import com.mbal.saleportal.spring_template.entity.DocumentCategory;
import com.mbal.saleportal.spring_template.enums.document.DocumentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentCategorySecondaryRepository extends JpaRepository<DocumentCategory, Long> {

    @Query("SELECT c FROM DocumentCategory c WHERE ((:type) IS NULL OR c.documentType in :type)")
    Page<DocumentCategory> filter(@Param("type") List<DocumentType> types, Pageable pageable);


}
