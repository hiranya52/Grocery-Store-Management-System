/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grocerystore.management.db;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hiranyamendis
 */
public class DBConnection {
    
    private java.sql.Connection connection;  
   private static DBConnection dBConnection;
   private DBConnection() throws ClassNotFoundException, SQLException{
       Class.forName("com.mysql.cj.jdbc.Driver");
       connection=DriverManager.getConnection("jdbc:mysql://localhost/ThogaKade", "root", "12345678");
   }
   public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
       if(dBConnection==null){
           dBConnection=new DBConnection();
       }
       return dBConnection;
   }
   public java.sql.Connection getConnection(){
       return connection;
   }
    
}
