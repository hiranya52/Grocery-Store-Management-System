/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grocerystore.management.controller;

import com.grocerystore.management.db.DBConnection;
import com.grocerystore.management.model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
