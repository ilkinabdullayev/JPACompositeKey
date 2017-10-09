/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkinabdullayev.jpacompositekey.complex;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

/**
 *
 * @author ilkinabdullayev
 */
@Entity
public class DogHouse implements Serializable {
    
    
    @Id
    private int dogId;
    
    @MapsId
    @OneToOne
    @JoinColumn(name = "DOG_ID")
    private Dog dog;
    
    
    /*@Id
    @OneToOne
    @JoinColumn(name = "DOG_ID")
    private Dog dog;*/
    
    private String brand;

    public int getDogId() {
        return dogId;
    }
    
    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "DogHouse{" + "dogId=" + dogId + ", dog=" + dog + ", brand=" + brand + '}';
    }
}
