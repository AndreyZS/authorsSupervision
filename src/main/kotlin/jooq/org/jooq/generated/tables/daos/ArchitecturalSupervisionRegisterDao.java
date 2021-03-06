/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.daos;


import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.generated.tables.ArchitecturalSupervisionRegister;
import org.jooq.generated.tables.records.ArchitecturalSupervisionRegisterRecord;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ArchitecturalSupervisionRegisterDao extends DAOImpl<ArchitecturalSupervisionRegisterRecord, org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister, Long> {

    /**
     * Create a new ArchitecturalSupervisionRegisterDao without any
     * configuration
     */
    public ArchitecturalSupervisionRegisterDao() {
        super(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER, org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister.class);
    }

    /**
     * Create a new ArchitecturalSupervisionRegisterDao with an attached
     * configuration
     */
    public ArchitecturalSupervisionRegisterDao(Configuration configuration) {
        super(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER, org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister.class, configuration);
    }

    @Override
    public Long getId(org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchById(Long... values) {
        return fetch(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister fetchOneById(Long value) {
        return fetchOne(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.ID, value);
    }

    /**
     * Fetch records that have <code>employee_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchRangeOfEmployeeId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.EMPLOYEE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>employee_id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchByEmployeeId(Long... values) {
        return fetch(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.EMPLOYEE_ID, values);
    }

    /**
     * Fetch records that have <code>according_schedule_date BETWEEN
     * lowerInclusive AND upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchRangeOfAccordingScheduleDate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.ACCORDING_SCHEDULE_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>according_schedule_date IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchByAccordingScheduleDate(LocalDateTime... values) {
        return fetch(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.ACCORDING_SCHEDULE_DATE, values);
    }

    /**
     * Fetch records that have <code>according_shift BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchRangeOfAccordingShift(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.ACCORDING_SHIFT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>according_shift IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchByAccordingShift(Integer... values) {
        return fetch(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.ACCORDING_SHIFT, values);
    }

    /**
     * Fetch records that have <code>actual_verification_date BETWEEN
     * lowerInclusive AND upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchRangeOfActualVerificationDate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.ACTUAL_VERIFICATION_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>actual_verification_date IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchByActualVerificationDate(LocalDateTime... values) {
        return fetch(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.ACTUAL_VERIFICATION_DATE, values);
    }

    /**
     * Fetch records that have <code>actual_verification_shift BETWEEN
     * lowerInclusive AND upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchRangeOfActualVerificationShift(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.ACTUAL_VERIFICATION_SHIFT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>actual_verification_shift IN
     * (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchByActualVerificationShift(Integer... values) {
        return fetch(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.ACTUAL_VERIFICATION_SHIFT, values);
    }

    /**
     * Fetch records that have <code>identified_inconsistencies BETWEEN
     * lowerInclusive AND upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchRangeOfIdentifiedInconsistencies(String lowerInclusive, String upperInclusive) {
        return fetchRange(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.IDENTIFIED_INCONSISTENCIES, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>identified_inconsistencies IN
     * (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchByIdentifiedInconsistencies(String... values) {
        return fetch(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.IDENTIFIED_INCONSISTENCIES, values);
    }

    /**
     * Fetch records that have <code>reasons_noncompliance BETWEEN
     * lowerInclusive AND upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchRangeOfReasonsNoncompliance(String lowerInclusive, String upperInclusive) {
        return fetchRange(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.REASONS_NONCOMPLIANCE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>reasons_noncompliance IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchByReasonsNoncompliance(String... values) {
        return fetch(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.REASONS_NONCOMPLIANCE, values);
    }

    /**
     * Fetch records that have <code>chief_engineer BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchRangeOfChiefEngineer(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.CHIEF_ENGINEER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>chief_engineer IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchByChiefEngineer(Long... values) {
        return fetch(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.CHIEF_ENGINEER, values);
    }

    /**
     * Fetch records that have <code>datecheck BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchRangeOfDatecheck(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.DATECHECK, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>datecheck IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.ArchitecturalSupervisionRegister> fetchByDatecheck(LocalDateTime... values) {
        return fetch(ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER.DATECHECK, values);
    }
}
