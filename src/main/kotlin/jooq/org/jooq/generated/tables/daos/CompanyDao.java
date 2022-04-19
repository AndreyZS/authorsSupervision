/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.daos;


import java.util.List;

import org.jooq.Configuration;
import org.jooq.generated.tables.Company;
import org.jooq.generated.tables.records.CompanyRecord;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CompanyDao extends DAOImpl<CompanyRecord, org.jooq.generated.tables.pojos.Company, Long> {

    /**
     * Create a new CompanyDao without any configuration
     */
    public CompanyDao() {
        super(Company.COMPANY, org.jooq.generated.tables.pojos.Company.class);
    }

    /**
     * Create a new CompanyDao with an attached configuration
     */
    public CompanyDao(Configuration configuration) {
        super(Company.COMPANY, org.jooq.generated.tables.pojos.Company.class, configuration);
    }

    @Override
    public Long getId(org.jooq.generated.tables.pojos.Company object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.Company> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Company.COMPANY.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.Company> fetchById(Long... values) {
        return fetch(Company.COMPANY.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public org.jooq.generated.tables.pojos.Company fetchOneById(Long value) {
        return fetchOne(Company.COMPANY.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.Company> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Company.COMPANY.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.Company> fetchByName(String... values) {
        return fetch(Company.COMPANY.NAME, values);
    }

    /**
     * Fetch a unique record that has <code>name = value</code>
     */
    public org.jooq.generated.tables.pojos.Company fetchOneByName(String value) {
        return fetchOne(Company.COMPANY.NAME, value);
    }
}
