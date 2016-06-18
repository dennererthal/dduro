/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddure.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author Denner Erthal
 */
public class Database {
    private static Database instance = null;
    private static Connection connection = null;
    /**
     *
     */
    public Database() {
        stablishConnection();
    }

    /**
     *
     * @return
     */
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    /**
     *
     */
    private void stablishConnection() {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("jdbc/dduro");
            connection = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public Connection getConnection() {
        if (connection == null) {
            throw new RuntimeException(" Could not stablish connection to database ");
        }
        return connection;
    }

    /**
     *
     * @param sql
     */
    public void executeUpdate(String sql) {
        Statement stmt;
        try {
            if (connection == null) {
                throw new RuntimeException("Not connected to database!");
            }
            if (connection.isClosed()) {
                stablishConnection();
            }
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param sql
     * @return
     */
    public ResultSet executeQuery(String sql) {
        Statement stmt;
        try {
            if (connection == null) {
                throw new RuntimeException("Not connected to database!");
            }
            if (connection.isClosed()) {
                stablishConnection();
            }
            stmt = connection.createStatement();
            return stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     */
    public void release() {
        //need to release the database connection to avoid
        //memory leak when too much connections are stablished
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
