create schema store;

create table store.products
(
	id int auto_increment
		primary key,
	name varchar(30) not null,
	description varchar(200) not null,
	sku varchar(20) not null,
	manufacturer varchar(50) not null,
	price decimal(12,2) not null,
	constraint products_name_uindex
		unique (name),
	constraint products_sku_uindex
		unique (sku)
)
;

create procedure store.get_all_products ()
begin
    select
      id,
      name,
      description,
      sku,
      manufacturer,
      price
    from products;
  end
;

create procedure store.insert_product (IN p_id int, IN p_name varchar(30), IN p_description varchar(200), IN p_sku varchar(20), IN p_manufacturer varchar(50), IN p_price decimal(12,2))
begin
    insert into products (name, description, sku, manufacturer, price)
    values (p_name, p_description, p_sku, p_manufacturer, p_price);
  end
;