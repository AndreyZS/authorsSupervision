/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.records;


import java.time.LocalDate;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.generated.tables.UserSystem;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserSystemRecord extends UpdatableRecordImpl<UserSystemRecord> implements Record9<Long, String, String, LocalDate, LocalDate, LocalDate, Boolean, String, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>user_system.id</code>.
     */
    public UserSystemRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>user_system.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>user_system.login</code>.
     */
    public UserSystemRecord setLogin(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>user_system.login</code>.
     */
    public String getLogin() {
        return (String) get(1);
    }

    /**
     * Setter for <code>user_system.password</code>.
     */
    public UserSystemRecord setPassword(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>user_system.password</code>.
     */
    public String getPassword() {
        return (String) get(2);
    }

    /**
     * Setter for <code>user_system.date_change_password</code>.
     */
    public UserSystemRecord setDateChangePassword(LocalDate value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>user_system.date_change_password</code>.
     */
    public LocalDate getDateChangePassword() {
        return (LocalDate) get(3);
    }

    /**
     * Setter for <code>user_system.date_registration</code>.
     */
    public UserSystemRecord setDateRegistration(LocalDate value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>user_system.date_registration</code>.
     */
    public LocalDate getDateRegistration() {
        return (LocalDate) get(4);
    }

    /**
     * Setter for <code>user_system.online_date</code>.
     */
    public UserSystemRecord setOnlineDate(LocalDate value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>user_system.online_date</code>.
     */
    public LocalDate getOnlineDate() {
        return (LocalDate) get(5);
    }

    /**
     * Setter for <code>user_system.locked</code>.
     */
    public UserSystemRecord setLocked(Boolean value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>user_system.locked</code>.
     */
    public Boolean getLocked() {
        return (Boolean) get(6);
    }

    /**
     * Setter for <code>user_system.fio</code>.
     */
    public UserSystemRecord setFio(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>user_system.fio</code>.
     */
    public String getFio() {
        return (String) get(7);
    }

    /**
     * Setter for <code>user_system.division_id</code>.
     */
    public UserSystemRecord setDivisionId(Long value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>user_system.division_id</code>.
     */
    public Long getDivisionId() {
        return (Long) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, String, String, LocalDate, LocalDate, LocalDate, Boolean, String, Long> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Long, String, String, LocalDate, LocalDate, LocalDate, Boolean, String, Long> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return UserSystem.USER_SYSTEM.ID;
    }

    @Override
    public Field<String> field2() {
        return UserSystem.USER_SYSTEM.LOGIN;
    }

    @Override
    public Field<String> field3() {
        return UserSystem.USER_SYSTEM.PASSWORD;
    }

    @Override
    public Field<LocalDate> field4() {
        return UserSystem.USER_SYSTEM.DATE_CHANGE_PASSWORD;
    }

    @Override
    public Field<LocalDate> field5() {
        return UserSystem.USER_SYSTEM.DATE_REGISTRATION;
    }

    @Override
    public Field<LocalDate> field6() {
        return UserSystem.USER_SYSTEM.ONLINE_DATE;
    }

    @Override
    public Field<Boolean> field7() {
        return UserSystem.USER_SYSTEM.LOCKED;
    }

    @Override
    public Field<String> field8() {
        return UserSystem.USER_SYSTEM.FIO;
    }

    @Override
    public Field<Long> field9() {
        return UserSystem.USER_SYSTEM.DIVISION_ID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getLogin();
    }

    @Override
    public String component3() {
        return getPassword();
    }

    @Override
    public LocalDate component4() {
        return getDateChangePassword();
    }

    @Override
    public LocalDate component5() {
        return getDateRegistration();
    }

    @Override
    public LocalDate component6() {
        return getOnlineDate();
    }

    @Override
    public Boolean component7() {
        return getLocked();
    }

    @Override
    public String component8() {
        return getFio();
    }

    @Override
    public Long component9() {
        return getDivisionId();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getLogin();
    }

    @Override
    public String value3() {
        return getPassword();
    }

    @Override
    public LocalDate value4() {
        return getDateChangePassword();
    }

    @Override
    public LocalDate value5() {
        return getDateRegistration();
    }

    @Override
    public LocalDate value6() {
        return getOnlineDate();
    }

    @Override
    public Boolean value7() {
        return getLocked();
    }

    @Override
    public String value8() {
        return getFio();
    }

    @Override
    public Long value9() {
        return getDivisionId();
    }

    @Override
    public UserSystemRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public UserSystemRecord value2(String value) {
        setLogin(value);
        return this;
    }

    @Override
    public UserSystemRecord value3(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public UserSystemRecord value4(LocalDate value) {
        setDateChangePassword(value);
        return this;
    }

    @Override
    public UserSystemRecord value5(LocalDate value) {
        setDateRegistration(value);
        return this;
    }

    @Override
    public UserSystemRecord value6(LocalDate value) {
        setOnlineDate(value);
        return this;
    }

    @Override
    public UserSystemRecord value7(Boolean value) {
        setLocked(value);
        return this;
    }

    @Override
    public UserSystemRecord value8(String value) {
        setFio(value);
        return this;
    }

    @Override
    public UserSystemRecord value9(Long value) {
        setDivisionId(value);
        return this;
    }

    @Override
    public UserSystemRecord values(Long value1, String value2, String value3, LocalDate value4, LocalDate value5, LocalDate value6, Boolean value7, String value8, Long value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserSystemRecord
     */
    public UserSystemRecord() {
        super(UserSystem.USER_SYSTEM);
    }

    /**
     * Create a detached, initialised UserSystemRecord
     */
    public UserSystemRecord(Long id, String login, String password, LocalDate dateChangePassword, LocalDate dateRegistration, LocalDate onlineDate, Boolean locked, String fio, Long divisionId) {
        super(UserSystem.USER_SYSTEM);

        setId(id);
        setLogin(login);
        setPassword(password);
        setDateChangePassword(dateChangePassword);
        setDateRegistration(dateRegistration);
        setOnlineDate(onlineDate);
        setLocked(locked);
        setFio(fio);
        setDivisionId(divisionId);
    }

    /**
     * Create a detached, initialised UserSystemRecord
     */
    public UserSystemRecord(org.jooq.generated.tables.pojos.UserSystem value) {
        super(UserSystem.USER_SYSTEM);

        if (value != null) {
            setId(value.getId());
            setLogin(value.getLogin());
            setPassword(value.getPassword());
            setDateChangePassword(value.getDateChangePassword());
            setDateRegistration(value.getDateRegistration());
            setOnlineDate(value.getOnlineDate());
            setLocked(value.getLocked());
            setFio(value.getFio());
            setDivisionId(value.getDivisionId());
        }
    }
}
