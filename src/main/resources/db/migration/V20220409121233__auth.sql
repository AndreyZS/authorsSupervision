create TABLE access_rights
(
    id   serial8 unique,
    name varchar not null,
    primary key (id)
);
CREATE TABLE user_system
(
    id       serial8 unique,
    login    varchar NOT NULL unique,
    password varchar NOT NULL,

    PRIMARY KEY (id)
);

create TABLE access_rights_users
(
    uses_system      serial8
        constraint fk_user_system_id references user_system on update restrict on delete restrict,
    access_rights_id serial8
        constraint fk_access_right_id
            references access_rights
            on update restrict on delete restrict,
    primary key (uses_system, access_rights_id)
);