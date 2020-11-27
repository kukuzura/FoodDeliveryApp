update food_company
set admin_id=3;

insert into menu_option (id, cost, description, name, food_company_id)
values
(1,12,'помидоры, огурцы, сметана, соль','салат "Домашний"',1),
(2,42,'колбаса вареная, огурцы, варенвя картошка','салат "Оливье"',1);