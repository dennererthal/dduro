/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddure.schema;

import com.ddure.data.Location;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author denner
 */
public class LocationTable {
    public static final String name = "location";
    public static final class Columns {
        public static final String id = "id";
        public static final String lat = "lat";
        public static final String lon = "lon";
    }
    public static final String select = "select * from " + name;
    
    public static Location fetchOne( ResultSet rs ) throws SQLException {
        Location location = new Location();
        if (rs.next()) {
            location.setId( rs.getInt(Columns.id) );
            location.setLat(rs.getString(Columns.lat) );
            location.setLon(rs.getString(Columns.lon) );
        }
        return location;
    }
    
    public static List<Location> fetchMany( ResultSet rs ) throws SQLException {
        List<Location> list = new ArrayList<>();
        while (rs.next()) {
            Location location = new Location();
            location.setId( rs.getInt(Columns.id) );
            location.setLat(rs.getString(Columns.lat) );
            location.setLon(rs.getString(Columns.lon) );
            list.add(location);
        }
        return list;
    }
}
