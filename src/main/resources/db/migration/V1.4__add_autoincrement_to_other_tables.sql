alter table employee modify id bigint auto_increment;

alter table menu modify id bigint auto_increment;

alter table menu_option modify id bigint auto_increment;

alter table office modify id bigint auto_increment;


alter table `order`
    add constraint order_pk
        primary key (id);


alter table `order` modify id int auto_increment;
