/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkinabdullayev.jpacompositekey;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author ilkinabdullayev
 */
@Embeddable
public class EmailId implements Serializable {

    private long emailId;

    private long personId;

    public EmailId() {
    }

    public EmailId(long emailId, long personId) {
        this.emailId = emailId;
        this.personId = personId;
    }
    
    
    public long getEmailId() {
        return emailId;
    }

    public void setEmailId(long emailId) {
        this.emailId = emailId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (int) (this.emailId ^ (this.emailId >>> 32));
        hash = 41 * hash + (int) (this.personId ^ (this.personId >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmailId other = (EmailId) obj;
        if (this.emailId != other.emailId) {
            return false;
        }
        if (this.personId != other.personId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmailId{" + "emailId=" + emailId + ", personId=" + personId + '}';
    }
}
