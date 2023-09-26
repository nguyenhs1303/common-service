package com.mbal.saleportal.spring_template.dto.document.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentUpdateRequest {

    @NotNull(message = "ids không được null")
    @Size(min = 1, message = "Ids phải chứa ít nhất một phần tử")
    private List<Long> ids;

    @NotNull(message = "status không được null")
    private Boolean status;
}
