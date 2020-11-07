alter table company
	add admin_id int null;

alter table company
	add constraint company_user_id_fk
		foreign key (admin_id) references user (id);

alter table food_db.food_company
    add admin_id int null;

alter table food_db.food_company
    add constraint company_user_id_fk
        foreign key (admin_id) references user (id);
