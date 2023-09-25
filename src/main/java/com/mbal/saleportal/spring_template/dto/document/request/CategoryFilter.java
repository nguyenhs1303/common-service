package com.mbal.saleportal.spring_template.dto.document.request;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.mbal.saleportal.spring_template.enums.document.DocumentType;
import com.mbal.saleportal.spring_template.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryFilter {

    private DocumentType type;
    private PageRequest page;

    @JsonSetter("type")
    public void setTypeFromString(String type) {
        try {
            this.type = DocumentType.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Vui lòng chọn `FORM` hoặc `NOTIFICATION` cho type");
        }
    }
}
