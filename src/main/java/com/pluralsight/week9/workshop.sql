-- Drop and recreate the database
DROP DATABASE IF EXISTS dealer;
CREATE DATABASE dealer;
USE dealer;

-- Table 1: dealerships
CREATE TABLE dealerships (
    dealership_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(50),
    phone VARCHAR(12)
);

-- Table 2: vehicles
CREATE TABLE vehicles (
    VIN VARCHAR(17) PRIMARY KEY,
    make VARCHAR(30) NOT NULL,
    model VARCHAR(30) NOT NULL,
    year INT NOT NULL,
    color VARCHAR(20),
    mileage INT,
    price DECIMAL(10, 2),
    SOLD BOOLEAN DEFAULT FALSE
);

-- Table 3: inventory
CREATE TABLE inventory (
    dealership_id INT NOT NULL,
    VIN VARCHAR(17) NOT NULL,
    PRIMARY KEY (dealership_id, VIN),
    FOREIGN KEY (dealership_id) REFERENCES dealerships(dealership_id) ON DELETE CASCADE,
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN) ON DELETE CASCADE
);

-- Table 4: sales_contracts
CREATE TABLE sales_contracts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    VIN VARCHAR(17) NOT NULL,
    customer_name VARCHAR(50) NOT NULL,
    customer_phone VARCHAR(12),
    sale_price DECIMAL(10, 2) NOT NULL,
    sale_date DATE NOT NULL,
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN) ON DELETE CASCADE
);

-- Table 5: lease_contracts
CREATE TABLE lease_contracts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    VIN VARCHAR(17) NOT NULL,
    customer_name VARCHAR(50) NOT NULL,
    customer_phone VARCHAR(12),
    lease_term_months INT NOT NULL,
    monthly_payment DECIMAL(10, 2) NOT NULL,
    lease_start_date DATE NOT NULL,
    lease_end_date DATE NOT NULL,
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN) ON DELETE CASCADE
);

-- Populate dealerships
INSERT INTO dealerships (name, address, phone)
VALUES
    ('Sunrise Motors', '123 Elm St', '555-1234'),
    ('Downtown Auto', '456 Oak Ave', '555-5678'),
    ('Highland Vehicles', '789 Pine Rd', '555-9012');

-- Populate vehicles
INSERT INTO vehicles (VIN, make, model, year, color, mileage, price, SOLD)
VALUES
    ('1HGCM82633A123456', 'Honda', 'Civic', 2020, 'Blue', 15000, 20000.00, FALSE),
    ('1FTFW1ET3EKF51234', 'Ford', 'F-150', 2021, 'Red', 8000, 35000.00, TRUE),
    ('5YJ3E1EA7KF312345', 'Tesla', 'Model 3', 2022, 'White', 5000, 45000.00, FALSE),
    ('3VW2B7AJ9FM512345', 'Volkswagen', 'Jetta', 2019, 'Black', 30000, 15000.00, TRUE);

-- Populate inventory
INSERT INTO inventory (dealership_id, VIN)
VALUES
    (1, '1HGCM82633A123456'), -- Honda Civic at Sunrise Motors
    (2, '1FTFW1ET3EKF51234'), -- Ford F-150 at Downtown Auto
    (3, '5YJ3E1EA7KF312345'), -- Tesla Model 3 at Highland Vehicles
    (1, '3VW2B7AJ9FM512345'); -- VW Jetta at Sunrise Motors

-- Populate sales_contracts
INSERT INTO sales_contracts (VIN, customer_name, customer_phone, sale_price, sale_date)
VALUES
    ('1FTFW1ET3EKF51234', 'John Doe', '555-1111', 34000.00, '2023-06-15'), -- Ford F-150 sale
    ('3VW2B7AJ9FM512345', 'Jane Smith', '555-2222', 14000.00, '2023-07-10'); -- VW Jetta sale

-- Populate lease_contracts
INSERT INTO lease_contracts (VIN, customer_name, customer_phone, lease_term_months, monthly_payment, lease_start_date, lease_end_date)
VALUES
    ('1HGCM82633A123456', 'Alice Johnson', '555-3333', 36, 500.00, '2023-08-01', '2026-08-01'), -- Honda Civic lease
    ('5YJ3E1EA7KF312345', 'Bob Williams', '555-4444', 24, 600.00, '2023-09-01', '2025-09-01'); -- Tesla Model 3 lease
