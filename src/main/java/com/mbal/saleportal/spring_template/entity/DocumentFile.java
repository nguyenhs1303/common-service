package com.mbal.saleportal.spring_template.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "document_files")
@Entity
public class DocumentFile extends BaseEntity{

    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;

    @Column(name = "file_service_id")
    private Long fileServiceId;
    @Column(name = "file_aws_id")
    private Long fileAwsId;
    @Column(name = "document_id")
    private Long documentId;
    @Column(name = "size")
    private Long size;
    @Column(name = "file_type")
    private String fileType;


}
