package com.mbal.saleportal.spring_template.controller;

import com.mbal.saleportal.spring_template.dto.ApiBaseResponse;
import com.mbal.saleportal.spring_template.dto.PageBaseDto;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentRequest;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentUpdateRequest;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentFilterRequest;
import com.mbal.saleportal.spring_template.dto.document.request.DocumentNameFilterRequest;
import com.mbal.saleportal.spring_template.dto.document.response.DocumentSummaryResponse;
import com.mbal.saleportal.spring_template.entity.Document;
import com.mbal.saleportal.spring_template.entity.DocumentName;
import com.mbal.saleportal.spring_template.service.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v2/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("filter")
    public ApiBaseResponse<PageBaseDto<Document>> getDocuments(@RequestBody DocumentFilterRequest request){
        return documentService.getDocuments(request);
    }

    @PostMapping
    public ApiBaseResponse<?> createDocument(@RequestBody @Valid DocumentRequest request) {
        return documentService.createDocument(request);
    }

    @PutMapping("update/{id}")
    public ApiBaseResponse<?> updateDocument(@RequestBody @Valid DocumentRequest request, @PathVariable(name = "id") Long id) {
        return documentService.updateDocument(id, request);
    }

    @PutMapping("update-status")
    public ApiBaseResponse<?> updateStatusDocument(@RequestBody @Valid DocumentUpdateRequest request) {
        return documentService.updateStatusDocuments(request);
    }

    @GetMapping("detail/{id}")
    public ApiBaseResponse<Document> getDetailDocument(@PathVariable(name = "id") Long id) {
        return documentService.getDetailDocument(id);
    }

    @PostMapping("names")
    public ApiBaseResponse<PageBaseDto<DocumentName>> getNameForm(@RequestBody DocumentNameFilterRequest filter) {
        return documentService.NameDocumentResponse(filter);
    }

    @GetMapping("summary-count")
    public ApiBaseResponse<DocumentSummaryResponse> summaryCountDocument() {
        return documentService.summaryCountDocument();
    }
}
