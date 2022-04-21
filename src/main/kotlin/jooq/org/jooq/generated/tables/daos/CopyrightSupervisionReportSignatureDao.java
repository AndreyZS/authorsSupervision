/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.daos;


import java.util.List;

import org.jooq.Configuration;
import org.jooq.Record2;
import org.jooq.generated.tables.CopyrightSupervisionReportSignature;
import org.jooq.generated.tables.records.CopyrightSupervisionReportSignatureRecord;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CopyrightSupervisionReportSignatureDao extends DAOImpl<CopyrightSupervisionReportSignatureRecord, org.jooq.generated.tables.pojos.CopyrightSupervisionReportSignature, Record2<Long, Long>> {

    /**
     * Create a new CopyrightSupervisionReportSignatureDao without any
     * configuration
     */
    public CopyrightSupervisionReportSignatureDao() {
        super(CopyrightSupervisionReportSignature.COPYRIGHT_SUPERVISION_REPORT_SIGNATURE, org.jooq.generated.tables.pojos.CopyrightSupervisionReportSignature.class);
    }

    /**
     * Create a new CopyrightSupervisionReportSignatureDao with an attached
     * configuration
     */
    public CopyrightSupervisionReportSignatureDao(Configuration configuration) {
        super(CopyrightSupervisionReportSignature.COPYRIGHT_SUPERVISION_REPORT_SIGNATURE, org.jooq.generated.tables.pojos.CopyrightSupervisionReportSignature.class, configuration);
    }

    @Override
    public Record2<Long, Long> getId(org.jooq.generated.tables.pojos.CopyrightSupervisionReportSignature object) {
        return compositeKeyRecord(object.getEmployeeId(), object.getCopyrightSupervisionReportId());
    }

    /**
     * Fetch records that have <code>employee_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.CopyrightSupervisionReportSignature> fetchRangeOfEmployeeId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(CopyrightSupervisionReportSignature.COPYRIGHT_SUPERVISION_REPORT_SIGNATURE.EMPLOYEE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>employee_id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.CopyrightSupervisionReportSignature> fetchByEmployeeId(Long... values) {
        return fetch(CopyrightSupervisionReportSignature.COPYRIGHT_SUPERVISION_REPORT_SIGNATURE.EMPLOYEE_ID, values);
    }

    /**
     * Fetch records that have <code>copyright_supervision_report_id BETWEEN
     * lowerInclusive AND upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.CopyrightSupervisionReportSignature> fetchRangeOfCopyrightSupervisionReportId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(CopyrightSupervisionReportSignature.COPYRIGHT_SUPERVISION_REPORT_SIGNATURE.COPYRIGHT_SUPERVISION_REPORT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>copyright_supervision_report_id IN
     * (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.CopyrightSupervisionReportSignature> fetchByCopyrightSupervisionReportId(Long... values) {
        return fetch(CopyrightSupervisionReportSignature.COPYRIGHT_SUPERVISION_REPORT_SIGNATURE.COPYRIGHT_SUPERVISION_REPORT_ID, values);
    }
}
