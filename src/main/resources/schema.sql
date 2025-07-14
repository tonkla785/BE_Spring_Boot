CREATE TABLE IF NOT EXISTS products(
    token_id VARCHAR(1000),
    product_date TIMESTAMP NOT NULL,
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR(250),
    product_price DECIMAL(10, 2),
    product_amount INTEGER
);