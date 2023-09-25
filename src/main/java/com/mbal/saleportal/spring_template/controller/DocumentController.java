package com.mbal.saleportal.spring_template.controller;

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
import com.mbal.saleportal.spring_template.service.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    public ApiBaseResponse<DocumentResponse> getDocuments(@RequestBody FilterDocumentRequest request){
        return documentService.getDocuments(request);
    }

    @PostMapping
    public ApiBaseResponse<?> createDocument(@RequestBody @Valid DocumentRequest request){
        return documentService.createDocument(request);
    }

    @PutMapping("update-status")
    public ApiBaseResponse<?> updateStatusDocument(@RequestBody DocumentUpdateRequest request){
        return documentService.updateStatusDocuments(request);
    }

    @GetMapping("detail/{id}")
    public ApiBaseResponse<?> getDetailDocument(@PathVariable(name = "id") Long id){
        return documentService.getDetailDocument(id);
    }

    @PostMapping("names")
    public ApiBaseResponse<PageBaseDto<NameDocumentResponse>> getNameForm(@RequestBody FilterNameDocumentRequest filter){
        return documentService.NameDocumentResponse(filter);
    }

    @GetMapping("categories")
    public ApiBaseResponse<PageBaseDto<DocumentCategory>> getCategories(@RequestBody @Valid CategoryFilter filter){
        return documentService.getCategories(filter);
    }

    @GetMapping("summary")
    public ApiBaseResponse<SummaryDocument> summaryDocument(){
        return documentService.summaryDocument();
    }
}
