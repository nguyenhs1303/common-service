package com.mbal.saleportal.spring_template.entity;

import com.mbal.saleportal.spring_template.enums.SalePortalChannel;
import com.mbal.saleportal.spring_template.enums.document.DocumentType;
import com.mbal.saleportal.spring_template.enums.document.DocumentUserType;
import com.mbal.saleportal.spring_template.enums.document.NotificationDocumentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "documents")
@Entity
public class Document extends BaseEntity{

    @Column(name = "document_name_id")
    private Long documentNameId;

    @Column(name = "name")
    private String name;

    @Column(name = "effective_date")
    private LocalDate effectiveDate;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "upload_status")
    private Boolean uploadStatus;

    @Column(name = "type")
    private DocumentType type;

    @Column(name = "channel")
    private SalePortalChannel channel;

    @Column(name = "users_type")
    private DocumentUserType userType;

    @Column(name = "notification_status")
    private NotificationDocumentStatus notificationStatus;

}
