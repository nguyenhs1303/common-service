package com.mbal.saleportal.spring_template.dto.document.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NameDocumentResponse {

    private Long id;
    private String name;
    private Integer order;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
