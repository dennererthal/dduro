/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddure.db.dao;

import com.ddure.data.User;
import com.ddure.db.Database;
import com.ddure.schema.UserTable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author heryk07
 */
public class UserDAO {

    public boolean insertUser(User user) {
        Database db = Database.getInstance();
        try {
            String sql = "insert into " + UserTable.name + " "
                    + "(" + UserTable.Columns.id + ","
                    + UserTable.Columns.name + " ,"
                    + UserTable.Columns.cpf + " ,"
                    + UserTable.Columns.email + " ,"
                    + UserTable.Columns.password + " ,"
                    + UserTable.Columns.status + " )"
                    + " values "
                    + "(default,"
                    + "'" + user.getName() + "',"
                    + "'" + user.getCpf() + "',"
                    + "'" + user.getEmail() + "',"
                    + "'" + user.getPassword().hashCode() + "',"
                    + user.getStatus() + ")";
            db.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Erro ao inserir user = " + e);
            return false;
        } finally {
            db.release();
        }
        return true;
    }

    public boolean updateUser(User user) {
        Database db = Database.getInstance();
        try {
            String sql = "update " + UserTable.name + " set "
                    + UserTable.Columns.name + " = '" + user.getName() + "', "
                    + UserTable.Columns.cpf + " = '" + user.getCpf() + "', "
                    + UserTable.Columns.email + " = '" + user.getEmail() + "', "
                    + UserTable.Columns.password + " = '" + user.getPassword().hashCode() + "', "
                    + UserTable.Columns.status + " = " + user.getStatus() + " "
                    + "where " + UserTable.Columns.id + " = " + user.getId() + " ";

            db.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Erro ao alterar user = " + e);
            return false;
        } finally {
            db.release();
        }
        return true;
    }

    public User getUserById(int id) {
        Database db = Database.getInstance();
        try {
            return UserTable.fetchOne(db.executeQuery(UserTable.select + " where " + UserTable.Columns.id + " = " + id));
        } catch (SQLException e) {
            System.out.println("Erro ao buscar user = " + e);
            return null;
        } finally {
            db.release();
        }
    }

    public User getUserByStatus(int status) {
        Database db = Database.getInstance();
        try {
            return UserTable.fetchOne(db.executeQuery(UserTable.select + " where " + UserTable.Columns.status + " = " + status));
        } catch (SQLException e) {
            System.out.println("Erro ao buscar user = " + e);
            return null;
        } finally {
            db.release();
        }
    }

    public List<User> getUsers() {
        Database db = Database.getInstance();
        try {
            return UserTable.fetchMany(db.executeQuery(UserTable.select + " order by " + UserTable.Columns.id));
        } catch (SQLException e) {
            System.out.println("Erro ao buscar user = " + e);
            return null;
        } finally {
            db.release();
        }
    }

    public User getAuthentication(String cpf, String password) {
        Database db = Database.getInstance();
        try {
            return UserTable.fetchOne(db.executeQuery(UserTable.select + " where " + UserTable.Columns.cpf + " = " + cpf
            + "AND" + UserTable.Columns.password + " = " + password.hashCode()));
        } catch (SQLException e) {
            System.out.println("Erro ao buscar user = " + e);
            return null;
        } finally {
            db.release();

        }
    }

}
