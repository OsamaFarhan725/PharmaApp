/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pharmacy_queries extends QUERY_BASE {
    
    public static ResultSet FetchMedicineList(int branch_id)
    {
        try {
            
            query = "SELECT product.product_id, product.product_name, product.product_type, product.product_price FROM product WHERE product.branch_id = ?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setInt(1, branch_id);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
             Logger.getLogger(Customer_queries.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
    
    }
    public static ResultSet FetchPharmacyActive(int branch_id)
    {
        try {
            
            query = "SELECT active_order.order_id, product.product_name, customer.name, driver.name FROM active_order INNER JOIN product ON active_order.product_id = product.product_id INNER JOIN driver ON active_order.driver_id = driver.driver_id INNER JOIN customer ON active_order.customer_id = customer.customer_id WHERE active_order.branch_id = ?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setInt(1, branch_id);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
             Logger.getLogger(Customer_queries.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
    }
    public static ResultSet FetchPharmacyBoard(int branch_id)
    {
        try {
            query = "SELECT  order_board.order_id, product.product_name, customer.name,NULL FROM order_board INNER JOIN product ON order_board.product_id = product.product_id INNER JOIN customer ON order_board.customer_id = customer.customer_id WHERE order_board.branch_id = ?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setInt(1, branch_id);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
             Logger.getLogger(Customer_queries.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
    }
    public static void DeleteMedicine(int product_id,int branch_id)
    {
        try {
            query = "DELETE FROM product WHERE product.product_id = ? AND product.branch_id = ?";
        stmt = Database_connection.connectToDB().prepareStatement(query);
        stmt.setInt(1, product_id);
        stmt.setInt(2, branch_id);
        stmt.execute();
        } catch (SQLException ex) {
             Logger.getLogger(Customer_queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void AddMedicine(String product_name,String product_type,double product_price,int branch_id)
    {
    
        try {
            
            query = "INSERT INTO `product` (product.branch_id,product.product_name,product.product_type,product.product_price) VALUES (?,?,?,?)";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setInt(1, branch_id);
            stmt.setString(2, product_name);
            stmt.setString(3, product_type);
            stmt.setDouble(4, product_price);
            stmt.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer_queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public static void UpdateMedicine (int product_id,String product_name,String product_type,double product_price)
    {
        try {
            
            query = "UPDATE product SET product.product_name = ?, product.product_type = ? , product.product_price = ?  WHERE product.product_id = ?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setString(1, product_name);
            stmt.setString(2, product_type);
            stmt.setDouble(3, product_price);
            stmt.setInt(4, product_id);
            stmt.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer_queries.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public static ResultSet FetchUpdateMedicineRecord (int product_id)
    {
        try {
            
            query = "SELECT product.product_name,product.product_type,product.product_price FROM product WHERE product.product_id = ?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setInt(1, product_id);
            rs = stmt.executeQuery();
            rs.next();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Customer_queries.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
