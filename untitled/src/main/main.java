package main;

import java.sql.Connection;
import database.util;
public class main {
    public static void main(String[] args) {
        Connection connection = util.getConnection();
        util.printInfo(connection);
        util.closeConnection(connection);
    }
}
