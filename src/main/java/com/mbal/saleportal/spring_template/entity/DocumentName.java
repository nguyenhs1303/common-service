package com.mbal.saleportal.spring_template.entity;


import com.mbal.saleportal.spring_template.enums.document.DocumentCategory;
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
@Table(name = "document_names")
@Entity
public class DocumentName extends BaseEntity{

    @Column(name = "order")
    private Integer order;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_category")
    private DocumentCategory documentCategory;

    public DocumentName(String name) {
        this.name = name;
    }
}
