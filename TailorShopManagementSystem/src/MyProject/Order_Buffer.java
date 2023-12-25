package MyProject;

import JClasses.Customer;
import JClasses.Order;
import JClasses.Transactions;
import static MyProject.SignIN.cursor;
import static MyProject.SignIN.url;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public final class Order_Buffer extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    int CustomerID;
    String OrderType = "Temp";
    int OrderID;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    
    public Order_Buffer() {
        
        initComponents();
        OrderID =0;
    }
    
    
    public Order_Buffer(int CustomerID) throws ClassNotFoundException {
        
        initComponents();      
        OrderID =0;
        this.CustomerID = CustomerID;
        Customer_ID.setText(Integer.toString(CustomerID));
        
        Customer customer = new Customer();
        customer.searching_all_the_information_through_CustomerID(CustomerID);
        
        CustomerName.setText(customer.getName());
        Gender.setText(customer.getGender());
        MobileNo.setText(customer.getMobileNumber());
        Address.setText(customer.getAddress());
        All_View();     
    }

    
    public void All_View(){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql1 = "Select Orders.OrderID, Orders.DressID, Orders.DeliveryDate, Orders.Rest_amount, Orders.Total_cost, Orders.Discount, Dress_Category.Name from Orders inner join Dress_Category on Orders.DressID = Dress_Category.DressID where CustomerID = '"+ CustomerID +"' and OrderType = 'Temp' order by OrderID asc";
            String sql2 = "SELECT (SELECT COUNT(OrderID) FROM Orders WHERE CustomerID = '" + CustomerID + "' AND OrderType = '" + OrderType + "') AS Temp_Orders, (SELECT SUM(Total_cost) FROM Orders WHERE CustomerID = '" + CustomerID + "' AND OrderType = '" + OrderType + "') AS Total_Amount, (SELECT SUM(Rest_amount) FROM Orders WHERE CustomerID = '" + CustomerID + "' AND OrderType = '" + OrderType + "') AS Total_Rest_Amount";

            PreparedStatement pst = con.prepareStatement(sql1);
            PreparedStatement sst = con.prepareStatement(sql2);
            
            ResultSet res = pst.executeQuery();            
            ResultSet ress = sst.executeQuery();
            
            CurrentOrders.setModel(new DefaultTableModel(null, new String[] {"Order ID","Dress ID","Dress Name","Delivery Date","Rest Amount","Cost","Discount (%)"}));
            while(res.next())
            {
                String tbData[] = {Integer.toString(res.getInt("OrderID")),
                                    Integer.toString(res.getInt("DressID")), 
                                    res.getString("Name"),
                                    res.getString("DeliveryDate"),
                                    Integer.toString(res.getInt("Rest_amount")),
                                    Integer.toString(res.getInt("Total_cost")),
                                    Integer.toString(res.getInt("Discount"))};
                DefaultTableModel tbModel = (DefaultTableModel) CurrentOrders.getModel();
                tbModel.addRow(tbData);
            }
            
            while(ress.next())
            {
                Total_Orders.setText(Integer.toString(ress.getInt("Temp_Orders")));
                Total_Cost.setText(Integer.toString(ress.getInt("Total_Amount")));
                Rest_Amount.setText(Integer.toString(ress.getInt("Total_Rest_Amount")));
            }
            
            Payment_Amount.setText(Integer.toString(Integer.parseInt(Total_Cost.getText()) - Integer.parseInt(Rest_Amount.getText())));
                        
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {}
    }
    
    
    public void Add_into_the_transaction_list() throws ParseException{
        
        try{
            Transactions transaction = new Transactions();
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "Select * from Orders";
            
            PreparedStatement sst = con.prepareStatement(sql);
            
            ResultSet res = sst.executeQuery();
            
            while(res.next())
            {
                transaction.insert_into_Transaction_list(res.getInt("OrderID"), res.getInt("Total_cost")-res.getInt("Rest_amount"));
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {}
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        CurrentOrders = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        Total_Cost = new javax.swing.JTextField();
        Edit = new javax.swing.JButton();
        Add_More = new javax.swing.JButton();
        Gender = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Address = new javax.swing.JTextField();
        CustomerName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Confirm = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        MobileNo = new javax.swing.JTextField();
        Customer_ID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Payment_Amount = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        Rest_Amount = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        Total_Orders = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        Info_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CurrentOrders.setBackground(new java.awt.Color(249, 245, 242));
        CurrentOrders.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        CurrentOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Dress ID", "Dress Name", "Delivery Date", "Rest Amount", "Cost", "Discount (%)"
            }
        ));
        CurrentOrders.setToolTipText("");
        CurrentOrders.setName(""); // NOI18N
        CurrentOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CurrentOrdersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CurrentOrdersMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(CurrentOrders);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 910, 220));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Customer Name");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        Total_Cost.setEditable(false);
        Total_Cost.setBackground(new java.awt.Color(249, 245, 242));
        Total_Cost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Total_Cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, 190, 30));

        Edit.setBackground(new java.awt.Color(249, 245, 242));
        Edit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Edit.setText("Edit");
        Edit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                EditMouseMoved(evt);
            }
        });
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });
        getContentPane().add(Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 110, 40));

        Add_More.setBackground(new java.awt.Color(249, 245, 242));
        Add_More.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Add_More.setText("Add More");
        Add_More.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Add_MoreMouseMoved(evt);
            }
        });
        Add_More.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_MoreActionPerformed(evt);
            }
        });
        getContentPane().add(Add_More, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 110, 40));

        Gender.setEditable(false);
        Gender.setBackground(new java.awt.Color(249, 245, 242));
        Gender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 100, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Gender");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        Address.setEditable(false);
        Address.setBackground(new java.awt.Color(249, 245, 242));
        Address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 240, 30));

        CustomerName.setEditable(false);
        CustomerName.setBackground(new java.awt.Color(249, 245, 242));
        CustomerName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(CustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 200, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Total Cost (Taka)");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, 130, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Contact Address");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, -1, -1));

        Confirm.setBackground(new java.awt.Color(249, 245, 242));
        Confirm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Confirm.setText("Confirm");
        Confirm.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ConfirmMouseMoved(evt);
            }
        });
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });
        getContentPane().add(Confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 500, 110, 40));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Mobile Number");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 90, 20));

        MobileNo.setEditable(false);
        MobileNo.setBackground(new java.awt.Color(249, 245, 242));
        MobileNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MobileNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MobileNoMouseClicked(evt);
            }
        });
        MobileNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MobileNoActionPerformed(evt);
            }
        });
        getContentPane().add(MobileNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 170, 30));

        Customer_ID.setEditable(false);
        Customer_ID.setBackground(new java.awt.Color(249, 245, 242));
        Customer_ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Customer_ID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Customer_IDMouseClicked(evt);
            }
        });
        Customer_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Customer_IDActionPerformed(evt);
            }
        });
        getContentPane().add(Customer_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Customer ID");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Payment Amount (Taka)");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 180, -1));

        Payment_Amount.setEditable(false);
        Payment_Amount.setBackground(new java.awt.Color(249, 245, 242));
        Payment_Amount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Payment_Amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 190, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Rest Amount (Taka)");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 130, -1));

        Rest_Amount.setEditable(false);
        Rest_Amount.setBackground(new java.awt.Color(249, 245, 242));
        Rest_Amount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Rest_Amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 190, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Total Orders");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 130, -1));

        Total_Orders.setEditable(false);
        Total_Orders.setBackground(new java.awt.Color(249, 245, 242));
        Total_Orders.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Total_Orders, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 160, 30));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo2.png"))); // NOI18N
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 10, -1, -1));

        jLabel28.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sewing.png"))); // NOI18N
        jLabel28.setText(" Current Order List ");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 80));

        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg.jpg"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CurrentOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CurrentOrdersMouseClicked
        
        int i = CurrentOrders.getSelectedRow();
        TableModel model = CurrentOrders.getModel();
        
        OrderID = Integer.parseInt((String) model.getValueAt(i, 0));
        
    }//GEN-LAST:event_CurrentOrdersMouseClicked
    
    
    private void Add_MoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_MoreActionPerformed
        
        try {
            new Add_more_Orders(Integer.parseInt(Customer_ID.getText())).setVisible(true);
        } catch (ClassNotFoundException ex) {}
        dispose();
        
    }//GEN-LAST:event_Add_MoreActionPerformed

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
        
        int result = JOptionPane.showConfirmDialog(this,"Have you received the advance of the cost ?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                
        if(result == JOptionPane.YES_OPTION)
        {            
            try{
                Order order = new Order();
                Add_into_the_transaction_list();
                order.confirm_all_the_temporary_orders(Integer.parseInt(Customer_ID.getText()));

                JOptionPane.showMessageDialog(null, "The orders have been added !");

                dispose();

            }catch(ClassNotFoundException | ParseException ex) {}

            All_View();              
        }
        
    }//GEN-LAST:event_ConfirmActionPerformed

    private void MobileNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MobileNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MobileNoActionPerformed

    private void MobileNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MobileNoMouseClicked
        
    }//GEN-LAST:event_MobileNoMouseClicked

    private void Customer_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Customer_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Customer_IDActionPerformed

    private void Customer_IDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Customer_IDMouseClicked
        
    }//GEN-LAST:event_Customer_IDMouseClicked

    private void CurrentOrdersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CurrentOrdersMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_CurrentOrdersMouseEntered

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        
        if(OrderID != 0)
        {            
            try {
                new Edit_an_Order(Integer.parseInt(Customer_ID.getText()), OrderID).setVisible(true);
            } catch (ClassNotFoundException ex) {}
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Select an order !"); 
        }
        
    }//GEN-LAST:event_EditActionPerformed

    private void EditMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMouseMoved
        Edit.setCursor(cursor);

    }//GEN-LAST:event_EditMouseMoved

    private void Add_MoreMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_MoreMouseMoved
        Add_More.setCursor(cursor);
    }//GEN-LAST:event_Add_MoreMouseMoved

    private void ConfirmMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmMouseMoved
        Confirm.setCursor(cursor);
    }//GEN-LAST:event_ConfirmMouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order_Buffer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Order_Buffer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_More;
    private javax.swing.JTextField Address;
    private javax.swing.JButton Confirm;
    private javax.swing.JTable CurrentOrders;
    private javax.swing.JTextField CustomerName;
    private javax.swing.JTextField Customer_ID;
    private javax.swing.JButton Edit;
    private javax.swing.JTextField Gender;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JTextField MobileNo;
    private javax.swing.JTextField Payment_Amount;
    private javax.swing.JTextField Rest_Amount;
    private javax.swing.JTextField Total_Cost;
    private javax.swing.JTextField Total_Orders;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private String getString(String fromInput) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void TicketGenerate(String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getText(String format) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}