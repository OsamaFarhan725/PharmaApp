
package Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver_queries extends QUERY_BASE{
    //list of order board
    public static ResultSet FetchBoard()
    {
        try {
            query = "SELECT order_board.order_id, product.product_name, branches.branch_name , customer.name FROM order_board INNER JOIN product ON order_board.product_id = product.product_id INNER JOIN branches ON order_board.branch_id = branches.branch_id INNER JOIN customer ON order_board.customer_id = customer.customer_id";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Customer_queries.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
     
    }
    //list of active deliveries
    public static ResultSet FetchActive(int driver_id)
    {
        try {
            query = "SELECT active_order.order_id, product.product_name, branches.branch_name, customer.name  FROM active_order INNER JOIN product ON active_order.product_id = product.product_id INNER JOIN branches ON active_order.branch_id = branches.branch_id INNER JOIN customer ON active_order.customer_id = customer.customer_id WHERE active_order.driver_id = ?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setInt(1, driver_id);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Customer_queries.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
     
    }
    // list of order history
    public static ResultSet FetchHistory(int driver_id)
    {
        try {
            query = "SELECT  order_history.order_id, product.product_name, branches.branch_name , customer.name FROM order_history INNER JOIN product ON order_history.product_id = product.product_id INNER JOIN branches ON order_history.branch_id = branches.branch_id INNER JOIN customer ON order_history.customer_id = customer.customer_id WHERE order_history.driver_id = ?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setInt(1, driver_id);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Customer_queries.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
     
    }
    //accept an order from the order board
    public static void AcceptOrder(int order_id,int driver_id)
    {
        try {
            
            //add to active order
            query = "INSERT INTO `active_order` (customer_id,branch_id,product_id,driver_id) SELECT customer_id,branch_id,product_id , ? FROM `order_board` WHERE order_board.order_id = ?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setInt(1, driver_id);
            stmt.setInt(2,order_id);
            stmt.execute();   
            
            //delete taken order from board
            query = "DELETE FROM `order_board` where order_board.order_id = ?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setInt(1, order_id);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Driver_queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void FinishOrder(int order_id)
    {
     try {
            
            //add to order history
            query = "INSERT INTO `order_history` (customer_id,branch_id,product_id,driver_id) SELECT customer_id,branch_id,product_id ,driver_id FROM `active_order` WHERE active_order.order_id = ?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setInt(1,order_id);
            stmt.execute();   
            
            //delete taken order from board
            query = "DELETE FROM `active_order` where active_order.order_id = ?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setInt(1, order_id);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Driver_queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String FetchDriverName(int driver_id)
    {
        
        try {
            query = "SELECT driver.name FROM driver WHERE driver.driver_id =?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setInt(1, driver_id);
            rs = stmt.executeQuery();
            if(rs.isBeforeFirst()){
                
                rs.next();
                return  rs.getString("name");
                
            } else
                return null;
        } catch (SQLException ex) {
            Logger.getLogger(Driver_queries.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
}
