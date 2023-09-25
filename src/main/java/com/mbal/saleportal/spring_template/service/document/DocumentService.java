package com.mbal.saleportal.spring_template.service.document;

import com.mbal.saleportal.spring_template.dto.ApiBaseResponse;
import com.mbal.saleportal.spring_template.dto.PageBaseDto;
import com.mbal.saleportal.spring_template.dto.document.request.CategoryFilter;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentRequest;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentUpdateRequest;
import com.mbal.saleportal.spring_template.dto.document.request.FilterDocumentRequest;
import com.mbal.saleportal.spring_template.dto.document.request.FilterNameDocumentRequest;
import com.mbal.saleportal.spring_template.dto.document.response.DocumentResponse;
import com.mbal.saleportal.spring_template.dto.document.response.NameDocumentResponse;
import com.mbal.saleportal.spring_template.dto.document.response.SubTypeDocumentResponse;
import com.mbal.saleportal.spring_template.dto.document.response.SummaryDocument;
import com.mbal.saleportal.spring_template.entity.DocumentCategory;

public interface DocumentService {
    ApiBaseResponse<DocumentResponse> getDocuments(FilterDocumentRequest request);

    ApiBaseResponse<PageBaseDto<NameDocumentResponse>> NameDocumentResponse(FilterNameDocumentRequest filter);

    ApiBaseResponse<PageBaseDto<DocumentCategory>> getCategories(CategoryFilter filter);

    ApiBaseResponse<?> getDetailDocument(Long id);

    ApiBaseResponse<?> updateStatusDocuments(DocumentUpdateRequest request);

    ApiBaseResponse<?> createDocument(DocumentRequest request);

    ApiBaseResponse<SummaryDocument> summaryDocument();

}
