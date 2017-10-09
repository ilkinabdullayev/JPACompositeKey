/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkinabdullayev.jpacompositekey;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *
 * @author ilkinabdullayev
 */
@Entity
@IdClass(PhoneId.class)
public class Phone implements Serializable {

    @Id
    private long phoneId;

    @Id
    private long personId;

    private String pNumber;

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

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    @Override
    public String toString() {
        return "Phone{" + "phoneId=" + phoneId + ", personId=" + personId + ", pNumber=" + pNumber + '}';
    }
}
