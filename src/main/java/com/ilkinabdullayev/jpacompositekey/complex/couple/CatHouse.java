/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkinabdullayev.jpacompositekey.complex.couple;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author ilkinabdullayev
 */
@Entity
@IdClass(CatHouseId.class)
public class CatHouse implements Serializable {
    
    @Id
    @OneToOne
    @JoinColumn(name="OWNER_ID")
    private Owner owner;
     
    @Id
    @OneToOne
    @JoinColumn(name="CAT_ID")
    private Cat cat;
    
    private String brand;
    
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
