create table especially_dangerous_operations(
    id serial8 primary key,
    name text not null,
    date_start  timestamp,
    date_stop   timestamp,
    employee_id serial8
        constraint fk_employee_oor references user_system on UPDATE restrict on delete restrict,
    chief_engineer serial8 constraint fk_user_system_engineer references user_system on UPDATE restrict on delete restrict,
    dateCheck timestamp,
    location_id serial8
        constraint fk_location_ooo references location on UPDATE restrict on delete restrict,
    oor_id serial8
        constraint fk_oor_ooo references list_especially_dangerous_work on UPDATE restrict on delete restrict
)