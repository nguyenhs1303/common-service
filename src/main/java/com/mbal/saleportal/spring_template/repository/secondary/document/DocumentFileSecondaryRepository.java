package com.mbal.saleportal.spring_template.repository.secondary.document;


import com.mbal.saleportal.spring_template.entity.DocumentFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentFileSecondaryRepository extends JpaRepository<DocumentFile, Long> {

}
