package com.mbal.saleportal.spring_template.repository.primary.document;


import com.mbal.saleportal.spring_template.entity.DocumentFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentFilePrimaryRepository extends JpaRepository<DocumentFile, Long> {

}
