insert into role(id, name)
VALUES
(1,'SUPER_ADMIN'),
(2,'CUSTOMER_ADMIN'),
(3,'CUSTOMER_USER'),
(4,'DELIVERY_USER'),
(5,'DELIVERY_ADMIN');

insert into food_db.user(id, password, username, admin_id)
VALUES
(1,'$2a$12$8uGIgs2pKuXl/SVU.dlS4OGP7pf8eobE2CL5VLIZ7xM8Spy9JQ2sG','admin',null ),
(2,'$2a$12$8uGIgs2pKuXl/SVU.dlS4OGP7pf8eobE2CL5VLIZ7xM8Spy9JQ2sG','customer_admin',null ),
(3,'$2a$12$8uGIgs2pKuXl/SVU.dlS4OGP7pf8eobE2CL5VLIZ7xM8Spy9JQ2sG','delivery_admin',null );

insert user_role(user_id,role_id)
VALUES
(1,1),
(2,2),
(3,5)