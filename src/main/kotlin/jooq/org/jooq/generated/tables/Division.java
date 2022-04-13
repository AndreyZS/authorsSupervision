/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables;


import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.generated.DefaultSchema;
import org.jooq.generated.Keys;
import org.jooq.generated.tables.records.DivisionRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Division extends TableImpl<DivisionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>division</code>
     */
    public static final Division DIVISION = new Division();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DivisionRecord> getRecordType() {
        return DivisionRecord.class;
    }

    /**
     * The column <code>division.id</code>.
     */
    public final TableField<DivisionRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>division.division</code>.
     */
    public final TableField<DivisionRecord, String> DIVISION_ = createField(DSL.name("division"), SQLDataType.CLOB.nullable(false), this, "");

    private Division(Name alias, Table<DivisionRecord> aliased) {
        this(alias, aliased, null);
    }

    private Division(Name alias, Table<DivisionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>division</code> table reference
     */
    public Division(String alias) {
        this(DSL.name(alias), DIVISION);
    }

    /**
     * Create an aliased <code>division</code> table reference
     */
    public Division(Name alias) {
        this(alias, DIVISION);
    }

    /**
     * Create a <code>division</code> table reference
     */
    public Division() {
        this(DSL.name("division"), null);
    }

    public <O extends Record> Division(Table<O> child, ForeignKey<O, DivisionRecord> key) {
        super(child, key, DIVISION);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<DivisionRecord, Long> getIdentity() {
        return (Identity<DivisionRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<DivisionRecord> getPrimaryKey() {
        return Keys.DIVISION_PKEY;
    }

    @Override
    public Division as(String alias) {
        return new Division(DSL.name(alias), this);
    }

    @Override
    public Division as(Name alias) {
        return new Division(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Division rename(String name) {
        return new Division(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Division rename(Name name) {
        return new Division(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}