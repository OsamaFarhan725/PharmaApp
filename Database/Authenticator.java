
package Database;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Authenticator extends QUERY_BASE {
    public static int authenticateCustomer (int phone_number) 
    {
        
        
        try {
            //set query
            query = "SELECT customer_id FROM customer WHERE customer.phone_number = ?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
           //add values to query and execute
            stmt.setInt(1, phone_number);
            rs = stmt.executeQuery();
            
            //check if ResultSet is empty, if not then return the customer_id
            //NOTE: there should only be one record if there is a match with phone numbers
            if(rs.isBeforeFirst()){
                
            rs.next();
            return  rs.getInt("customer_id");
            
            } else
                return 0;
        } catch (SQLException ex) {
            Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
            return 0; 
        }
        
    
    }
    public static int authenticateDriver(int phone_number)
    {
      try {
            //set query
            query = "SELECT driver_id FROM driver WHERE driver.phone_number = ?";
            stmt = Database_connection.connectToDB().prepareStatement(query);
           //add values to query and execute
            stmt.setInt(1, phone_number);
            rs = stmt.executeQuery();
            
            //check if ResultSet is empty, if not then return the customer_id
            //NOTE: there should only be one record if there is a match with phone numbers
            if(rs.isBeforeFirst()){
                
            rs.next();
            return  rs.getInt("driver_id");
            
            } else
                return 0;
        } catch (SQLException ex) {
            Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
            return 0; 
        }
                    
              
    }
    public static int authenticateManager(String username,String password)
    {
    
        
        try {
            //set query
            query = "SELECT `branches`.`branch_id` FROM branches WHERE `branches`.`man_id` = (SELECT `branch_manager`.`man_id` FROM `branch_manager` WHERE `branch_manager`.`username` = ? AND `branch_manager`.`password` = ?)";
            stmt = Database_connection.connectToDB().prepareStatement(query);
           //add values to query and execute
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            
            //check if ResultSet is empty, if not then return the customer_id
            //NOTE: there should only be one record if there is a match with phone numbers
            if(rs.isBeforeFirst()){
                
            rs.next();
            return  rs.getInt("branch_id");
            
            } else
                return 0;
        } catch (SQLException ex) {
            Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
            return 0; 
        } 
        
    }

}
