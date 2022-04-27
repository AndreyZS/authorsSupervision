create table copyright_supervision_report
(
    id                 serial8 primary key constraint  fk_arc references architectural_supervision_schedule on UPDATE restrict on delete restrict,
    employee_id        serial8
        constraint fk_employee_copyright_supervision_report references user_system on UPDATE restrict on delete restrict,
    date_create        timestamp not null,
    presence           serial8
        constraint fk_presence_copyright_supervision_report references user_system on UPDATE restrict on delete restrict,
    date_presence      time,
    location_id        serial8
        constraint fk_location_copyright_supervision_report references location on UPDATE restrict on delete restrict,
    responsible_leader serial8
        constraint fk_responsible_leader_copyright_supervision_report references user_system on UPDATE restrict on delete restrict,
    work_during_check  text,
    audited_unit       text,
    chief_engineer     serial8
        constraint fk_chief_engineer_copyright_supervision_report references user_system on UPDATE restrict on delete restrict,
    dateCheck          timestamp,
    changes_made text,
    signature bool default false,

    employees_requirements_technological_documentation bool default false,
    employees_requirements_technological_documentation_comment text,
    employees_requirements_technological_documentation_teg text[],

    execution_preparatory_work_accordance_PPR bool default false,
    execution_preparatory_work_accordance_PPR_comment text,
    execution_preparatory_work_accordance_PPR_teg text[],

    compliance_organization_design_solution_specified_PPR bool default false,
    compliance_organization_design_solution_specified_PPR_comment text,
    compliance_organization_design_solution_specified_PPR_teg text[],

    compliance_work_performed_design_solution bool default false,
    compliance_work_performed_design_solution_comment text,
    compliance_work_performed_design_solution_teg text[],

    compliance_sequence_technology_relevant_operations bool default false,
    compliance_sequence_technology_relevant_operations_comment text,
    compliance_sequence_technology_relevant_operations_teg text[],

    compliance_applied_means_mechanization_specified_PPR bool default false,
    compliance_applied_means_mechanization_specified_PPR_comment text,
    compliance_applied_means_mechanization_specified_PPR_teg text[],

    compliance_used_rigging_equipment_requirements_PPR bool default false,
    compliance_used_rigging_equipment_requirements_PPR_comment text,
    compliance_used_rigging_equipment_requirements_PPR_teg text[],

    compliance_truss_gripping_devices_requirements_PPR bool default  false,
    compliance_truss_gripping_devices_requirements_PPR_comment text,
    compliance_truss_gripping_devices_requirements_PPR_teg text[]

);

create table  copyright_supervision_report_signature
(
    employee_id                           serial8
        constraint fk_employee_copyright_supervision_report_signature references user_system on UPDATE restrict on delete restrict,
    copyright_supervision_report_id serial8
        constraint fk_copyright_supervision_report__signature references copyright_supervision_report on UPDATE restrict on delete restrict,
    primary key (employee_id, copyright_supervision_report_id)
);