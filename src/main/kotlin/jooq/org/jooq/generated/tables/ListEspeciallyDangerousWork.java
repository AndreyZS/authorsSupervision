/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row10;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.generated.DefaultSchema;
import org.jooq.generated.Keys;
import org.jooq.generated.tables.records.ListEspeciallyDangerousWorkRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ListEspeciallyDangerousWork extends TableImpl<ListEspeciallyDangerousWorkRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>list_especially_dangerous_work</code>
     */
    public static final ListEspeciallyDangerousWork LIST_ESPECIALLY_DANGEROUS_WORK = new ListEspeciallyDangerousWork();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ListEspeciallyDangerousWorkRecord> getRecordType() {
        return ListEspeciallyDangerousWorkRecord.class;
    }

    /**
     * The column <code>list_especially_dangerous_work.id</code>.
     */
    public final TableField<ListEspeciallyDangerousWorkRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>list_especially_dangerous_work.name</code>.
     */
    public final TableField<ListEspeciallyDangerousWorkRecord, String> NAME = createField(DSL.name("name"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>list_especially_dangerous_work.date_start</code>.
     */
    public final TableField<ListEspeciallyDangerousWorkRecord, LocalDateTime> DATE_START = createField(DSL.name("date_start"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>list_especially_dangerous_work.date_stop</code>.
     */
    public final TableField<ListEspeciallyDangerousWorkRecord, LocalDateTime> DATE_STOP = createField(DSL.name("date_stop"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>list_especially_dangerous_work.location_id</code>.
     */
    public final TableField<ListEspeciallyDangerousWorkRecord, Long> LOCATION_ID = createField(DSL.name("location_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>list_especially_dangerous_work.employee_id</code>.
     */
    public final TableField<ListEspeciallyDangerousWorkRecord, Long> EMPLOYEE_ID = createField(DSL.name("employee_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>list_especially_dangerous_work.sign_danger_id</code>.
     */
    public final TableField<ListEspeciallyDangerousWorkRecord, Long> SIGN_DANGER_ID = createField(DSL.name("sign_danger_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>list_especially_dangerous_work.chief_engineer</code>.
     */
    public final TableField<ListEspeciallyDangerousWorkRecord, Long> CHIEF_ENGINEER = createField(DSL.name("chief_engineer"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>list_especially_dangerous_work.datecheck</code>.
     */
    public final TableField<ListEspeciallyDangerousWorkRecord, LocalDateTime> DATECHECK = createField(DSL.name("datecheck"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>list_especially_dangerous_work.work_plan_id</code>.
     */
    public final TableField<ListEspeciallyDangerousWorkRecord, Long> WORK_PLAN_ID = createField(DSL.name("work_plan_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    private ListEspeciallyDangerousWork(Name alias, Table<ListEspeciallyDangerousWorkRecord> aliased) {
        this(alias, aliased, null);
    }

    private ListEspeciallyDangerousWork(Name alias, Table<ListEspeciallyDangerousWorkRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>list_especially_dangerous_work</code> table
     * reference
     */
    public ListEspeciallyDangerousWork(String alias) {
        this(DSL.name(alias), LIST_ESPECIALLY_DANGEROUS_WORK);
    }

    /**
     * Create an aliased <code>list_especially_dangerous_work</code> table
     * reference
     */
    public ListEspeciallyDangerousWork(Name alias) {
        this(alias, LIST_ESPECIALLY_DANGEROUS_WORK);
    }

    /**
     * Create a <code>list_especially_dangerous_work</code> table reference
     */
    public ListEspeciallyDangerousWork() {
        this(DSL.name("list_especially_dangerous_work"), null);
    }

    public <O extends Record> ListEspeciallyDangerousWork(Table<O> child, ForeignKey<O, ListEspeciallyDangerousWorkRecord> key) {
        super(child, key, LIST_ESPECIALLY_DANGEROUS_WORK);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<ListEspeciallyDangerousWorkRecord, Long> getIdentity() {
        return (Identity<ListEspeciallyDangerousWorkRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<ListEspeciallyDangerousWorkRecord> getPrimaryKey() {
        return Keys.LIST_ESPECIALLY_DANGEROUS_WORK_PKEY;
    }

    @Override
    public List<ForeignKey<ListEspeciallyDangerousWorkRecord, ?>> getReferences() {
        return Arrays.asList(Keys.LIST_ESPECIALLY_DANGEROUS_WORK__FK_LOCATION_OOR, Keys.LIST_ESPECIALLY_DANGEROUS_WORK__FK_EMPLOYEE_OOR, Keys.LIST_ESPECIALLY_DANGEROUS_WORK__FK_SIGN_DANGER_OOR, Keys.LIST_ESPECIALLY_DANGEROUS_WORK__FK_USER_SYSTEM_ENGINEER, Keys.LIST_ESPECIALLY_DANGEROUS_WORK__FK_WORK_PLAN_OOR);
    }

    private transient Location _location;
    private transient UserSystem _fkEmployeeOor;
    private transient SignDanger _signDanger;
    private transient UserSystem _fkUserSystemEngineer;
    private transient WorkPlan _workPlan;

    public Location location() {
        if (_location == null)
            _location = new Location(this, Keys.LIST_ESPECIALLY_DANGEROUS_WORK__FK_LOCATION_OOR);

        return _location;
    }

    public UserSystem fkEmployeeOor() {
        if (_fkEmployeeOor == null)
            _fkEmployeeOor = new UserSystem(this, Keys.LIST_ESPECIALLY_DANGEROUS_WORK__FK_EMPLOYEE_OOR);

        return _fkEmployeeOor;
    }

    public SignDanger signDanger() {
        if (_signDanger == null)
            _signDanger = new SignDanger(this, Keys.LIST_ESPECIALLY_DANGEROUS_WORK__FK_SIGN_DANGER_OOR);

        return _signDanger;
    }

    public UserSystem fkUserSystemEngineer() {
        if (_fkUserSystemEngineer == null)
            _fkUserSystemEngineer = new UserSystem(this, Keys.LIST_ESPECIALLY_DANGEROUS_WORK__FK_USER_SYSTEM_ENGINEER);

        return _fkUserSystemEngineer;
    }

    public WorkPlan workPlan() {
        if (_workPlan == null)
            _workPlan = new WorkPlan(this, Keys.LIST_ESPECIALLY_DANGEROUS_WORK__FK_WORK_PLAN_OOR);

        return _workPlan;
    }

    @Override
    public ListEspeciallyDangerousWork as(String alias) {
        return new ListEspeciallyDangerousWork(DSL.name(alias), this);
    }

    @Override
    public ListEspeciallyDangerousWork as(Name alias) {
        return new ListEspeciallyDangerousWork(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ListEspeciallyDangerousWork rename(String name) {
        return new ListEspeciallyDangerousWork(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ListEspeciallyDangerousWork rename(Name name) {
        return new ListEspeciallyDangerousWork(name, null);
    }

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<Long, String, LocalDateTime, LocalDateTime, Long, Long, Long, Long, LocalDateTime, Long> fieldsRow() {
        return (Row10) super.fieldsRow();
    }
}
