/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkinabdullayev.jpacompositekey;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author ilkinabdullayev
 */
@Entity
public class Email implements Serializable {

    @EmbeddedId
    private EmailId emailId;

    private String email;

    public EmailId getEmailId() {
        return emailId;
    }

    public void setEmailId(EmailId emailId) {
        this.emailId = emailId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email{" + "emailId=" + emailId + ", email=" + email + '}';
    }

}
