package com.mbal.saleportal.spring_template.dto.document.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SummaryDocument {

    private List<FormSummary> formSummaries;
    private List<NotificationSummary> notificationSummaries;

}
