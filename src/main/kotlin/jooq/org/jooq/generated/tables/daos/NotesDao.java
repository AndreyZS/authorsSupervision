/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.daos;


import java.util.List;

import org.jooq.Configuration;
import org.jooq.generated.tables.Notes;
import org.jooq.generated.tables.records.NotesRecord;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class NotesDao extends DAOImpl<NotesRecord, org.jooq.generated.tables.pojos.Notes, Long> {

    /**
     * Create a new NotesDao without any configuration
     */
    public NotesDao() {
        super(Notes.NOTES, org.jooq.generated.tables.pojos.Notes.class);
    }

    /**
     * Create a new NotesDao with an attached configuration
     */
    public NotesDao(Configuration configuration) {
        super(Notes.NOTES, org.jooq.generated.tables.pojos.Notes.class, configuration);
    }

    @Override
    public Long getId(org.jooq.generated.tables.pojos.Notes object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.Notes> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Notes.NOTES.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.Notes> fetchById(Long... values) {
        return fetch(Notes.NOTES.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public org.jooq.generated.tables.pojos.Notes fetchOneById(Long value) {
        return fetchOne(Notes.NOTES.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.Notes> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Notes.NOTES.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.Notes> fetchByName(String... values) {
        return fetch(Notes.NOTES.NAME, values);
    }

    /**
     * Fetch records that have <code>text BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.Notes> fetchRangeOfText(String lowerInclusive, String upperInclusive) {
        return fetchRange(Notes.NOTES.TEXT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>text IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.Notes> fetchByText(String... values) {
        return fetch(Notes.NOTES.TEXT, values);
    }

    /**
     * Fetch records that have <code>architectural_supervision_schedule_id
     * BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.Notes> fetchRangeOfArchitecturalSupervisionScheduleId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Notes.NOTES.ARCHITECTURAL_SUPERVISION_SCHEDULE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>architectural_supervision_schedule_id IN
     * (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.Notes> fetchByArchitecturalSupervisionScheduleId(Long... values) {
        return fetch(Notes.NOTES.ARCHITECTURAL_SUPERVISION_SCHEDULE_ID, values);
    }
}
