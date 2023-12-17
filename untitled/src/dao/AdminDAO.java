package dao;

import database.util;
import entity.Admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDAO implements DAOInterface<Admin> {
    public static AdminDAO getInstance() {
        return new AdminDAO();
    }

    @Override
    public int insert(Admin admin) {
        try {
            Connection connection = util.getConnection();
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO Admin (ID, Name)" +
                    " VALUES (" + admin.getID() + ", " + admin.getName() + ")";
            util.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Admin admin) {
        try {
            Connection connection = util.getConnection();
            Statement statement = connection.createStatement();
            String sql = "UPDATE admin " +
                         " SET " +
                         " Name='"+ admin.getName() +"'"+
                         " WHERE ID=" +admin.getID() + "";

            util.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Admin admin) {
        try {
            Connection connection = util.getConnection();
            Statement statement = connection.createStatement();
            String sql = "DELETE from admin " +
                    " WHERE ID=" +admin.getID() + "";

            util.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<Admin> selectAll() {
        return null;
    }

    @Override
    public Admin selectById(Admin admin) {
        return null;
    }

    @Override
    public ArrayList<Admin> selectByCondition(String condition) {
        return null;
    }
}
