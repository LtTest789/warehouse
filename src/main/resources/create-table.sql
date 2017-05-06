CREATE TABLE WAREHOUSE(
   id BIGINT(20) NOT NULL AUTO_INCREMENT,
   item_name VARCHAR(100) NOT NULL,
   warehouse_address VARCHAR(55),
   quantity INT(20),
   PRIMARY KEY (id)
);