CREATE TABLE WAREHOUSE(
   id BIGINT(20) NOT NULL AUTO_INCREMENT,
   warehouse_city VARCHAR(55),
   warehouse_street VARCHAR(55),
   warehouse_number VARCHAR(55),
   PRIMARY KEY (id)
);

CREATE TABLE WAREHOUSE_ITEM(
   id BIGINT(20) NOT NULL AUTO_INCREMENT,
   item_id BIGINT(20) NOT NULL,
   item_name VARCHAR (256) NOT NULL,
   description VARCHAR(100),
   country_of_manufacturing VARCHAR(25),
   date_of_manufacturing DATE,
   warehouse_id BIGINT(20) ,
   PRIMARY KEY (id),
   FOREIGN KEY (warehouse_id) REFERENCES WAREHOUSE(id)
);