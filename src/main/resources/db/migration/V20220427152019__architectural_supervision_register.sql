create table architectural_supervision_register
(
    id serial8 primary key constraint  fk_asr references copyright_supervision_report on UPDATE restrict on delete restrict,
    employee_id serial8
        constraint fk_employee_copyright_supervision_report references user_system on UPDATE restrict on delete restrict,
    according_schedule_date timestamp,
    according_shift int,
    actual_verification_date timestamp,
    actual_verification_shift int,
    identified_inconsistencies text,
    reasons_noncompliance text,

    chief_engineer     serial8
        constraint fk_chief_engineer_architectural_supervision_register references user_system on UPDATE restrict on delete restrict,
    dateCheck          timestamp
)