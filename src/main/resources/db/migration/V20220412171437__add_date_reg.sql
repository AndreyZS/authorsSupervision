alter table user_system
add column date_registration date not null;

alter table user_system
alter column date_change_password drop not null;