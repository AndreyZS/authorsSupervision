/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.pojos;


import java.io.Serializable;
import java.time.LocalDate;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserSystem implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long      id;
    private final String    login;
    private final String    password;
    private final LocalDate dateChangePassword;
    private final LocalDate dateRegistration;
    private final LocalDate onlineDate;
    private final Boolean   locked;
    private final String    fio;
    private final Long      divisionId;

    public UserSystem(UserSystem value) {
        this.id = value.id;
        this.login = value.login;
        this.password = value.password;
        this.dateChangePassword = value.dateChangePassword;
        this.dateRegistration = value.dateRegistration;
        this.onlineDate = value.onlineDate;
        this.locked = value.locked;
        this.fio = value.fio;
        this.divisionId = value.divisionId;
    }

    public UserSystem(
        Long      id,
        String    login,
        String    password,
        LocalDate dateChangePassword,
        LocalDate dateRegistration,
        LocalDate onlineDate,
        Boolean   locked,
        String    fio,
        Long      divisionId
    ) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.dateChangePassword = dateChangePassword;
        this.dateRegistration = dateRegistration;
        this.onlineDate = onlineDate;
        this.locked = locked;
        this.fio = fio;
        this.divisionId = divisionId;
    }

    /**
     * Getter for <code>user_system.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for <code>user_system.login</code>.
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Getter for <code>user_system.password</code>.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Getter for <code>user_system.date_change_password</code>.
     */
    public LocalDate getDateChangePassword() {
        return this.dateChangePassword;
    }

    /**
     * Getter for <code>user_system.date_registration</code>.
     */
    public LocalDate getDateRegistration() {
        return this.dateRegistration;
    }

    /**
     * Getter for <code>user_system.online_date</code>.
     */
    public LocalDate getOnlineDate() {
        return this.onlineDate;
    }

    /**
     * Getter for <code>user_system.locked</code>.
     */
    public Boolean getLocked() {
        return this.locked;
    }

    /**
     * Getter for <code>user_system.fio</code>.
     */
    public String getFio() {
        return this.fio;
    }

    /**
     * Getter for <code>user_system.division_id</code>.
     */
    public Long getDivisionId() {
        return this.divisionId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final UserSystem other = (UserSystem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (login == null) {
            if (other.login != null)
                return false;
        }
        else if (!login.equals(other.login))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        }
        else if (!password.equals(other.password))
            return false;
        if (dateChangePassword == null) {
            if (other.dateChangePassword != null)
                return false;
        }
        else if (!dateChangePassword.equals(other.dateChangePassword))
            return false;
        if (dateRegistration == null) {
            if (other.dateRegistration != null)
                return false;
        }
        else if (!dateRegistration.equals(other.dateRegistration))
            return false;
        if (onlineDate == null) {
            if (other.onlineDate != null)
                return false;
        }
        else if (!onlineDate.equals(other.onlineDate))
            return false;
        if (locked == null) {
            if (other.locked != null)
                return false;
        }
        else if (!locked.equals(other.locked))
            return false;
        if (fio == null) {
            if (other.fio != null)
                return false;
        }
        else if (!fio.equals(other.fio))
            return false;
        if (divisionId == null) {
            if (other.divisionId != null)
                return false;
        }
        else if (!divisionId.equals(other.divisionId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.login == null) ? 0 : this.login.hashCode());
        result = prime * result + ((this.password == null) ? 0 : this.password.hashCode());
        result = prime * result + ((this.dateChangePassword == null) ? 0 : this.dateChangePassword.hashCode());
        result = prime * result + ((this.dateRegistration == null) ? 0 : this.dateRegistration.hashCode());
        result = prime * result + ((this.onlineDate == null) ? 0 : this.onlineDate.hashCode());
        result = prime * result + ((this.locked == null) ? 0 : this.locked.hashCode());
        result = prime * result + ((this.fio == null) ? 0 : this.fio.hashCode());
        result = prime * result + ((this.divisionId == null) ? 0 : this.divisionId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserSystem (");

        sb.append(id);
        sb.append(", ").append(login);
        sb.append(", ").append(password);
        sb.append(", ").append(dateChangePassword);
        sb.append(", ").append(dateRegistration);
        sb.append(", ").append(onlineDate);
        sb.append(", ").append(locked);
        sb.append(", ").append(fio);
        sb.append(", ").append(divisionId);

        sb.append(")");
        return sb.toString();
    }
}
