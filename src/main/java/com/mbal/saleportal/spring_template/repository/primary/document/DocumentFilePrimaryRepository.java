package com.mbal.saleportal.spring_template.repository.primary.document;


import com.mbal.saleportal.spring_template.entity.DocumentFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DocumentFilePrimaryRepository extends JpaRepository<DocumentFile, Long> {

    @Transactional(transactionManager = "transactionManagerWriteData")
    @Modifying
    @Query(value = "DELETE FROM DocumentFile f WHERE f.documentId = :documentId")
    void deleteByDocumentId(@Param("documentId") Long documentId);
}
