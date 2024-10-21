CREATE DATABASE demo_store_procedure;

USE demo_store_procedure;

CREATE TABLE IF NOT EXISTS SanPham (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    TenSanPham VARCHAR(100) NOT NULL,
    Gia DECIMAL(10, 2) NOT NULL,
    SoLuong INT NOT NULL
);


INSERT INTO SanPham (TenSanPham, Gia, SoLuong) VALUES
('Sản phẩm A', 100.00, 50),
('Sản phẩm B', 150.00, 30),
('Sản phẩm C', 200.00, 20);

DROP PROCEDURE IF EXISTS LayThongTinSanPham;
DELIMITER //
CREATE PROCEDURE LayThongTinSanPham(IN p_ID INT)
BEGIN
    SELECT TenSanPham, Gia, SoLuong
    FROM SanPham
    WHERE ID = p_ID;
END //


DELIMITER ;

CALL LayThongTinSanPham(2);

DROP PROCEDURE IF EXISTS LayThongTinSanPham;
DELIMITER //

CREATE PROCEDURE LayThongTinSanPham(IN SanPhamID INT)
BEGIN
    IF EXISTS (SELECT * FROM SanPham WHERE ID = SanPhamID) THEN
        -- Lấy thông tin khách hàng
        SELECT *
        FROM SanPham
        WHERE ID = SanPhamID;
    ELSE
        SELECT 'Sản phẩm không tồn tại.' AS Message;
    END IF;
END //

DELIMITER ;

CALL LayThongTinSanPham(7);



