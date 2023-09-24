package com.mbal.saleportal.spring_template.converter.document;

import com.mbal.saleportal.spring_template.dto.document.request.DocumentFileRequest;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentRequest;
import com.mbal.saleportal.spring_template.entity.Document;
import com.mbal.saleportal.spring_template.entity.DocumentFile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DocumentMapper {

    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    Document documentRequestToEntity(DocumentRequest request);
    DocumentFile documentFileRequestToEntity(DocumentFileRequest request);

}
