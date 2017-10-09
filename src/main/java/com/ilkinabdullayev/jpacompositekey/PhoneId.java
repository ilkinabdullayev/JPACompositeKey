/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkinabdullayev.jpacompositekey;

import java.io.Serializable;

/**
 *
 * @author ilkinabdullayev
 */
public class PhoneId implements Serializable {

    private long phoneId;

    private long personId;

    public PhoneId() {
    }

    public PhoneId(long phoneId, long personId) {
        this.phoneId = phoneId;
        this.personId = personId;
    }

    public long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(long phoneId) {
        this.phoneId = phoneId;
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
        hash = 41 * hash + (int) (this.phoneId ^ (this.phoneId >>> 32));
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
        final PhoneId other = (PhoneId) obj;
        if (this.phoneId != other.phoneId) {
            return false;
        }
        if (this.personId != other.personId) {
            return false;
        }
        return true;
    }

}
