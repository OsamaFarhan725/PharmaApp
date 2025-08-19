
package Database;
 import java.sql.*;



//Base class. FOR INHERITANCE ONLY
public class QUERY_BASE {
    
   protected static String query;
   protected static PreparedStatement stmt;
   protected static ResultSet rs;

   
   
   //You shouldn't be using SET and GET
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public PreparedStatement getStmt() {
        return stmt;
    }

    public void setStmt(PreparedStatement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
   
   
   
    
}
