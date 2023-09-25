-- Thẩm định và phát hành hợp đồng
INSERT INTO public.document_names
    ("name", "order", document_category_id, created_at, updated_at)
VALUES
    ('Yêu cầu bổ sung/thay đổi thông tin của HSYCBH', 1, 1, now(), now()),
    ('Bảng câu hỏi về bệnh', 2, 1, now(), now()),
    ('Yêu cầu hủy HSYCBH – HĐBH', 3, 1, now(), now()),
    ('Thư xác nhận chữ ký', 4, 1, now(), now());

-- Quản lý hợp đồng
INSERT INTO public.document_names
    ("name", "order", document_category_id, created_at, updated_at)
VALUES
    ('Thêm sản phẩm bổ trợ', 1, 2, now(), now()),
    ('Hủy sản phẩm bổ trợ', 2, 2, now(), now()),
    ('Kê khai thông tin sức khỏe', 3, 2, now(), now()),
    ('Chuyển nhượng Hợp đồng (dành cho doanh nghiệp)', 4, 2, now(), now()),
    ('Đóng phí bảo hiểm đóng thêm (UL)', 5, 2, now(), now()),
    ('Thay đổi định kỳ trả phí', 6, 2, now(), now()),
    ('Thông báo đi nước ngoài', 7, 2, now(), now()),
    ('Thay đổi thông tin Khách hàng', 8, 2, now(), now()),
    ('Thay đổi nghề nghiệp', 9, 2, now(), now()),
    ('In lại bộ Hợp đồng', 10, 2, now(), now()),
    ('Thay đổi chữ ký', 11, 2, now(), now()),
    ('Thay đổi CVTV', 12, 2, now(), now()),
    ('Thay đổi tên Khách hàng', 13, 2, now(), now()),
    ('Thay đổi người thụ hưởng', 14, 2, now(), now()),
    ('Thay đổi ID Khách hàng', 15, 2, now(), now()),
    ('Khôi phục hiệu lực Hợp đồng', 16, 2, now(), now()),
    ('Giấy Ủy Quyền', 17, 2, now(), now());

-- Giải quyết quyền lợi bảo hiểm
INSERT INTO public.document_names
    ("name", "order", document_category_id, created_at, updated_at)
VALUES
    ('Hướng dẫn thủ tục yêu cầu giải quyết quyền lợi bảo hiểm', 1, 3, now(), now()),
    ('Giấy ủy quyền thu thập thông tin (mẫu KH)', 2, 3, now(), now()),
    ('Hướng dẫn nộp mới và bổ sung chứng từ cho Yêu cầu giải quyết quyền lợi bảo hiểm HSCR 2022', 3, 3, now(), now()),
    ('Đơn yêu cầu giải quyết quyền lợi bảo hiểm mẫu CL05.2022', 4, 3, now(), now()),
    ('Bảng câu hỏi', 5, 3, now(), now());