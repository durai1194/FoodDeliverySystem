CREATE TABLE food_items (
	id int4 NOT NULL AUTO_INCREMENT  PRIMARY KEY,
	item_id int4 NOT NULL,
	item_name varchar(20) NULL,
	price int4 NOT NULL,
	hotel_id int4 NOT NULL
);

CREATE TABLE order_details (
  order_id int4 NOT NULL AUTO_INCREMENT  PRIMARY KEY,
  item_id int4 NOT NULL,
  hotel_id int4 NOT NULL,
  item_name varchar(20) NOT NULL,
  hotel_name varchar(20) NOT NULL,
  qty int4 NOT NULL,
  customer_id int4 NOT NULL,
  address varchar(300) NOT NULL,
  notes varchar(300) NOT NULL,
  transaction_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  payment_mode varchar(16) NOT NULL DEFAULT 'COD',
  order_status varchar(25) NOT NULL DEFAULT 'Yet to be delivered',
  price int4 NOT NULL
);

CREATE TABLE hotel_details (
  hotel_id int4 NOT NULL AUTO_INCREMENT  PRIMARY KEY,
  hotel_name varchar(20) NOT NULL,
  ratings int4 NOT NULL
);

CREATE SEQUENCE order_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;	