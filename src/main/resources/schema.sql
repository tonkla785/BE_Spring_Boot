CREATE TABLE IF NOT EXISTS products(
    token_id VARCHAR(1000),
    product_date TIMESTAMP NOT NULL,
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR(250),
    product_price DECIMAL(10, 2),
    product_amount INT NOT NULL
);

CREATE TABLE IF NOT EXISTS sales (
    sale_id SERIAL PRIMARY KEY,
    sale_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    sale_name VARCHAR(250),
    sale_token_id VARCHAR(1000),
    sale_total DECIMAL(10, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS sale_details (
    sale_detail_id SERIAL PRIMARY KEY,
    sale_id INT NOT NULL REFERENCES sales(sale_id) ON DELETE CASCADE,
    product_id INT NOT NULL REFERENCES products(product_id),
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);