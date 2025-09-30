/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grocerystore.management.controller;

import com.grocerystore.management.db.DBConnection;
import com.grocerystore.management.model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hiranyamendis
 */
public class ItemController {
    
    public static boolean addItem(Item item) throws ClassNotFoundException, SQLException {
        String SQL = "Insert into Item Values(?,?,?,?)";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, item.getCode());
        stm.setObject(2, item.getDescription());
        stm.setObject(3, item.getUnitPrice());
        stm.setObject(4, item.getQtyOnHand());
        int res = stm.executeUpdate();
        return res > 0;
    }
    
    
    public static Item searchItem(String code) throws ClassNotFoundException, SQLException {
        String SQL = "Select * From Item where code='" + code + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            String description = rst.getString("Description");
            double price = rst.getDouble("unitPrice");
            int qty = rst.getInt("qtyOnHand");
            return new Item(code, description, price, qty);
        }
        return null;
    }
    
    public static boolean deleteItem(String code) throws ClassNotFoundException, SQLException {
        String SQL = "Delete From Item where code='" + code + "'";
        Statement stm = DBConnection.getInstance().getConnection().createStatement();
        return stm.executeUpdate(SQL) > 0;
    }
    
    public static boolean updateItem(Item item) throws ClassNotFoundException, SQLException {
        String SQL = "Update Item set description=?, unitPrice=?, qtyOnHand=? where code=?";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(4, item.getCode());
        stm.setObject(1, item.getDescription());
        stm.setObject(2, item.getUnitPrice());
        stm.setObject(3, item.getQtyOnHand());
        return stm.executeUpdate() > 0;
    }
    
    
}
