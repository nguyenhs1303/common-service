package com.mbal.saleportal.spring_template.dto.document.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentSummaryResponse {

    private List<CountDocument> summaryCountForm;
    private Long notificationCount ;

}
