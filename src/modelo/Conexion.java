/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;
import java.sql.Connection;
public class Conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/guia1";
    String user = "root";
    String password = "1234";
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return con;
    }
    
}
