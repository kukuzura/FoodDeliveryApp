create table company
(
    id   bigint       not null
        primary key,
    name varchar(255) null
)
    engine = MyISAM;

create table company_menu
(
    company_id bigint not null,
    menu_id    bigint not null
)
    engine = MyISAM;

create index FKb16hgcln9hslym8wquhhm9c2n
    on company_menu (company_id);

create index FKj4qm3ohdbrm6envoa87flkai0
    on company_menu (menu_id);

create table employee
(
    id         bigint       not null
        primary key,
    name       varchar(255) null,
    patronymic varchar(255) null,
    post       varchar(255) null,
    surname    varchar(255) null,
    office_id  bigint       null,
    user_id    bigint       null
)
    engine = MyISAM;

create index FK6lk0xml9r7okjdq0onka4ytju
    on employee (user_id);

create index FKjurhambl7fs34cp8i36xpd5yp
    on employee (office_id);

create table food_company
(
    id               bigint       not null
        primary key,
    name             varchar(255) null,
    time_restriction time         null
)
    engine = MyISAM;

create table food_company_menu
(
    food_company_id bigint not null,
    menu_id         bigint not null,
    constraint UK_8nsq9h7ua4p5bi08a3gdq98tj
        unique (menu_id)
)
    engine = MyISAM;

create index FK5m1c8my7cp55g74v6mngcfkgr
    on food_company_menu (food_company_id);

create table hibernate_sequence
(
    next_val bigint null
)
    engine = MyISAM;

create table menu
(
    id              bigint not null
        primary key,
    is_choosed      bit    not null,
    food_company_id bigint null
)
    engine = MyISAM;

create index FK3y2ng6a9dls10ig5jriavrt9q
    on menu (food_company_id);

create table menu_menu_option
(
    menu_id        bigint not null,
    menu_option_id bigint not null
)
    engine = MyISAM;

create index FKmk6ug9je5ogkunrothb66cj5y
    on menu_menu_option (menu_id);

create index FKqxic1ywkkkkvw3u4o31snk596
    on menu_menu_option (menu_option_id);

create table menu_option
(
    id          bigint       not null
        primary key,
    cost        double       null,
    description varchar(255) null,
    name        varchar(255) null
)
    engine = MyISAM;

create table office
(
    id         bigint       not null
        primary key,
    address    varchar(255) null,
    name       varchar(255) null,
    company_id bigint       null
)
    engine = MyISAM;

create index FKqfmw2uo0g1kab0x3fb0uq5wkw
    on office (company_id);

create table `order`
(
    id          int  null,
    date_time   date null,
    employee_id int  null
);

create table order_menu_option
(
    order_id       bigint not null,
    menu_option_id bigint not null
)
    engine = MyISAM;

create index FKnnqqibly415rqrfayhn9f1yf
    on order_menu_option (menu_option_id);

create table role
(
    id   bigint       not null
        primary key,
    name varchar(255) null
)
    engine = MyISAM;

create table user
(
    id       bigint       not null
        primary key,
    password varchar(255) null,
    username varchar(255) null,
    admin_id bigint       null
)
    engine = MyISAM;

create index FK4tbkaqs71r1j59ui3o833lrgd
    on user (admin_id);

create table user_role
(
    user_id bigint not null,
    role_id bigint not null
)
    engine = MyISAM;

create index FKa68196081fvovjhkek5m97n3y
    on user_role (role_id);

create index user_role_role_id_id_fk
    on user_role (user_id, role_id);

