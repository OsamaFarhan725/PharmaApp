
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database_connection {
    public static Connection connectToDB()
    {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmago", "root","");
            System.out.println("yay");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    
    }
}
