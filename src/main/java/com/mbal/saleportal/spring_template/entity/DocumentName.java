package com.mbal.saleportal.spring_template.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
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

    @Column(name = "document_category_id")
    private Long documentCategoryId;

    public DocumentName(String name) {
        this.name = name;
    }
}
