package com.mbal.saleportal.spring_template.repository.secondary.document;


import com.mbal.saleportal.spring_template.dto.document.response.CountDocument;
import com.mbal.saleportal.spring_template.entity.Document;
import com.mbal.saleportal.spring_template.enums.SalePortalChannel;
import com.mbal.saleportal.spring_template.enums.document.DocumentCategory;
import com.mbal.saleportal.spring_template.enums.document.DocumentNotificationStatus;
import com.mbal.saleportal.spring_template.enums.document.DocumentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface DocumentSecondaryRepository extends JpaRepository<Document, Long> {

    @Query(value = "SELECT d FROM Document d " +
            "JOIN DocumentName n ON n.id = d.documentNameId " +
            "WHERE (:documentType IS NULL OR d.type = :documentType ) " +
            "AND (:keyword IS NULL OR LOWER(d.name) LIKE CONCAT('%', LOWER(:keyword), '%') ) " +
            "AND (:documentCategory IS NULL OR d.documentCategory = :documentCategory) " +
            "AND (:channel IS NULL OR d.channel = :channel) " +
            "AND (:notificationStatus IS NULL OR d.notificationStatus = :notificationStatus) " +
            "AND ((COALESCE(:startCreatedAt, NULL) IS NULL OR  (COALESCE(:endCreatedAt, NULL) IS NULL)) OR (d.createdAt BETWEEN :startCreatedAt AND :endCreatedAt)) " +
            "AND ((COALESCE(:startUpdateAt, NULL) IS NULL OR  (COALESCE(:endUpdateAt, NULL) IS NULL)) OR (d.updatedAt BETWEEN :startUpdateAt AND :endUpdateAt)) " +
            "AND ((COALESCE(:startEffectiveDate, NULL) IS NULL OR  (COALESCE(:endEffectiveDate, NULL) IS NULL)) OR (d.effectiveDate BETWEEN :startEffectiveDate AND :endEffectiveDate)) " +
            "AND ((COALESCE(:startExpirationDate, NULL) IS NULL OR  (COALESCE(:endExpirationDate, NULL) IS NULL)) OR (d.expirationDate BETWEEN :startExpirationDate AND :endExpirationDate)) " +
            "AND (:uploadStatus IS NULL OR d.uploadStatus = :uploadStatus) " +
            "ORDER BY n.order ASC , d.uploadStatus DESC")
    Page<Document> filter(@Param("keyword") String keyword,
                          @Param("documentType") DocumentType documentType,
                          @Param("documentCategory") DocumentCategory documentCategory,
                          @Param("channel") SalePortalChannel channel,
                          @Param("uploadStatus") Boolean uploadStatus,
                          @Param("notificationStatus") DocumentNotificationStatus notificationStatus,
                          @Param("startCreatedAt") Timestamp startCreatedAt,
                          @Param("endCreatedAt") Timestamp endCreatedAt,
                          @Param("startUpdateAt") Timestamp startUpdateAt,
                          @Param("endUpdateAt") Timestamp endUpdateAt,
                          @Param("startEffectiveDate") Timestamp startEffectiveDate,
                          @Param("endEffectiveDate") Timestamp endEffectiveDate,
                          @Param("startExpirationDate") Timestamp startExpirationDate,
                          @Param("endExpirationDate") Timestamp endExpirationDate,
                          Pageable pageable);


    @Query(value = "SELECT new com.mbal.saleportal.spring_template.dto.document.response.CountDocument(COUNT(d), d.documentCategory) FROM Document d " +
            "WHERE d.type = :type AND d.uploadStatus = :uploadStatus " +
            "GROUP BY d.documentCategory")
    List<CountDocument> countDocumentByTypeAndUploadStatusAndGroupByCategory(@Param("type") DocumentType type, @Param("uploadStatus") Boolean uploadStatus );


    @Query(value = "SELECT d FROM Document d WHERE d.id IN (:ids)")
    List<Document> findByIds(@Param("ids") List<Long> ids);
}
