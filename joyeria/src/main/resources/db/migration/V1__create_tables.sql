
/*START SECURITY TABLES*/
CREATE TABLE IF NOT EXISTS tb_authorities(
    authority_id VARCHAR(6) NOT NULL,
    authority VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY (authority_id)
);

INSERT INTO tb_authorities (authority_id, authority) VALUES
('AUT001', 'READ'),
('AUT002', 'CREATE'),
('AUT003', 'UPDATE'),
('AUT004', 'DELETE'),
('AUT005', 'REFACTOR');

CREATE TABLE IF NOT EXISTS tb_roles(
    role_id VARCHAR(6) NOT NULL,
    role_name VARCHAR(30) UNIQUE,
    PRIMARY KEY (role_id)
);

INSERT INTO tb_roles (role_id, role_name) VALUES
('RLE001', 'ADMIN'),
('RLE002', 'USER'),
('RLE003', 'INVITED');
/*END SECURITY TABLES*/

/*START BUSINESS TABLES*/
CREATE TABLE IF NOT EXISTS tb_customer(
    customer_id VARCHAR(6) NOT NULL,
    username VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    phone VARCHAR(11) NOT NULL UNIQUE,
    address VARCHAR(100) NOT NULL,
    PRIMARY KEY (customer_id)
);

CREATE TABLE IF NOT EXISTS tb_payment(
    payment_id VARCHAR(6),
    customer_id VARCHAR(6) NOT NULL,
    payment_date DATETIME NOT NULL,
    payment_method VARCHAR(100) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (payment_id),
    CONSTRAINT fk_payment_customer FOREIGN KEY (customer_id) REFERENCES tb_customer(customer_id)
);

CREATE TABLE IF NOT EXISTS tb_product(
    product_id VARCHAR(6),
    product_name VARCHAR(50) NOT NULL,
    description TEXT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    stock INTEGER NOT NULL,
    img MEDIUMBLOB NOT NULL,
    PRIMARY KEY (product_id)
);

CREATE TABLE IF NOT EXISTS tb_shipment(
    shipment_id VARCHAR(6),
    customer_id VARCHAR(6) NOT NULL,
    shipment_date DATETIME NOT NULL,
    address VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    zip_code VARCHAR(10) NOT NULL,
    PRIMARY KEY (shipment_id),
    CONSTRAINT fk_shipment_customer FOREIGN KEY (customer_id) REFERENCES tb_customer(customer_id)
);

CREATE TABLE IF NOT EXISTS tb_order(
    order_id VARCHAR(6),
    customer_id VARCHAR(6),
    shipment_id VARCHAR(6),
    payment_id VARCHAR(6),
    order_date DATETIME NOT NULL,
    total_price DECIMAL(10,2),
    PRIMARY KEY (order_id),
    CONSTRAINT fk_order_customer FOREIGN KEY (customer_id) REFERENCES tb_customer(customer_id),
    CONSTRAINT fk_order_shipment FOREIGN KEY (shipment_id) REFERENCES tb_shipment(shipment_id),
    CONSTRAINT fk_order_payment FOREIGN KEY (payment_id) REFERENCES tb_payment(payment_id)
);
/*END BUSINESS TABLES*/

/*INTERMEDIATES TABLES*/
CREATE TABLE IF NOT EXISTS role_authority(
    role_id VARCHAR(6) NOT NULL,
    authority_id VARCHAR(6) NOT NULL,
    PRIMARY KEY (role_id, authority_id),
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES tb_roles(role_id),
    CONSTRAINT fk_authority FOREIGN KEY (authority_id) REFERENCES tb_authorities(authority_id)
);

/*INSERT ROWS IN TABLE role_authority*/
INSERT INTO role_authority (role_id, authority_id) VALUES
('RLE001', 'AUT001'),  -- Rol ADMIN has authority READ
('RLE001', 'AUT002'),  -- Rol ADMIN has authority CREATE
('RLE001', 'AUT003'),  -- Rol ADMIN has authority UPDATE
('RLE001', 'AUT004'),  -- Rol ADMIN has authority DELETE
('RLE002', 'AUT001'),  -- Rol USER has authority READ
('RLE002', 'AUT002'),  -- Rol USER has authority CREATE
('RLE003', 'AUT001');  -- Rol INVITED has authority READ

CREATE TABLE IF NOT EXISTS customer_role(
    customer_id VARCHAR(6) NOT NULL,
    role_id VARCHAR(6) NOT NULL,
    PRIMARY KEY (customer_id, role_id),
    CONSTRAINT fk_customer_role_customer_id FOREIGN KEY (customer_id) REFERENCES tb_customer(customer_id),
    CONSTRAINT fk_customer_role_role_id FOREIGN KEY (role_id) REFERENCES tb_roles(role_id)
);

CREATE TABLE IF NOT EXISTS order_item(
    product_id VARCHAR(6) NOT NULL,
    order_id VARCHAR(6) NOT NULL,
    PRIMARY KEY (order_id, product_id),
    quantity INTEGER NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES tb_product(product_id),
    CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES tb_order(order_id)
);

/*END INTERMEDIATES TABLES*/