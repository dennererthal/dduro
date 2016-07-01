/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddure.schema;

import com.ddure.data.Occurrence;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author denner
 */
public class OccurrenceTable {
    public static final String name = "occurrence";
    public static final class Columns {
        public static final String id = "id";
        public static final String ref_user = "ref_user";
        public static final String ref_location = "ref_location";
        public static final String description = "description";
        public static final String date = "date";
        public static final String image = "image";
        public static final String status = "status";
    }
    public static final String select = "select * from " + name;
    
    public static Occurrence fetchOne( ResultSet rs ) throws SQLException {
        Occurrence occurrence = new Occurrence();
        if (rs.next()) {
            occurrence.setId(rs.getInt(Columns.id));
            occurrence.setDate(rs.getDate(Columns.date));
            occurrence.setDescription(rs.getString(Columns.description));
            occurrence.setImage(rs.getString(Columns.image));
            occurrence.setRef_location(rs.getInt(Columns.ref_location));
            occurrence.setRef_user(rs.getInt(Columns.ref_user));
            occurrence.setStatus(rs.getString(Columns.status).charAt(0));
        }
        return occurrence;
    }
    
    public static List<Occurrence> fetchMany( ResultSet rs ) throws SQLException {
        List<Occurrence> list = new ArrayList<>();
        while (rs.next()) {
            Occurrence occurrence = new Occurrence();
            occurrence.setId(rs.getInt(Columns.id));
            occurrence.setDate(rs.getDate(Columns.date));
            occurrence.setDescription(rs.getString(Columns.description));
            occurrence.setImage(rs.getString(Columns.image));
            occurrence.setRef_location(rs.getInt(Columns.ref_location));
            occurrence.setRef_user(rs.getInt(Columns.ref_user));
            occurrence.setStatus(rs.getString(Columns.status).charAt(0));
            list.add(occurrence);
        }
        return list;
    }
}
