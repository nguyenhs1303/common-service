-- Thẩm định và phát hành hợp đồng
INSERT INTO public.document_names
    ("name", "order", document_category, created_at, updated_at)
VALUES ('Yêu cầu bổ sung/thay đổi thông tin của HSYCBH', 1, 'ASSESSMENT_AND_CONTRACT_ISSUANCE', now(), now()),
       ('Bảng câu hỏi về bệnh', 2, 'ASSESSMENT_AND_CONTRACT_ISSUANCE', now(), now()),
       ('Yêu cầu hủy HSYCBH – HĐBH', 3, 'ASSESSMENT_AND_CONTRACT_ISSUANCE', now(), now()),
       ('Thư xác nhận chữ ký', 4, 'ASSESSMENT_AND_CONTRACT_ISSUANCE', now(), now());

-- Quản lý hợp đồng
INSERT INTO public.document_names
    ("name", "order", document_category, created_at, updated_at)
VALUES ('Thêm sản phẩm bổ trợ', 1, 'CONTRACT_MANAGEMENT', now(), now()),
       ('Hủy sản phẩm bổ trợ', 2, 'CONTRACT_MANAGEMENT', now(), now()),
       ('Kê khai thông tin sức khỏe', 3, 'CONTRACT_MANAGEMENT', now(), now()),
       ('Chuyển nhượng Hợp đồng (dành cho doanh nghiệp)', 4, 'CONTRACT_MANAGEMENT', now(), now()),
       ('Đóng phí bảo hiểm đóng thêm (UL)', 5, 'CONTRACT_MANAGEMENT', now(), now()),
       ('Thay đổi định kỳ trả phí', 6, 'CONTRACT_MANAGEMENT', now(), now()),
       ('Thông báo đi nước ngoài', 7, 'CONTRACT_MANAGEMENT', now(), now()),
       ('Thay đổi thông tin Khách hàng', 8, 'CONTRACT_MANAGEMENT', now(), now()),
       ('Thay đổi nghề nghiệp', 9, 'CONTRACT_MANAGEMENT', now(), now()),
       ('In lại bộ Hợp đồng', 10, 'CONTRACT_MANAGEMENT', now(), now()),
       ('Thay đổi chữ ký', 11, 'CONTRACT_MANAGEMENT', now(), now()),
       ('Thay đổi CVTV', 12, 'CONTRACT_MANAGEMENT', now(), now()),
       ('Thay đổi tên Khách hàng', 13, 'CONTRACT_MANAGEMENT', now(), now()),
       ('Thay đổi người thụ hưởng', 14, 'CONTRACT_MANAGEMENT', now(), now()),
       ('Thay đổi ID Khách hàng', 15, 'CONTRACT_MANAGEMENT', now(), now()),
       ('Khôi phục hiệu lực Hợp đồng', 16, 'CONTRACT_MANAGEMENT', now(), now()),
       ('Giấy Ủy Quyền', 17, 'CONTRACT_MANAGEMENT', now(), now());

-- Giải quyết quyền lợi bảo hiểm
INSERT INTO public.document_names
    ("name", "order", document_category, created_at, updated_at)
VALUES ('Hướng dẫn thủ tục yêu cầu giải quyết quyền lợi bảo hiểm', 1, 'INSURANCE_CLAIM_RESOLUTION', now(), now()),
       ('Giấy ủy quyền thu thập thông tin (mẫu KH)', 2, 'INSURANCE_CLAIM_RESOLUTION', now(), now()),
       ('Hướng dẫn nộp mới và bổ sung chứng từ cho Yêu cầu giải quyết quyền lợi bảo hiểm HSCR 2022', 3, 'INSURANCE_CLAIM_RESOLUTION', now(), now()),
       ('Đơn yêu cầu giải quyết quyền lợi bảo hiểm mẫu CL05.2022', 4, 'INSURANCE_CLAIM_RESOLUTION', now(), now()),
       ('Bảng câu hỏi', 5, 'INSURANCE_CLAIM_RESOLUTION', now(), now());