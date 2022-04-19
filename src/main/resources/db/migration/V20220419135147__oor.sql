create table company
(
    id   bigserial primary key,
    name text unique
);


create table workshop
(
    id         bigserial primary key,
    name       text unique,
    company_id serial8
        constraint fk_company_workshop references company on UPDATE restrict on delete restrict
);

create table location
(
    id         bigserial primary key,
    name       text unique,
    workshop_id serial8
        constraint fk_workshop_location references workshop on UPDATE restrict on delete restrict
);

create table sign_danger
(
    id   bigserial primary key,
    name text unique
);
create table work_plan(
                          id serial8 primary key,
                          name text not null,
                          aboutUpdate text,
                          dateUpdate timestamp
);

create table list_especially_dangerous_work
(
    id          bigserial primary key,
    name        text,
    date_start  timestamp,
    date_stop   timestamp,
    location_id serial8
        constraint fk_location_oor references location on UPDATE restrict on delete restrict,
    employee_id serial8
        constraint fk_employee_oor references user_system on UPDATE restrict on delete restrict,
    sign_danger_id serial8
        constraint fk_sign_danger_oor references sign_danger on UPDATE restrict on delete restrict,
    chief_engineer serial8 constraint fk_user_system_engeneer references sign_danger on UPDATE restrict on delete restrict,
    dateCheck timestamp,
    work_plan_id serial8
        constraint fk_work_plan_oor references work_plan on UPDATE restrict on delete restrict
);

