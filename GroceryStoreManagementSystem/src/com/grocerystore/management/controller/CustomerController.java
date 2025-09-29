/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grocerystore.management.controller;

import com.grocerystore.management.db.DBConnection;
import com.grocerystore.management.model.Customer;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author hiranyamendis
 */
public class CustomerController {
    
    public static boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException{
        String SQL = "Insert into Customer Values(?,?,?,?)";
        java.sql.Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, customer.getId());
        stm.setObject(2, customer.getName());
        stm.setObject(3, customer.getAddress());
        stm.setObject(4, customer.getSalary());
        int res = stm.executeUpdate();
        return res > 0;
    }
    
    public static Customer searchCustomer(String id) throws ClassNotFoundException, SQLException{
        String SQL = "Select * From Customer Where id='"+id+"'";
        java.sql.Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if(rst.next()){
            String name = rst.getString("name");
            String address = rst.getString("address");
            double salary = rst.getDouble("salary");
            return new Customer(id, name, address, salary);
        }
        return null;
    }
    
    public static boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException{
        String SQL = "Delete From Customer where id='" + id + "'";
        Statement stm = DBConnection.getInstance().getConnection().createStatement();
        return stm.executeUpdate(SQL) > 0;
    }
    
    public static boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        String SQL = "Update Customer set name=?, address=?, salary=? where id=?";
        java.sql.Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(4, customer.getId());
        stm.setObject(1, customer.getName());
        stm.setObject(2, customer.getAddress());
        stm.setObject(3, customer.getSalary());
        return stm.executeUpdate() > 0;
    }
    
}
