CREATE DATABASE demo_db3;
USE demo_db3;


CREATE TABLE timeS2 (
    id INT AUTO_INCREMENT,
    name VARCHAR(255),
    order_date DATE,
    total DECIMAL(10, 2),
    PRIMARY KEY (id, order_date)  -- Thêm order_date vào khóa chính
)
PARTITION BY RANGE (YEAR(order_date)) (
    PARTITION p2021 VALUES LESS THAN (2022),
    PARTITION p2022 VALUES LESS THAN (2023),
    PARTITION p2023 VALUES LESS THAN (2024),
    PARTITION p2024 VALUES LESS THAN (2025),
    PARTITION p2025 VALUES LESS THAN (2026)
);


INSERT INTO timeS2 (name, order_date, total) VALUES
('Order 1', '2021-01-01', 150.00),
('Order 2', '2021-05-15', 200.00),
('Order 3', '2022-02-10', 250.00),
('Order 4', '2022-08-20', 300.00),
('Order 5', '2023-01-05', 400.00),
('Order 6', '2023-03-15', 100.00),
('Order 7', '2024-04-10', 75.00),
('Order 8', '2024-04-25', 120.00),
('Order 9', '2025-05-10', 250.00),
('Order 10', '2025-09-15', 500.00);

SELECT * 
FROM information_schema.partitions 
WHERE table_name = 'timeS2';

SELECT YEAR(order_date) AS year, SUM(total) AS total_amount
FROM timeS2
GROUP BY YEAR(order_date);




