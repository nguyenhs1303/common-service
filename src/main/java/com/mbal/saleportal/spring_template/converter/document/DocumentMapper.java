package com.mbal.saleportal.spring_template.converter.document;

import com.mbal.saleportal.spring_template.dto.document.request.DocumentFileRequest;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentRequest;
import com.mbal.saleportal.spring_template.dto.document.response.DocumentFileResponse;
import com.mbal.saleportal.spring_template.dto.document.response.DocumentResponse;
import com.mbal.saleportal.spring_template.entity.Document;
import com.mbal.saleportal.spring_template.entity.DocumentFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DocumentMapper {

    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    @Mapping(target = "effectiveDate", expression = "java(com.mbal.saleportal.spring_template.util.DateUtils.stringToLocalDate(request.getEffectiveDate(), com.mbal.saleportal.spring_template.util.DateUtils.PATTERN_DDmmyyyy))")
    @Mapping(target = "expirationDate", expression = "java(com.mbal.saleportal.spring_template.util.DateUtils.stringToLocalDate(request.getExpirationDate(), com.mbal.saleportal.spring_template.util.DateUtils.PATTERN_DDmmyyyy))")
    Document documentRequestToEntity(DocumentRequest request);
    DocumentFile documentFileRequestToEntity(DocumentFileRequest request);

    DocumentResponse documentEntityToResponse(Document document);

    DocumentFileResponse documentFileEntityToResponse(DocumentFile documentFile);
}
