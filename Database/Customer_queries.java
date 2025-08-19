
package Database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer_queries extends QUERY_BASE {
    // list of pharmacies
    public static ResultSet FetchBranches()
    {
        try {
            query = "SELECT branches.branch_id, branches.branch_name, branches.branch_address, branches.phone_number FROM branches";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Customer_queries.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    // list of medicine in a pharmacy
    public static ResultSet FetchMedicine(int branch_id)
    {
        try {
            query = "SELECT product.product_id, product.product_name, product.product_type, product.product_price FROM product WHERE product.branch_id =  ?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setInt(1, branch_id);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Customer_queries.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
     
    }
    // list of active orders
    public static ResultSet FetchActive(int customer_id){
        try {
            query = "SELECT active_order.order_id, product.product_name, branches.branch_name, driver.name FROM active_order INNER JOIN product ON active_order.product_id = product.product_id INNER JOIN branches ON active_order.branch_id = branches.branch_id INNER JOIN driver ON active_order.driver_id = driver.driver_id WHERE active_order.customer_id = ?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setInt(1, customer_id);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
           Logger.getLogger(Customer_queries.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }
    }
    // list of order history
    public static ResultSet FetchHistory(int customer_id)
    {
        try {
            query = "SELECT  order_history.order_id, product.product_name, branches.branch_name , driver.name FROM order_history INNER JOIN product ON order_history.product_id = product.product_id INNER JOIN branches ON order_history.branch_id = branches.branch_id INNER JOIN driver ON order_history.customer_id = driver.driver_id WHERE order_history.customer_id = ?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setInt(1, customer_id);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Customer_queries.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static void PlaceOrder(int customer_id,int branch_id, int product_id)
    {
        try {
            query = "INSERT INTO `order_board` (order_id,customer_id,branch_id,product_id) VALUES (NULL,?,?,?)";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setInt(1, customer_id);
            stmt.setInt(2, branch_id);
            stmt.setInt(3, product_id);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Customer_queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String FetchCustomerName(int customer_id)
    {
        
        try {
            query = "SELECT customer.name FROM customer WHERE customer.customer_id =?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
            stmt.setInt(1, customer_id);
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
