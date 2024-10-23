CREATE DATABASE demo_orm;

USE demo_orm;  

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
CREATE TABLE posts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);


INSERT INTO users (name) VALUES 
('Alice'), 
('Bob'), 
('Charlie'), 
('David'), 
('Eva'), 
('Frank'), 
('Grace'), 
('Hannah'), 
('Isaac'), 
('Julia');

INSERT INTO posts (title, content, user_id) VALUES 
('Post 1 by Alice', 'Content of post 1', 1),
('Post 2 by Alice', 'Content of post 2', 1),
('Post 1 by Bob', 'Content of post 1', 2),
('Post 1 by Charlie', 'Content of post 1', 3),
('Post 1 by David', 'Content of post 1', 4),
('Post 2 by Eva', 'Content of post 2', 5),
('Post 1 by Frank', 'Content of post 1', 6),
('Post 1 by Grace', 'Content of post 1', 7),
('Post 1 by Hannah', 'Content of post 1', 8),
('Post 1 by Julia', 'Content of post 1', 9);
