CREATE TABLE WAREHOUSE(
   id BIGINT(20) NOT NULL AUTO_INCREMENT,
   item_name VARCHAR(100) NOT NULL,
   warehouse_city VARCHAR(55),
   warehouse_street VARCHAR(55),
   warehouse_number VARCHAR(55),
   quantity INT(20),
   PRIMARY KEY (id)
);