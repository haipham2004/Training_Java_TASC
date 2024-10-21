CREATE DATABASE demo_db;
USE demo_db;


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



-- Demo join
SELECT c.name, o.order_date, o.total
FROM customers c
INNER JOIN orders o ON c.id = o.customer_id;

SELECT c.name, o.order_date, o.total
FROM customers c
LEFT JOIN orders o ON c.id = o.customer_id;

SELECT c.name, o.order_date, o.total
FROM customers c
RIGHT JOIN orders o ON c.id = o.customer_id;

-- Demo subquery: Lấy ra những customers không đặt hàng orders
SELECT c.*
FROM customers c
WHERE c.id NOT IN (SELECT o.customer_id FROM orders o);

-- Demo cte: Lấy ra thông tin tên KH và số lương đơn đặt
-- Tạo bảng tạm
WITH OrderCTE AS (
    SELECT customer_id, COUNT(*) AS order_count
    FROM orders
    GROUP BY customer_id
)
-- Truy vấn
SELECT c.name, o.order_count
FROM customers c
JOIN OrderCTE o ON c.id = o.customer_id;

-- Demo + Ranking : ROW_NUMBER, RANK, DENSE_RANK

SELECT c.name,
       SUM(o.total) AS total_buy,
       ROW_NUMBER() OVER (ORDER BY SUM(o.total) DESC) AS row_num
FROM customers c
JOIN orders o ON c.id = o.customer_id
GROUP BY c.id, c.name;


SELECT distinct c.name,
       SUM(o.total) AS total_buy,
       RANK() OVER (ORDER BY SUM(o.total) DESC) AS rank_num
FROM customers c
JOIN orders o ON c.id = o.customer_id
GROUP BY c.id, c.name;

SELECT c.name,
       SUM(o.total) AS total_buy,
       DENSE_RANK() OVER (ORDER BY SUM(o.total) DESC) AS dense_rank_num
FROM customers c
JOIN orders o ON c.id = o.customer_id
GROUP BY c.id, c.name;


-- --Demo view
-- Tạo bảng ảo view
CREATE VIEW customer_orders AS
SELECT c.id AS customer_id,
       c.name as name_customer,
       c.email,
       SUM(o.total) AS total_buy
FROM customers c
LEFT JOIN orders o ON c.id = o.customer_id
GROUP BY c.id, c.name,c.email;

SELECT * FROM customer_orders;
DROP VIEW customer_orders;



-- Demo PROCEDURE 


DELIMITER 
DROP PROCEDURE IF EXISTS Students;

CREATE PROCEDURE Students()
BEGIN
    SELECT 
        id,
        name,
        email
    FROM 
        customers
    ORDER BY 
        name;
END 
DELIMITER ;


DROP PROCEDURE IF EXISTS getIdOrder;

DELIMITER //

CREATE PROCEDURE getIdOrder(IN idOrders INT)
BEGIN
    SELECT * FROM orders o WHERE o.id = idOrders;
END //

DELIMITER ;

-- Gọi Stored Procedure
CALL Students();

Call getIdOrder(1)






