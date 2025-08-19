
package Main;

import CustomerGUI.Customer_active_menu;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Table_Handler {
    
    private static DefaultTableModel dtm;
    
    public static void addToTable(TableModel tm,ResultSet rs)
    {
     dtm = (DefaultTableModel)tm;
        try {
                while(rs.next())
                    
                dtm.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)});
            } catch (SQLException ex) {
                Logger.getLogger(Customer_active_menu.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void clearTable(TableModel tm)
    {
    dtm = (DefaultTableModel) tm;
    if(dtm.getRowCount() == 1)
    {
         dtm.removeRow(0);
    }else
    {
         dtm.getDataVector().removeAllElements();
    }
    }
}

