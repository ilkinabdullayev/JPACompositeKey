/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkinabdullayev.jpacompositekey.complex.couple;

/**
 *
 * @author ilkinabdullayev
 */
public class CatHouseId {
    
    private int cat;
    private int owner;

    public CatHouseId() {
    }

    public CatHouseId(int cat, int owner) {
        this.cat = cat;
        this.owner = owner;
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.cat;
        hash = 97 * hash + this.owner;
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
        final CatHouseId other = (CatHouseId) obj;
        if (this.cat != other.cat) {
            return false;
        }
        if (this.owner != other.owner) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CatHouseId{" + "cat=" + cat + ", owner=" + owner + '}';
    }

}
