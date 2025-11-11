---- Create orders table
CREATE TABLE IF NOT EXISTS orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255),
    order_status VARCHAR(50),
    local_date_time TIMESTAMP
);
--
---- Create order_items table
CREATE TABLE IF NOT EXISTS order_items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255),
    quantity INT,
    price DOUBLE,
    order_id BIGINT,
    FOREIGN KEY (order_id) REFERENCES orders(id)
);

-- Insert dummy data into the orders table
INSERT INTO orders (customer_name, order_status, local_date_time) VALUES
('John Doe', 'PENDING', '2023-10-01T10:00:00'),
('Jane Smith', 'PROCESSING', '2023-10-02T11:00:00'),
('Alice Johnson', 'SHIPPED', '2023-10-03T12:00:00');

-- Insert dummy data into the order_items table
INSERT INTO order_items (product_name, quantity, price, order_id) VALUES
('Product A', 2, 19.99, 1),
('Product B', 1, 9.99, 1),
('Product C', 5, 4.99, 2),
('Product D', 3, 14.99, 3);

COMMIT;

