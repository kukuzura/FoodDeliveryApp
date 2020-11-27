alter table menu_option
    add food_company_id int null;

alter table menu_option
    add constraint menu_option_food_company_id_fk
        foreign key (food_company_id) references food_company (id);