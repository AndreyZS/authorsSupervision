alter table user_system
add column online_date date not null;

alter table user_system
add column locked bool not null default false;