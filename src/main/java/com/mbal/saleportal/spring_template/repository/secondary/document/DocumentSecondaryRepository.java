package com.mbal.saleportal.spring_template.repository.secondary.document;


import com.mbal.saleportal.spring_template.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentSecondaryRepository extends JpaRepository<Document, Long> {

}
