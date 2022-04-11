/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.daos;


import java.time.LocalDate;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.generated.tables.HistoryPassword;
import org.jooq.generated.tables.records.HistoryPasswordRecord;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class HistoryPasswordDao extends DAOImpl<HistoryPasswordRecord, org.jooq.generated.tables.pojos.HistoryPassword, Long> {

    /**
     * Create a new HistoryPasswordDao without any configuration
     */
    public HistoryPasswordDao() {
        super(HistoryPassword.HISTORY_PASSWORD, org.jooq.generated.tables.pojos.HistoryPassword.class);
    }

    /**
     * Create a new HistoryPasswordDao with an attached configuration
     */
    public HistoryPasswordDao(Configuration configuration) {
        super(HistoryPassword.HISTORY_PASSWORD, org.jooq.generated.tables.pojos.HistoryPassword.class, configuration);
    }

    @Override
    public Long getId(org.jooq.generated.tables.pojos.HistoryPassword object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.HistoryPassword> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(HistoryPassword.HISTORY_PASSWORD.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.HistoryPassword> fetchById(Long... values) {
        return fetch(HistoryPassword.HISTORY_PASSWORD.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public org.jooq.generated.tables.pojos.HistoryPassword fetchOneById(Long value) {
        return fetchOne(HistoryPassword.HISTORY_PASSWORD.ID, value);
    }

    /**
     * Fetch records that have <code>password BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.HistoryPassword> fetchRangeOfPassword(String lowerInclusive, String upperInclusive) {
        return fetchRange(HistoryPassword.HISTORY_PASSWORD.PASSWORD, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>password IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.HistoryPassword> fetchByPassword(String... values) {
        return fetch(HistoryPassword.HISTORY_PASSWORD.PASSWORD, values);
    }

    /**
     * Fetch records that have <code>date BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.HistoryPassword> fetchRangeOfDate(LocalDate lowerInclusive, LocalDate upperInclusive) {
        return fetchRange(HistoryPassword.HISTORY_PASSWORD.DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>date IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.HistoryPassword> fetchByDate(LocalDate... values) {
        return fetch(HistoryPassword.HISTORY_PASSWORD.DATE, values);
    }

    /**
     * Fetch records that have <code>user_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.HistoryPassword> fetchRangeOfUserId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(HistoryPassword.HISTORY_PASSWORD.USER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>user_id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.HistoryPassword> fetchByUserId(Long... values) {
        return fetch(HistoryPassword.HISTORY_PASSWORD.USER_ID, values);
    }
}
