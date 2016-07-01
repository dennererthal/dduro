/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddure.db.dao;

import com.ddure.data.Location;
import com.ddure.db.Database;
import com.ddure.schema.LocationTable;
import java.sql.ResultSet;

/**
 *
 * @author lucas
 */
public class LocationDAO {
    public static boolean insertLocation(Location location) {
        Database db = Database.getInstance();
        
        try {
            String sql = "insert into " + LocationTable.name 
                + " values "
                + "(default,"
                + "'" + location.getLat() + "',"
                + "'" + location.getLon() + "')";
            db.executeUpdate( sql );
            
            ResultSet rs = db.executeQuery( LocationTable.select );
            int cont = 0;
            
            while ( rs.next() ) {
                cont = rs.getInt( "id" );
            }
            
            location.setId( cont );
        } catch (Exception e) {
            System.out.println("Erro ao inserir location = " + e);
            return false;
        } finally {
            db.release();
        }
        
        return true;
    }
}