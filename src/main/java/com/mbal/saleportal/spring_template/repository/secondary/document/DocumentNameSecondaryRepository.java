package com.mbal.saleportal.spring_template.repository.secondary.document;


import com.mbal.saleportal.spring_template.dto.document.request.FilterNameDocumentRequest;
import com.mbal.saleportal.spring_template.dto.document.response.NameDocumentResponse;
import com.mbal.saleportal.spring_template.entity.DocumentName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DocumentNameSecondaryRepository extends JpaRepository<DocumentName, Long> {

    @Query("")
    Page<NameDocumentResponse> filter(FilterNameDocumentRequest filter, Pageable pageable);
}
