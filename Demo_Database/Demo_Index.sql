CREATE DATABASE demo_db2;
USE demo_db2;


CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);


CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    total DECIMAL(10, 2),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);


INSERT INTO customers (name, email) VALUES
('Hải', 'bophamnb2004@gmail.com'),
('Hằng', 'hangntt35@gmail.com'),
('Khanh', 'khanhnt35@gmail.com'),
('Hoa', 'nam@example.com'),
('Khánh', 'an@example.com');


INSERT INTO orders (customer_id, order_date, total) VALUES
(1, NOW(), 150.00),
(1, NOW(), 200.00),
(1, NOW(), 300.00),
(2, NOW(), 50.00),
(1, NOW(), 100.00),
(2, NOW(), 75.00),
(3, NOW(), 150.00),
(3, NOW(), 150.00),
(2, NOW(), 200.00),
(4, NOW(), 225.00),
(4, NOW(), 100.00),
(5, NOW(), 100.00);

SHOW INDEX FROM customers;

SHOW INDEX FROM orders;

-- Tạo chỉ mục email cho bảng customers
CREATE INDEX idx_email ON customers(email);


-- Truy vấn tìm kiếm đơn hàng theo khách hàng
SELECT * FROM orders WHERE customer_id = 1;

-- Kiểm tra kế hoạch thực thi cho truy vấn tìm kiếm khách hàng theo email
EXPLAIN SELECT * FROM customers WHERE email = 'bophamnb2004@gmail.com';

-- Kiểm tra kế hoạch thực thi cho truy vấn tìm kiếm đơn hàng theo khách hàng
EXPLAIN SELECT * FROM orders WHERE customer_id = 1;










