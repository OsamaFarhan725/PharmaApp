
package CustomerGUI;
import Database.Customer_queries;
import javax.swing.JOptionPane;
import Main.PharmaGO;
import Main.Table_Handler;

public class Customer_med_menu extends javax.swing.JFrame {

   
    public Customer_med_menu() {
        initComponents();
        Table_Handler.clearTable(med_table.getModel());
        Table_Handler.addToTable(med_table.getModel(), Customer_queries.FetchMedicine(PharmaGO.branch_id));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        med_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(550, 240));

        med_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Drug", "Description", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        med_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                med_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(med_table);
        if (med_table.getColumnModel().getColumnCount() > 0) {
            med_table.getColumnModel().getColumn(0).setResizable(false);
            med_table.getColumnModel().getColumn(1).setResizable(false);
            med_table.getColumnModel().getColumn(2).setResizable(false);
            med_table.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void med_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_med_tableMouseClicked
        int product_id = Integer.parseInt(med_table.getValueAt(med_table.getSelectedRow(),0).toString());
        
        Customer_queries.PlaceOrder(PharmaGO.user_id, PharmaGO.branch_id,product_id );
    }//GEN-LAST:event_med_tableMouseClicked

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_med_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable med_table;
    // End of variables declaration//GEN-END:variables
}
