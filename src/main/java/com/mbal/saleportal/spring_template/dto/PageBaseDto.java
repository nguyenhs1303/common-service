package com.mbal.saleportal.spring_template.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageBaseDto<T> {

    private Long totalElements;
    private Integer totalPages;
    private Integer page;
    private Integer size;
    private List<T> content;

}
