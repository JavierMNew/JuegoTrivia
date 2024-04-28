/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conexionSQLServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author javie
 */
public class Conexion {
    private static final String BASE_URL = "jdbc:sqlserver://localhost:1433";
    private static final String USER = "ingles";
    private static final String PASSWORD = "ingles";
    
    public static Connection getConnection (String  englishOdyssey) throws SQLException {
        String url = BASE_URL + ";englishOdyssey=" + englishOdyssey + ";trustServerCertificate=true";
        return DriverManager.getConnection(url, USER, PASSWORD);
    }
}
