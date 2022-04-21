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
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.generated.DefaultSchema;
import org.jooq.generated.Keys;
import org.jooq.generated.tables.records.NotesRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Notes extends TableImpl<NotesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>notes</code>
     */
    public static final Notes NOTES = new Notes();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<NotesRecord> getRecordType() {
        return NotesRecord.class;
    }

    /**
     * The column <code>notes.id</code>.
     */
    public final TableField<NotesRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>notes.name</code>.
     */
    public final TableField<NotesRecord, String> NAME = createField(DSL.name("name"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>notes.text</code>.
     */
    public final TableField<NotesRecord, String> TEXT = createField(DSL.name("text"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>notes.architectural_supervision_schedule_id</code>.
     */
    public final TableField<NotesRecord, Long> ARCHITECTURAL_SUPERVISION_SCHEDULE_ID = createField(DSL.name("architectural_supervision_schedule_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    private Notes(Name alias, Table<NotesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Notes(Name alias, Table<NotesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>notes</code> table reference
     */
    public Notes(String alias) {
        this(DSL.name(alias), NOTES);
    }

    /**
     * Create an aliased <code>notes</code> table reference
     */
    public Notes(Name alias) {
        this(alias, NOTES);
    }

    /**
     * Create a <code>notes</code> table reference
     */
    public Notes() {
        this(DSL.name("notes"), null);
    }

    public <O extends Record> Notes(Table<O> child, ForeignKey<O, NotesRecord> key) {
        super(child, key, NOTES);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<NotesRecord, Long> getIdentity() {
        return (Identity<NotesRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<NotesRecord> getPrimaryKey() {
        return Keys.NOTES_PKEY;
    }

    @Override
    public List<ForeignKey<NotesRecord, ?>> getReferences() {
        return Arrays.asList(Keys.NOTES__FK_ASS_NOTES);
    }

    private transient ArchitecturalSupervisionSchedule _architecturalSupervisionSchedule;

    public ArchitecturalSupervisionSchedule architecturalSupervisionSchedule() {
        if (_architecturalSupervisionSchedule == null)
            _architecturalSupervisionSchedule = new ArchitecturalSupervisionSchedule(this, Keys.NOTES__FK_ASS_NOTES);

        return _architecturalSupervisionSchedule;
    }

    @Override
    public Notes as(String alias) {
        return new Notes(DSL.name(alias), this);
    }

    @Override
    public Notes as(Name alias) {
        return new Notes(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Notes rename(String name) {
        return new Notes(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Notes rename(Name name) {
        return new Notes(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, String, String, Long> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
