package com.mbal.saleportal.spring_template.repository.secondary.document;


import com.mbal.saleportal.spring_template.entity.Document;
import com.mbal.saleportal.spring_template.enums.document.DocumentCategory;
import com.mbal.saleportal.spring_template.enums.document.DocumentType;
import com.mbal.saleportal.spring_template.enums.document.DocumentNotificationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface DocumentSecondaryRepository extends JpaRepository<Document, Long> {

    @Query(value = "SELECT d FROM Document d " +
            "WHERE (:documentType IS NULL OR d.type = :documentType ) " +
            "AND (:keyword IS NULL OR LOWER(d.name) LIKE CONCAT('%', LOWER(:keyword), '%') ) " +
            "AND (:documentCategory IS NULL OR d.documentCategory = :documentCategory) " +
            "AND (:notificationStatus IS NULL OR d.notificationStatus = :notificationStatus) " +
            "AND (:uploadStatus IS NULL OR d.uploadStatus = :uploadStatus)")
    Page<Document> filter(@Param("keyword") String keyword,
                          @Param("documentType") DocumentType documentType,
                          @Param("documentCategory") DocumentCategory documentCategory,
                          @Param("uploadStatus") Boolean uploadStatus,
                          @Param("notificationStatus") DocumentNotificationStatus notificationStatus,
//                          @Param("startCreatedAt") LocalDate startCreatedAt,
//                          @Param("endCreatedAt") LocalDate endCreatedAt,
//                          @Param("startUpdateAt") LocalDate startUpdateAt,
//                          @Param("endUpdateAt") LocalDate endUpdateAt,
                          Pageable pageable);
}
