## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name tacocloud -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create Databases
create database tacocloud;

#Create Tables
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
create table ingredient (id varchar(255) not null, name varchar(255), type integer, primary key (id)) engine=InnoDB;
create table taco (id bigint not null, created_at datetime, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table taco_ingredients (taco_id bigint not null, ingredients_id varchar(255) not null) engine=InnoDB;
create table taco_order (id bigint not null, cccvv varchar(255), cc_expiration varchar(255), cc_number varchar(255), delivery_city varchar(255), delivery_name varchar(255), delivery_street varchar(255), placed_at datetime, user_id bigint, primary key (id)) engine=InnoDB;
create table taco_order_tacos (taco_order_id bigint not null, tacos_id bigint not null) engine=InnoDB;
create table user (id bigint not null, city varchar(255), fullname varchar(255), password varchar(255), phone_number varchar(255), street varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
alter table taco_order_tacos add constraint UK_r4rma0h2pka5irll8qnlnwlwh unique (tacos_id);
alter table taco_ingredients add constraint FK7y679y77n5e75s3ss1v7ff14j foreign key (ingredients_id) references ingredient (id);
alter table taco_ingredients add constraint FK27rycuh3mjaepnba0j6m8xl4q foreign key (taco_id) references taco (id);
alter table taco_order add constraint FK1e7afaasuwdukhtillc612bvg foreign key (user_id) references user (id);
alter table taco_order_tacos add constraint FKfwvqtnjfview9e5f7bfqtd1ns foreign key (tacos_id) references taco (id);
alter table taco_order_tacos add constraint FKs8yteduju5tndbivxbmdrbsyy foreign key (taco_order_id) references taco_order (id);
