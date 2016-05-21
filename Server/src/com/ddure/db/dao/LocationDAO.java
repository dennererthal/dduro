/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dduro.db.dao;

import com.dduro.data.Location;
import com.dduro.db.Database;
import com.dduro.schema.LocationTable;

/**
 *
 * @author lucas
 */
public class LocationDAO {
    public boolean insertLocation(Location location) {
        Database db = Database.getInstance();
        
        try {
            String sql = "insert into " + LocationTable.name 
                + "values (" + LocationTable.Columns.id + ","
                + LocationTable.Columns.lat + " ,"
                + LocationTable.Columns.lon + " lon) "
                + "(default,"
                + "'" + location.getLat() + "',"
                + "'" + location.getLon() + "')";
            db.executeUpdate( sql );
        } catch (Exception e) {
            System.out.println("Erro ao inserir location = " + e);
            return false;
        } finally {
            db.release();
        }
        
        return true;
    }
}