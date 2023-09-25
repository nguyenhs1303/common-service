package com.mbal.saleportal.spring_template.repository.primary.document;


import com.mbal.saleportal.spring_template.entity.DocumentName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentNamePrimaryRepository extends JpaRepository<DocumentName, Long> {

}
