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
@Table(name = "document_sub_types")
@Entity
public class DocumentSubType extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private Boolean status;

}
