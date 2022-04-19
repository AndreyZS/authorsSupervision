/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated;


import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.generated.tables.AccessRights;
import org.jooq.generated.tables.AccessRightsUsers;
import org.jooq.generated.tables.Company;
import org.jooq.generated.tables.Division;
import org.jooq.generated.tables.FlywaySchemaHistory;
import org.jooq.generated.tables.HistoryPassword;
import org.jooq.generated.tables.ListEspeciallyDangerousWork;
import org.jooq.generated.tables.Location;
import org.jooq.generated.tables.SignDanger;
import org.jooq.generated.tables.UserSystem;
import org.jooq.generated.tables.WorkPlan;
import org.jooq.generated.tables.Workshop;
import org.jooq.generated.tables.records.AccessRightsRecord;
import org.jooq.generated.tables.records.AccessRightsUsersRecord;
import org.jooq.generated.tables.records.CompanyRecord;
import org.jooq.generated.tables.records.DivisionRecord;
import org.jooq.generated.tables.records.FlywaySchemaHistoryRecord;
import org.jooq.generated.tables.records.HistoryPasswordRecord;
import org.jooq.generated.tables.records.ListEspeciallyDangerousWorkRecord;
import org.jooq.generated.tables.records.LocationRecord;
import org.jooq.generated.tables.records.SignDangerRecord;
import org.jooq.generated.tables.records.UserSystemRecord;
import org.jooq.generated.tables.records.WorkPlanRecord;
import org.jooq.generated.tables.records.WorkshopRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in the
 * default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AccessRightsRecord> ACCESS_RIGHTS_PKEY = Internal.createUniqueKey(AccessRights.ACCESS_RIGHTS, DSL.name("access_rights_pkey"), new TableField[] { AccessRights.ACCESS_RIGHTS.ID }, true);
    public static final UniqueKey<AccessRightsUsersRecord> ACCESS_RIGHTS_USERS_PKEY = Internal.createUniqueKey(AccessRightsUsers.ACCESS_RIGHTS_USERS, DSL.name("access_rights_users_pkey"), new TableField[] { AccessRightsUsers.ACCESS_RIGHTS_USERS.USES_SYSTEM, AccessRightsUsers.ACCESS_RIGHTS_USERS.ACCESS_RIGHTS_ID }, true);
    public static final UniqueKey<CompanyRecord> COMPANY_NAME_KEY = Internal.createUniqueKey(Company.COMPANY, DSL.name("company_name_key"), new TableField[] { Company.COMPANY.NAME }, true);
    public static final UniqueKey<CompanyRecord> COMPANY_PKEY = Internal.createUniqueKey(Company.COMPANY, DSL.name("company_pkey"), new TableField[] { Company.COMPANY.ID }, true);
    public static final UniqueKey<DivisionRecord> DIVISION_PKEY = Internal.createUniqueKey(Division.DIVISION, DSL.name("division_pkey"), new TableField[] { Division.DIVISION.ID }, true);
    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, DSL.name("flyway_schema_history_pk"), new TableField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
    public static final UniqueKey<HistoryPasswordRecord> HISTORY_PASSWORD_PKEY = Internal.createUniqueKey(HistoryPassword.HISTORY_PASSWORD, DSL.name("history_password_pkey"), new TableField[] { HistoryPassword.HISTORY_PASSWORD.ID }, true);
    public static final UniqueKey<ListEspeciallyDangerousWorkRecord> LIST_ESPECIALLY_DANGEROUS_WORK_PKEY = Internal.createUniqueKey(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK, DSL.name("list_especially_dangerous_work_pkey"), new TableField[] { ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.ID }, true);
    public static final UniqueKey<LocationRecord> LOCATION_NAME_KEY = Internal.createUniqueKey(Location.LOCATION, DSL.name("location_name_key"), new TableField[] { Location.LOCATION.NAME }, true);
    public static final UniqueKey<LocationRecord> LOCATION_PKEY = Internal.createUniqueKey(Location.LOCATION, DSL.name("location_pkey"), new TableField[] { Location.LOCATION.ID }, true);
    public static final UniqueKey<SignDangerRecord> SIGN_DANGER_NAME_KEY = Internal.createUniqueKey(SignDanger.SIGN_DANGER, DSL.name("sign_danger_name_key"), new TableField[] { SignDanger.SIGN_DANGER.NAME }, true);
    public static final UniqueKey<SignDangerRecord> SIGN_DANGER_PKEY = Internal.createUniqueKey(SignDanger.SIGN_DANGER, DSL.name("sign_danger_pkey"), new TableField[] { SignDanger.SIGN_DANGER.ID }, true);
    public static final UniqueKey<UserSystemRecord> USER_SYSTEM_LOGIN_KEY = Internal.createUniqueKey(UserSystem.USER_SYSTEM, DSL.name("user_system_login_key"), new TableField[] { UserSystem.USER_SYSTEM.LOGIN }, true);
    public static final UniqueKey<UserSystemRecord> USER_SYSTEM_PKEY = Internal.createUniqueKey(UserSystem.USER_SYSTEM, DSL.name("user_system_pkey"), new TableField[] { UserSystem.USER_SYSTEM.ID }, true);
    public static final UniqueKey<WorkPlanRecord> WORK_PLAN_PKEY = Internal.createUniqueKey(WorkPlan.WORK_PLAN, DSL.name("work_plan_pkey"), new TableField[] { WorkPlan.WORK_PLAN.ID }, true);
    public static final UniqueKey<WorkshopRecord> WORKSHOP_NAME_KEY = Internal.createUniqueKey(Workshop.WORKSHOP, DSL.name("workshop_name_key"), new TableField[] { Workshop.WORKSHOP.NAME }, true);
    public static final UniqueKey<WorkshopRecord> WORKSHOP_PKEY = Internal.createUniqueKey(Workshop.WORKSHOP, DSL.name("workshop_pkey"), new TableField[] { Workshop.WORKSHOP.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<AccessRightsUsersRecord, AccessRightsRecord> ACCESS_RIGHTS_USERS__FK_ACCESS_RIGHT_ID = Internal.createForeignKey(AccessRightsUsers.ACCESS_RIGHTS_USERS, DSL.name("fk_access_right_id"), new TableField[] { AccessRightsUsers.ACCESS_RIGHTS_USERS.ACCESS_RIGHTS_ID }, Keys.ACCESS_RIGHTS_PKEY, new TableField[] { AccessRights.ACCESS_RIGHTS.ID }, true);
    public static final ForeignKey<AccessRightsUsersRecord, UserSystemRecord> ACCESS_RIGHTS_USERS__FK_USER_SYSTEM_ID = Internal.createForeignKey(AccessRightsUsers.ACCESS_RIGHTS_USERS, DSL.name("fk_user_system_id"), new TableField[] { AccessRightsUsers.ACCESS_RIGHTS_USERS.USES_SYSTEM }, Keys.USER_SYSTEM_PKEY, new TableField[] { UserSystem.USER_SYSTEM.ID }, true);
    public static final ForeignKey<HistoryPasswordRecord, UserSystemRecord> HISTORY_PASSWORD__FK_USER_HISTORY_PASSWORD = Internal.createForeignKey(HistoryPassword.HISTORY_PASSWORD, DSL.name("fk_user_history_password"), new TableField[] { HistoryPassword.HISTORY_PASSWORD.USER_ID }, Keys.USER_SYSTEM_PKEY, new TableField[] { UserSystem.USER_SYSTEM.ID }, true);
    public static final ForeignKey<ListEspeciallyDangerousWorkRecord, UserSystemRecord> LIST_ESPECIALLY_DANGEROUS_WORK__FK_EMPLOYEE_OOR = Internal.createForeignKey(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK, DSL.name("fk_employee_oor"), new TableField[] { ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.EMPLOYEE_ID }, Keys.USER_SYSTEM_PKEY, new TableField[] { UserSystem.USER_SYSTEM.ID }, true);
    public static final ForeignKey<ListEspeciallyDangerousWorkRecord, LocationRecord> LIST_ESPECIALLY_DANGEROUS_WORK__FK_LOCATION_OOR = Internal.createForeignKey(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK, DSL.name("fk_location_oor"), new TableField[] { ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.LOCATION_ID }, Keys.LOCATION_PKEY, new TableField[] { Location.LOCATION.ID }, true);
    public static final ForeignKey<ListEspeciallyDangerousWorkRecord, SignDangerRecord> LIST_ESPECIALLY_DANGEROUS_WORK__FK_SIGN_DANGER_OOR = Internal.createForeignKey(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK, DSL.name("fk_sign_danger_oor"), new TableField[] { ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.SIGN_DANGER_ID }, Keys.SIGN_DANGER_PKEY, new TableField[] { SignDanger.SIGN_DANGER.ID }, true);
    public static final ForeignKey<ListEspeciallyDangerousWorkRecord, SignDangerRecord> LIST_ESPECIALLY_DANGEROUS_WORK__FK_USER_SYSTEM_ENGENEER = Internal.createForeignKey(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK, DSL.name("fk_user_system_engeneer"), new TableField[] { ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.CHIEF_ENGINEER }, Keys.SIGN_DANGER_PKEY, new TableField[] { SignDanger.SIGN_DANGER.ID }, true);
    public static final ForeignKey<ListEspeciallyDangerousWorkRecord, WorkPlanRecord> LIST_ESPECIALLY_DANGEROUS_WORK__FK_WORK_PLAN_OOR = Internal.createForeignKey(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK, DSL.name("fk_work_plan_oor"), new TableField[] { ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.WORK_PLAN_ID }, Keys.WORK_PLAN_PKEY, new TableField[] { WorkPlan.WORK_PLAN.ID }, true);
    public static final ForeignKey<LocationRecord, WorkshopRecord> LOCATION__FK_WORKSHOP_LOCATION = Internal.createForeignKey(Location.LOCATION, DSL.name("fk_workshop_location"), new TableField[] { Location.LOCATION.WORKSHOP_ID }, Keys.WORKSHOP_PKEY, new TableField[] { Workshop.WORKSHOP.ID }, true);
    public static final ForeignKey<UserSystemRecord, DivisionRecord> USER_SYSTEM__FK_DIVISION_USER_SYSTEM = Internal.createForeignKey(UserSystem.USER_SYSTEM, DSL.name("fk_division_user_system"), new TableField[] { UserSystem.USER_SYSTEM.DIVISION_ID }, Keys.DIVISION_PKEY, new TableField[] { Division.DIVISION.ID }, true);
    public static final ForeignKey<WorkshopRecord, CompanyRecord> WORKSHOP__FK_COMPANY_WORKSHOP = Internal.createForeignKey(Workshop.WORKSHOP, DSL.name("fk_company_workshop"), new TableField[] { Workshop.WORKSHOP.COMPANY_ID }, Keys.COMPANY_PKEY, new TableField[] { Company.COMPANY.ID }, true);
}
