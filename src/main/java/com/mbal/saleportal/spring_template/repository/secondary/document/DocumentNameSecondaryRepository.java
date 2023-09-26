package com.mbal.saleportal.spring_template.repository.secondary.document;


import com.mbal.saleportal.spring_template.dto.document.request.DocumentNameFilterRequest;
import com.mbal.saleportal.spring_template.entity.DocumentName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DocumentNameSecondaryRepository extends JpaRepository<DocumentName, Long> {

    @Query("SELECT n FROM DocumentName n " +
            "WHERE (:#{#filter.keyword} IS NULL OR (LOWER(n.name) LIKE CONCAT('%', LOWER(:#{#filter.keyword}), '%')))" +
            "AND (:#{#filter.documentCategory} IS NULL OR (n.documentCategory = :#{#filter.documentCategory}))")
    Page<DocumentName> filter(@Param("filter") DocumentNameFilterRequest filter, Pageable pageable);


}
