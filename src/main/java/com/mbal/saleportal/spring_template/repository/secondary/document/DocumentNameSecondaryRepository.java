package com.mbal.saleportal.spring_template.repository.secondary.document;


import com.mbal.saleportal.spring_template.entity.DocumentName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentNameSecondaryRepository extends JpaRepository<DocumentName, Long> {

}
