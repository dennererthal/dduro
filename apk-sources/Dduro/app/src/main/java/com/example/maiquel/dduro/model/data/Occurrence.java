package com.example.maiquel.dduro.model.data;

import android.graphics.Bitmap;

import java.util.Date;

/**
 * Created by maiquel on 09/05/16.
 */
public class Occurrence
{
    private int id;
    private User user;
    private Location location;
    private String description;
    private Date date;
    private Bitmap image;
    private String imageUrl;
    private char status;


    public Occurrence(int id, User user, Location location, String description, Date date, Bitmap image, String imageUrl, char status)
    {
        this.id = id;
        this.user = user;
        this.location = location;
        this.description = description;
        this.date = date;
        this.image = image;
        this.status = status;
        this.imageUrl = imageUrl;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Bitmap getImage()
    {
        return image;
    }

    public void setImage(Bitmap image)
    {
        this.image = image;
    }

    public char getStatus()
    {
        return status;
    }

    public void setStatus(char status)
    {
        this.status = status;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }
}
