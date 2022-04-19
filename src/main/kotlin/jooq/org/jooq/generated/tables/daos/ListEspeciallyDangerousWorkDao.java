/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.daos;


import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.generated.tables.ListEspeciallyDangerousWork;
import org.jooq.generated.tables.records.ListEspeciallyDangerousWorkRecord;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ListEspeciallyDangerousWorkDao extends DAOImpl<ListEspeciallyDangerousWorkRecord, org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork, Long> {

    /**
     * Create a new ListEspeciallyDangerousWorkDao without any configuration
     */
    public ListEspeciallyDangerousWorkDao() {
        super(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK, org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork.class);
    }

    /**
     * Create a new ListEspeciallyDangerousWorkDao with an attached
     * configuration
     */
    public ListEspeciallyDangerousWorkDao(Configuration configuration) {
        super(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK, org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork.class, configuration);
    }

    @Override
    public Long getId(org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchById(Long... values) {
        return fetch(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork fetchOneById(Long value) {
        return fetchOne(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchByName(String... values) {
        return fetch(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.NAME, values);
    }

    /**
     * Fetch records that have <code>date_start BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchRangeOfDateStart(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.DATE_START, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>date_start IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchByDateStart(LocalDateTime... values) {
        return fetch(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.DATE_START, values);
    }

    /**
     * Fetch records that have <code>date_stop BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchRangeOfDateStop(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.DATE_STOP, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>date_stop IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchByDateStop(LocalDateTime... values) {
        return fetch(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.DATE_STOP, values);
    }

    /**
     * Fetch records that have <code>location_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchRangeOfLocationId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.LOCATION_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>location_id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchByLocationId(Long... values) {
        return fetch(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.LOCATION_ID, values);
    }

    /**
     * Fetch records that have <code>employee_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchRangeOfEmployeeId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.EMPLOYEE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>employee_id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchByEmployeeId(Long... values) {
        return fetch(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.EMPLOYEE_ID, values);
    }

    /**
     * Fetch records that have <code>sign_danger_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchRangeOfSignDangerId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.SIGN_DANGER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>sign_danger_id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchBySignDangerId(Long... values) {
        return fetch(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.SIGN_DANGER_ID, values);
    }

    /**
     * Fetch records that have <code>chief_engineer BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchRangeOfChiefEngineer(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.CHIEF_ENGINEER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>chief_engineer IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchByChiefEngineer(Long... values) {
        return fetch(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.CHIEF_ENGINEER, values);
    }

    /**
     * Fetch records that have <code>datecheck BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchRangeOfDatecheck(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.DATECHECK, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>datecheck IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchByDatecheck(LocalDateTime... values) {
        return fetch(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.DATECHECK, values);
    }

    /**
     * Fetch records that have <code>work_plan_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchRangeOfWorkPlanId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.WORK_PLAN_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>work_plan_id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ListEspeciallyDangerousWork> fetchByWorkPlanId(Long... values) {
        return fetch(ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK.WORK_PLAN_ID, values);
    }
}
