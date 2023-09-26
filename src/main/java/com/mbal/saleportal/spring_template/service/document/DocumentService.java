package com.mbal.saleportal.spring_template.service.document;

import com.mbal.saleportal.spring_template.dto.ApiBaseResponse;
import com.mbal.saleportal.spring_template.dto.PageBaseDto;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentRequest;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentUpdateRequest;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentFilterRequest;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentNameFilterRequest;
import com.mbal.saleportal.spring_template.dto.document.response.DocumentSummaryResponse;
import com.mbal.saleportal.spring_template.entity.Document;
import com.mbal.saleportal.spring_template.entity.DocumentName;

public interface DocumentService {
    ApiBaseResponse<PageBaseDto<Document>> getDocuments(DocumentFilterRequest request);
    ApiBaseResponse<PageBaseDto<DocumentName>> NameDocumentResponse(DocumentNameFilterRequest filter);
    ApiBaseResponse<Document> getDetailDocument(Long id);
    ApiBaseResponse<?> updateStatusDocuments(DocumentUpdateRequest request);
    ApiBaseResponse<?> createDocument(DocumentRequest request);
    ApiBaseResponse<DocumentSummaryResponse> summaryCountDocument();
    ApiBaseResponse<?> updateDocument(Long id, DocumentRequest request);
}
