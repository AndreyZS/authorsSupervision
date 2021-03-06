/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated;


import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.generated.tables.AccessRights;
import org.jooq.generated.tables.AccessRightsUsers;
import org.jooq.generated.tables.ArchitecturalSupervisionRegister;
import org.jooq.generated.tables.ArchitecturalSupervisionSchedule;
import org.jooq.generated.tables.ArchitecturalSupervisionScheduleSignature;
import org.jooq.generated.tables.Company;
import org.jooq.generated.tables.CopyrightSupervisionReport;
import org.jooq.generated.tables.CopyrightSupervisionReportSignature;
import org.jooq.generated.tables.Division;
import org.jooq.generated.tables.EspeciallyDangerousOperations;
import org.jooq.generated.tables.FlywaySchemaHistory;
import org.jooq.generated.tables.HistoryPassword;
import org.jooq.generated.tables.ListEspeciallyDangerousWork;
import org.jooq.generated.tables.Location;
import org.jooq.generated.tables.Notes;
import org.jooq.generated.tables.SignDanger;
import org.jooq.generated.tables.UserSystem;
import org.jooq.generated.tables.WorkPlan;
import org.jooq.generated.tables.Workshop;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>DEFAULT_SCHEMA</code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>access_rights</code>.
     */
    public final AccessRights ACCESS_RIGHTS = AccessRights.ACCESS_RIGHTS;

    /**
     * The table <code>access_rights_users</code>.
     */
    public final AccessRightsUsers ACCESS_RIGHTS_USERS = AccessRightsUsers.ACCESS_RIGHTS_USERS;

    /**
     * The table <code>architectural_supervision_register</code>.
     */
    public final ArchitecturalSupervisionRegister ARCHITECTURAL_SUPERVISION_REGISTER = ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER;

    /**
     * The table <code>architectural_supervision_schedule</code>.
     */
    public final ArchitecturalSupervisionSchedule ARCHITECTURAL_SUPERVISION_SCHEDULE = ArchitecturalSupervisionSchedule.ARCHITECTURAL_SUPERVISION_SCHEDULE;

    /**
     * The table <code>architectural_supervision_schedule_signature</code>.
     */
    public final ArchitecturalSupervisionScheduleSignature ARCHITECTURAL_SUPERVISION_SCHEDULE_SIGNATURE = ArchitecturalSupervisionScheduleSignature.ARCHITECTURAL_SUPERVISION_SCHEDULE_SIGNATURE;

    /**
     * The table <code>company</code>.
     */
    public final Company COMPANY = Company.COMPANY;

    /**
     * The table <code>copyright_supervision_report</code>.
     */
    public final CopyrightSupervisionReport COPYRIGHT_SUPERVISION_REPORT = CopyrightSupervisionReport.COPYRIGHT_SUPERVISION_REPORT;

    /**
     * The table <code>copyright_supervision_report_signature</code>.
     */
    public final CopyrightSupervisionReportSignature COPYRIGHT_SUPERVISION_REPORT_SIGNATURE = CopyrightSupervisionReportSignature.COPYRIGHT_SUPERVISION_REPORT_SIGNATURE;

    /**
     * The table <code>division</code>.
     */
    public final Division DIVISION = Division.DIVISION;

    /**
     * The table <code>especially_dangerous_operations</code>.
     */
    public final EspeciallyDangerousOperations ESPECIALLY_DANGEROUS_OPERATIONS = EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS;

    /**
     * The table <code>flyway_schema_history</code>.
     */
    public final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * The table <code>history_password</code>.
     */
    public final HistoryPassword HISTORY_PASSWORD = HistoryPassword.HISTORY_PASSWORD;

    /**
     * The table <code>list_especially_dangerous_work</code>.
     */
    public final ListEspeciallyDangerousWork LIST_ESPECIALLY_DANGEROUS_WORK = ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK;

    /**
     * The table <code>location</code>.
     */
    public final Location LOCATION = Location.LOCATION;

    /**
     * The table <code>notes</code>.
     */
    public final Notes NOTES = Notes.NOTES;

    /**
     * The table <code>sign_danger</code>.
     */
    public final SignDanger SIGN_DANGER = SignDanger.SIGN_DANGER;

    /**
     * The table <code>user_system</code>.
     */
    public final UserSystem USER_SYSTEM = UserSystem.USER_SYSTEM;

    /**
     * The table <code>work_plan</code>.
     */
    public final WorkPlan WORK_PLAN = WorkPlan.WORK_PLAN;

    /**
     * The table <code>workshop</code>.
     */
    public final Workshop WORKSHOP = Workshop.WORKSHOP;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        return Arrays.asList(
            Sequences.ARCHITECTURAL_SUPERVISION_SCH_ARCHITECTURAL_SUPERVISION_SCH_SEQ,
            Sequences.ARCHITECTURAL_SUPERVISION_SCH_ESPECIALLY_DANGEROUS_OPERATIO_SEQ,
            Sequences.COPYRIGHT_SUPERVISION_REPORT__COPYRIGHT_SUPERVISION_REPORT__SEQ,
            Sequences.SEQUENCE_GENERATOR
        );
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            AccessRights.ACCESS_RIGHTS,
            AccessRightsUsers.ACCESS_RIGHTS_USERS,
            ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER,
            ArchitecturalSupervisionSchedule.ARCHITECTURAL_SUPERVISION_SCHEDULE,
            ArchitecturalSupervisionScheduleSignature.ARCHITECTURAL_SUPERVISION_SCHEDULE_SIGNATURE,
            Company.COMPANY,
            CopyrightSupervisionReport.COPYRIGHT_SUPERVISION_REPORT,
            CopyrightSupervisionReportSignature.COPYRIGHT_SUPERVISION_REPORT_SIGNATURE,
            Division.DIVISION,
            EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS,
            FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY,
            HistoryPassword.HISTORY_PASSWORD,
            ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK,
            Location.LOCATION,
            Notes.NOTES,
            SignDanger.SIGN_DANGER,
            UserSystem.USER_SYSTEM,
            WorkPlan.WORK_PLAN,
            Workshop.WORKSHOP
        );
    }
}
