INSERT INTO public.document_categories
    (id, "name", status, document_type, created_at, updated_at)
VALUES
    (1, 'Thẩm định và phát hành hợp đồng', true, 'ALL', now(), now()),
    (2, 'Quản lý hợp đồng', true, 'ALL', now(), now()),
    (3, 'Giải quyết quyền lợi bảo hiểm', true, 'ALL', now(), now()),
    (4, 'Dịch vụ khách hàng', true, 'NOTIFICATION', now(), now());