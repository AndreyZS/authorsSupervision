/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.daos;


import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.generated.tables.EspeciallyDangerousOperations;
import org.jooq.generated.tables.records.EspeciallyDangerousOperationsRecord;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EspeciallyDangerousOperationsDao extends DAOImpl<EspeciallyDangerousOperationsRecord, org.jooq.generated.tables.pojos.EspeciallyDangerousOperations, Long> {

    /**
     * Create a new EspeciallyDangerousOperationsDao without any configuration
     */
    public EspeciallyDangerousOperationsDao() {
        super(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS, org.jooq.generated.tables.pojos.EspeciallyDangerousOperations.class);
    }

    /**
     * Create a new EspeciallyDangerousOperationsDao with an attached
     * configuration
     */
    public EspeciallyDangerousOperationsDao(Configuration configuration) {
        super(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS, org.jooq.generated.tables.pojos.EspeciallyDangerousOperations.class, configuration);
    }

    @Override
    public Long getId(org.jooq.generated.tables.pojos.EspeciallyDangerousOperations object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchById(Long... values) {
        return fetch(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public org.jooq.generated.tables.pojos.EspeciallyDangerousOperations fetchOneById(Long value) {
        return fetchOne(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchByName(String... values) {
        return fetch(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.NAME, values);
    }

    /**
     * Fetch records that have <code>date_start BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchRangeOfDateStart(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.DATE_START, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>date_start IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchByDateStart(LocalDateTime... values) {
        return fetch(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.DATE_START, values);
    }

    /**
     * Fetch records that have <code>date_stop BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchRangeOfDateStop(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.DATE_STOP, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>date_stop IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchByDateStop(LocalDateTime... values) {
        return fetch(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.DATE_STOP, values);
    }

    /**
     * Fetch records that have <code>employee_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchRangeOfEmployeeId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.EMPLOYEE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>employee_id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchByEmployeeId(Long... values) {
        return fetch(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.EMPLOYEE_ID, values);
    }

    /**
     * Fetch records that have <code>chief_engineer BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchRangeOfChiefEngineer(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.CHIEF_ENGINEER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>chief_engineer IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchByChiefEngineer(Long... values) {
        return fetch(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.CHIEF_ENGINEER, values);
    }

    /**
     * Fetch records that have <code>datecheck BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchRangeOfDatecheck(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.DATECHECK, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>datecheck IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchByDatecheck(LocalDateTime... values) {
        return fetch(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.DATECHECK, values);
    }

    /**
     * Fetch records that have <code>location_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchRangeOfLocationId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.LOCATION_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>location_id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchByLocationId(Long... values) {
        return fetch(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.LOCATION_ID, values);
    }

    /**
     * Fetch records that have <code>oor_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchRangeOfOorId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.OOR_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>oor_id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchByOorId(Long... values) {
        return fetch(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.OOR_ID, values);
    }

    /**
     * Fetch records that have <code>urgently BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchRangeOfUrgently(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.URGENTLY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>urgently IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.EspeciallyDangerousOperations> fetchByUrgently(Boolean... values) {
        return fetch(EspeciallyDangerousOperations.ESPECIALLY_DANGEROUS_OPERATIONS.URGENTLY, values);
    }
}
