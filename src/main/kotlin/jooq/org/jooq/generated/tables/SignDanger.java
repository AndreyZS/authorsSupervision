/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables;


import java.util.Arrays;
import java.util.List;

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
import org.jooq.generated.tables.records.SignDangerRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SignDanger extends TableImpl<SignDangerRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>sign_danger</code>
     */
    public static final SignDanger SIGN_DANGER = new SignDanger();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SignDangerRecord> getRecordType() {
        return SignDangerRecord.class;
    }

    /**
     * The column <code>sign_danger.id</code>.
     */
    public final TableField<SignDangerRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>sign_danger.name</code>.
     */
    public final TableField<SignDangerRecord, String> NAME = createField(DSL.name("name"), SQLDataType.CLOB, this, "");

    private SignDanger(Name alias, Table<SignDangerRecord> aliased) {
        this(alias, aliased, null);
    }

    private SignDanger(Name alias, Table<SignDangerRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>sign_danger</code> table reference
     */
    public SignDanger(String alias) {
        this(DSL.name(alias), SIGN_DANGER);
    }

    /**
     * Create an aliased <code>sign_danger</code> table reference
     */
    public SignDanger(Name alias) {
        this(alias, SIGN_DANGER);
    }

    /**
     * Create a <code>sign_danger</code> table reference
     */
    public SignDanger() {
        this(DSL.name("sign_danger"), null);
    }

    public <O extends Record> SignDanger(Table<O> child, ForeignKey<O, SignDangerRecord> key) {
        super(child, key, SIGN_DANGER);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<SignDangerRecord, Long> getIdentity() {
        return (Identity<SignDangerRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<SignDangerRecord> getPrimaryKey() {
        return Keys.SIGN_DANGER_PKEY;
    }

    @Override
    public List<UniqueKey<SignDangerRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.SIGN_DANGER_NAME_KEY);
    }

    @Override
    public SignDanger as(String alias) {
        return new SignDanger(DSL.name(alias), this);
    }

    @Override
    public SignDanger as(Name alias) {
        return new SignDanger(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SignDanger rename(String name) {
        return new SignDanger(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SignDanger rename(Name name) {
        return new SignDanger(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
