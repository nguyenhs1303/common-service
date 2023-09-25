package com.mbal.saleportal.spring_template.entity;


import com.mbal.saleportal.spring_template.enums.document.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "document_categories")
@Entity
public class DocumentCategory extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private Boolean status;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_type")
    private DocumentType documentType;



}
