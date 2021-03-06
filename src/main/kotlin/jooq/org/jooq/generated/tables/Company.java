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
import org.jooq.generated.tables.records.CompanyRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Company extends TableImpl<CompanyRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>company</code>
     */
    public static final Company COMPANY = new Company();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CompanyRecord> getRecordType() {
        return CompanyRecord.class;
    }

    /**
     * The column <code>company.id</code>.
     */
    public final TableField<CompanyRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>company.name</code>.
     */
    public final TableField<CompanyRecord, String> NAME = createField(DSL.name("name"), SQLDataType.CLOB, this, "");

    private Company(Name alias, Table<CompanyRecord> aliased) {
        this(alias, aliased, null);
    }

    private Company(Name alias, Table<CompanyRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>company</code> table reference
     */
    public Company(String alias) {
        this(DSL.name(alias), COMPANY);
    }

    /**
     * Create an aliased <code>company</code> table reference
     */
    public Company(Name alias) {
        this(alias, COMPANY);
    }

    /**
     * Create a <code>company</code> table reference
     */
    public Company() {
        this(DSL.name("company"), null);
    }

    public <O extends Record> Company(Table<O> child, ForeignKey<O, CompanyRecord> key) {
        super(child, key, COMPANY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<CompanyRecord, Long> getIdentity() {
        return (Identity<CompanyRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<CompanyRecord> getPrimaryKey() {
        return Keys.COMPANY_PKEY;
    }

    @Override
    public List<UniqueKey<CompanyRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.COMPANY_NAME_KEY);
    }

    @Override
    public Company as(String alias) {
        return new Company(DSL.name(alias), this);
    }

    @Override
    public Company as(Name alias) {
        return new Company(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Company rename(String name) {
        return new Company(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Company rename(Name name) {
        return new Company(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
