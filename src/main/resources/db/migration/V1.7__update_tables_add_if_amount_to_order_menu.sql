# alter table order_menu_option
#     add amount int null;
#
# alter table order_menu_option
#     add id int auto_increment;
#
# alter table order_menu_option drop primary key;
#
# alter table order_menu_option
#     add constraint order_menu_option_pk
#         primary key (id);
#
# create table food_company_company
# (
#     food_company_id int null,
#     company_id      int null
# );

# # alter table `order` modify date_time datetime null;
#
# alter table `order` change date_time date datetime null;
#
# rename table `order` to order_table;