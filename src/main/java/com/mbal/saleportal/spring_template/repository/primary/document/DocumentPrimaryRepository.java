package com.mbal.saleportal.spring_template.repository.primary.document;


import com.mbal.saleportal.spring_template.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface DocumentPrimaryRepository extends JpaRepository<Document, Long> {


    @Transactional
    @Modifying
    @Query(value = "UPDATE Document d " +
            "SET d.uploadStatus = :status " +
            "WHERE d.documentNameId IN (:documentCategoryId) ")
    void updateUploadStatusByDocumentNameId(@Param("documentCategoryId") Long documentCategoryId,@Param("status") boolean status);
}
