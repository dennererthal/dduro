/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddure.data;

import java.util.Date;

/**
 *
 * @author heryk07
 */
public class Occurrence {
    
    private int id;
    private int ref_user;
    private int ref_location;
    private String description;
    private Date date;
    private String image;
    private char status;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the ref_user
     */
    public int getRef_user() {
        return ref_user;
    }

    /**
     * @param ref_user the ref_user to set
     */
    public void setRef_user(int ref_user) {
        this.ref_user = ref_user;
    }

    /**
     * @return the ref_location
     */
    public int getRef_location() {
        return ref_location;
    }

    /**
     * @param ref_location the ref_location to set
     */
    public void setRef_location(int ref_location) {
        this.ref_location = ref_location;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the status
     */
    public char getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(char status) {
        this.status = status;
    }
    
}
