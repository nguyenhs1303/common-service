package com.mbal.saleportal.spring_template.enums.document;

import com.mbal.saleportal.spring_template.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DocumentCategory {

    ASSESSMENT_AND_CONTRACT_ISSUANCE("Thẩm định và phát hành hợp đồng", DocumentType.ALL),
    CONTRACT_MANAGEMENT("Quản lý hợp đồng", DocumentType.ALL),
    INSURANCE_CLAIM_RESOLUTION("Giải quyết quyền lợi bảo hiểm", DocumentType.ALL),
    CUSTOMER_SERVICE("Dịch vụ khách hàng", DocumentType.NOTIFICATION);

    private final String vietnameseName;
    private final DocumentType documentType;

    public static void checkCategory(String documentCategory) {
        try {
            valueOf(documentCategory);
        }catch (Exception e){
            throw new BadRequestException(DocumentResponseMessage.DOCUMENT_CATEGORY_INVALID);
        }
    }

    public static DocumentCategory convertFromString(String documentCategory) {
        try {
            return valueOf(documentCategory);
        }catch (Exception e){
            return null;
        }
    }
}
