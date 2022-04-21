-- create table object_examination(
--     id serial8 primary key,
--     name text,
--
-- )

create table architectural_supervision_schedule
(
    id                                 serial8 primary key,
    employee_id                        serial8
        constraint fk_employee_ass references user_system on UPDATE restrict on delete restrict,
    especially_dangerous_operations_id serial8
        constraint fl_especially_dangerous_operations_ass references especially_dangerous_operations on UPDATE restrict on delete restrict,
    location_id                        serial8
        constraint fk_location_ass references location on UPDATE restrict on delete restrict,
    chief_engineer                     serial8
        constraint fk_user_system_engineer references user_system on UPDATE restrict on delete restrict,
    dateCheck                          timestamp,
    employer_signature bool default false
);

create table notes
(
    id                                    serial8 primary key,
    name                                  text not null,
    text                                  text not null,
    architectural_supervision_schedule_id serial8
        constraint fk_ass_notes references architectural_supervision_schedule on UPDATE restrict on delete restrict
);

create table architectural_supervision_schedule_signature
(
    employee_id                           serial8
        constraint fk_employee_architectural_supervision_schedule_signature references user_system on UPDATE restrict on delete restrict,
    architectural_supervision_schedule_id serial8
        constraint fk_architectural_supervision_schedule__signature references architectural_supervision_schedule on UPDATE restrict on delete restrict,
    primary key (employee_id, architectural_supervision_schedule_id)
);