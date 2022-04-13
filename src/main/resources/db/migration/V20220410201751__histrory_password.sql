create table history_password
(
    id       serial8 unique not null,
    password text           not null,
    date     date           not null,
    user_id  serial8
        constraint fk_user_history_password references user_system on UPDATE restrict on delete restrict,
    primary key (id)
)
