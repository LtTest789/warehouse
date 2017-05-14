INSERT INTO WAREHOUSE (warehouse_city, warehouse_street, warehouse_number)
VALUES ('Klaipėda', 'Mokslininku', '44');

INSERT INTO WAREHOUSE (warehouse_city, warehouse_street, warehouse_number)
VALUES ('Vilnius', 'Didlaukio', '3');

INSERT INTO WAREHOUSE (warehouse_city, warehouse_street, warehouse_number)
VALUES ('Kaunas', 'Didlaukio', '12');

INSERT INTO WAREHOUSE (warehouse_city, warehouse_street, warehouse_number)
VALUES ('Vilnius', 'Naugarduko', '22');


INSERT INTO WAREHOUSE_ITEM (item_id, item_name, description, country_of_manufacturing, date_of_manufacturing, warehouse_id)
VALUES (1, 'Screen cleaning fuild', 'Fuild to clean dust from monitor screen', 'Lithuania', '2016-11-11', 1);

INSERT INTO WAREHOUSE_ITEM (item_id, item_name, description, country_of_manufacturing, date_of_manufacturing, warehouse_id)
VALUES (2, 'HP Pavilion', 'Laptop with 4GB RAM, i7 processor, 250GB HDD', 'China', '2016-02-02', 1);

INSERT INTO WAREHOUSE_ITEM (item_id, item_name, description, country_of_manufacturing, date_of_manufacturing, warehouse_id)
VALUES (3, 'Razer Deathadder', '3500DPI Mouse', 'Vietnam', '2013-12-20', 2);

INSERT INTO WAREHOUSE_ITEM (item_id, item_name, description, country_of_manufacturing, date_of_manufacturing, warehouse_id)
VALUES (4, 'Logitech speakers system', '180 Decibels speaker system', 'USA', '2015-05-15', 1);

INSERT INTO WAREHOUSE_ITEM (item_id, item_name, description, country_of_manufacturing, date_of_manufacturing, warehouse_id)
VALUES (5, 'Mouse Pad', 'Steel series mouse pad', 'Canada', '2014-08-13', 3);

INSERT INTO WAREHOUSE_ITEM (item_id, item_name, description, country_of_manufacturing, date_of_manufacturing, warehouse_id)
VALUES (6, 'Microsoft keyboard', 'Ergonomic keyborad with 5 programming buttons', 'China', '2014-03-15', 3);

INSERT INTO WAREHOUSE_ITEM (item_id, item_name, description, country_of_manufacturing, date_of_manufacturing, warehouse_id)
VALUES (6, 'Microsoft keyboard', 'Ergonomic keyborad with 5 programming buttons', 'China', '2014-03-15', 1);