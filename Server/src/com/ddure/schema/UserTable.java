/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddure.schema;

import com.ddure.data.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author denner
 */
public class UserTable {
    public static final String name = "user";
    public static final class Columns {
        public static final String id = "id";
        public static final String name = "name";
        public static final String cpf = "cpf";
        public static final String email = "email";
        public static final String password = "password";
        public static final String status = "status";
    }
    public static final String select = "select * from " + name;
    
    public static User fetchOne( ResultSet rs ) throws SQLException {
        User user = new User();
        if (rs.next()) {
            user.setId( rs.getInt(Columns.id) );
            user.setName(rs.getString(Columns.name) );
            user.setCpf(rs.getString(Columns.cpf) );
            user.setEmail(rs.getString(Columns.email) );
            user.setPassword(rs.getString(Columns.password) );
            user.setStatus(rs.getString(OccurrenceTable.Columns.status).charAt(0));
        }
        return user;
    }
    
    public static List<User> fetchMany( ResultSet rs ) throws SQLException {
        List<User> list = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setId( rs.getInt(Columns.id) );
            user.setName(rs.getString(Columns.name) );
            user.setCpf(rs.getString(Columns.cpf) );
            user.setEmail(rs.getString(Columns.email) );
            user.setPassword(rs.getString(Columns.password) );
            user.setStatus(rs.getString(OccurrenceTable.Columns.status).charAt(0));
            list.add(user);
        }
        return list;
    }
}
