package com.example.maiquel.dduro.model.data;

/**
 * Created by maiquel on 09/05/16.
 */
public class Location
{
    private int id;
    private String latitude;
    private String longitude;

    public Location(int id, String latitude, String longitude)
    {
        this.setId(id);
        this.setLatitude(latitude);
        this.setLongitude(longitude);
    }

    public Location(String latitude, String longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getLatitude()
    {
        return latitude;
    }

    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    public String getLongitude()
    {
        return longitude;
    }

    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }
}
