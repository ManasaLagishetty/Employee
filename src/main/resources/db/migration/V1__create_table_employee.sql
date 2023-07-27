CREATE TABLE employee(
id INT PRIMARY KEY IDENTITY,
email VARCHAR(30) UNIQUE,
first_name VARCHAR(30),
last_name VARCHAR(30),
phone_number VARCHAR(15),
password VARCHAR(20)
);