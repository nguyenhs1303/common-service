package com.mbal.saleportal.spring_template.repository.primary.document;


import com.mbal.saleportal.spring_template.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentPrimaryRepository extends JpaRepository<Document, Long> {

}
