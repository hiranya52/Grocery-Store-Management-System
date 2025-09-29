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
    
}
