 alter table user_system
add column fio text not null;
create table division
(
    id       serial8 unique not null,
    division text           not null,
    primary key (id)
);
 alter table user_system
add column division_id serial8
    constraint fk_division_user_system references division on UPDATE restrict on delete restrict;