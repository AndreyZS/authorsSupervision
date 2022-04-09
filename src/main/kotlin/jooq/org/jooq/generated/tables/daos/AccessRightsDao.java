/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.daos;


import java.util.List;

import org.jooq.Configuration;
import org.jooq.generated.tables.AccessRights;
import org.jooq.generated.tables.records.AccessRightsRecord;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AccessRightsDao extends DAOImpl<AccessRightsRecord, org.jooq.generated.tables.pojos.AccessRights, Long> {

    /**
     * Create a new AccessRightsDao without any configuration
     */
    public AccessRightsDao() {
        super(AccessRights.ACCESS_RIGHTS, org.jooq.generated.tables.pojos.AccessRights.class);
    }

    /**
     * Create a new AccessRightsDao with an attached configuration
     */
    public AccessRightsDao(Configuration configuration) {
        super(AccessRights.ACCESS_RIGHTS, org.jooq.generated.tables.pojos.AccessRights.class, configuration);
    }

    @Override
    public Long getId(org.jooq.generated.tables.pojos.AccessRights object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.AccessRights> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(AccessRights.ACCESS_RIGHTS.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.AccessRights> fetchById(Long... values) {
        return fetch(AccessRights.ACCESS_RIGHTS.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public org.jooq.generated.tables.pojos.AccessRights fetchOneById(Long value) {
        return fetchOne(AccessRights.ACCESS_RIGHTS.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.AccessRights> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(AccessRights.ACCESS_RIGHTS.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.AccessRights> fetchByName(String... values) {
        return fetch(AccessRights.ACCESS_RIGHTS.NAME, values);
    }
}