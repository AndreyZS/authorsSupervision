/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AccessRightsUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long usesSystem;
    private final Long accessRightsId;

    public AccessRightsUsers(AccessRightsUsers value) {
        this.usesSystem = value.usesSystem;
        this.accessRightsId = value.accessRightsId;
    }

    public AccessRightsUsers(
        Long usesSystem,
        Long accessRightsId
    ) {
        this.usesSystem = usesSystem;
        this.accessRightsId = accessRightsId;
    }

    /**
     * Getter for <code>access_rights_users.uses_system</code>.
     */
    public Long getUsesSystem() {
        return this.usesSystem;
    }

    /**
     * Getter for <code>access_rights_users.access_rights_id</code>.
     */
    public Long getAccessRightsId() {
        return this.accessRightsId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final AccessRightsUsers other = (AccessRightsUsers) obj;
        if (usesSystem == null) {
            if (other.usesSystem != null)
                return false;
        }
        else if (!usesSystem.equals(other.usesSystem))
            return false;
        if (accessRightsId == null) {
            if (other.accessRightsId != null)
                return false;
        }
        else if (!accessRightsId.equals(other.accessRightsId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.usesSystem == null) ? 0 : this.usesSystem.hashCode());
        result = prime * result + ((this.accessRightsId == null) ? 0 : this.accessRightsId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AccessRightsUsers (");

        sb.append(usesSystem);
        sb.append(", ").append(accessRightsId);

        sb.append(")");
        return sb.toString();
    }
}
