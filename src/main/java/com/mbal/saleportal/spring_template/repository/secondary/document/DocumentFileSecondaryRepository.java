package com.mbal.saleportal.spring_template.repository.secondary.document;


import com.mbal.saleportal.spring_template.entity.DocumentFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentFileSecondaryRepository extends JpaRepository<DocumentFile, Long> {

    @Query(value = "SELECT f FROM DocumentFile f " +
            "WHERE f.documentId = :documentId ")
    List<DocumentFile> findByDocumentId(@Param("documentId") Long documentId);
}
