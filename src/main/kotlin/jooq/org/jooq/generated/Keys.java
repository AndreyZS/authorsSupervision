/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated;


import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.generated.tables.AccessRights;
import org.jooq.generated.tables.AccessRightsUsers;
import org.jooq.generated.tables.FlywaySchemaHistory;
import org.jooq.generated.tables.HistoryPassword;
import org.jooq.generated.tables.UserSystem;
import org.jooq.generated.tables.records.AccessRightsRecord;
import org.jooq.generated.tables.records.AccessRightsUsersRecord;
import org.jooq.generated.tables.records.FlywaySchemaHistoryRecord;
import org.jooq.generated.tables.records.HistoryPasswordRecord;
import org.jooq.generated.tables.records.UserSystemRecord;
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
    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, DSL.name("flyway_schema_history_pk"), new TableField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
    public static final UniqueKey<HistoryPasswordRecord> HISTORY_PASSWORD_PKEY = Internal.createUniqueKey(HistoryPassword.HISTORY_PASSWORD, DSL.name("history_password_pkey"), new TableField[] { HistoryPassword.HISTORY_PASSWORD.ID }, true);
    public static final UniqueKey<UserSystemRecord> USER_SYSTEM_LOGIN_KEY = Internal.createUniqueKey(UserSystem.USER_SYSTEM, DSL.name("user_system_login_key"), new TableField[] { UserSystem.USER_SYSTEM.LOGIN }, true);
    public static final UniqueKey<UserSystemRecord> USER_SYSTEM_PKEY = Internal.createUniqueKey(UserSystem.USER_SYSTEM, DSL.name("user_system_pkey"), new TableField[] { UserSystem.USER_SYSTEM.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<AccessRightsUsersRecord, AccessRightsRecord> ACCESS_RIGHTS_USERS__FK_ACCESS_RIGHT_ID = Internal.createForeignKey(AccessRightsUsers.ACCESS_RIGHTS_USERS, DSL.name("fk_access_right_id"), new TableField[] { AccessRightsUsers.ACCESS_RIGHTS_USERS.ACCESS_RIGHTS_ID }, Keys.ACCESS_RIGHTS_PKEY, new TableField[] { AccessRights.ACCESS_RIGHTS.ID }, true);
    public static final ForeignKey<AccessRightsUsersRecord, UserSystemRecord> ACCESS_RIGHTS_USERS__FK_USER_SYSTEM_ID = Internal.createForeignKey(AccessRightsUsers.ACCESS_RIGHTS_USERS, DSL.name("fk_user_system_id"), new TableField[] { AccessRightsUsers.ACCESS_RIGHTS_USERS.USES_SYSTEM }, Keys.USER_SYSTEM_PKEY, new TableField[] { UserSystem.USER_SYSTEM.ID }, true);
    public static final ForeignKey<HistoryPasswordRecord, UserSystemRecord> HISTORY_PASSWORD__FK_USER_HISTORY_PASSWORD = Internal.createForeignKey(HistoryPassword.HISTORY_PASSWORD, DSL.name("fk_user_history_password"), new TableField[] { HistoryPassword.HISTORY_PASSWORD.USER_ID }, Keys.USER_SYSTEM_PKEY, new TableField[] { UserSystem.USER_SYSTEM.ID }, true);
}
