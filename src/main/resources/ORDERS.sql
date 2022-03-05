CREATE TABLE ORDERS(
    id int NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    customer_id int NOT NULL,
    amount int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(id)
)