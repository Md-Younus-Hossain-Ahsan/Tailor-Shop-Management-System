package MyProject;

import JClasses.Customer;
import JClasses.Order;
import JClasses.Transactions;
import static MyProject.SignIN.cursor;
import static MyProject.SignIN.url;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public final class Customer_Info extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
                
    
    public Customer_Info() {
        
        initComponents();        
        All_View();
    }
    
    public void All_View(){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "Select * from Customer";
            PreparedStatement sst = con.prepareStatement(sql);
            
            ResultSet res = sst.executeQuery();
            CustomerInfo.setModel(new DefaultTableModel(null, new String[] {"Customer ID","Name","Gender","Mobile Number","Address"}));
            
            while(res.next())
            {
                String tbData[] = {Integer.toString(res.getInt("CustomerID")),
                                    res.getString("Name"),
                                    res.getString("Gender"),
                                    res.getString("MobileNumber"),
                                    res.getString("Address")};
                DefaultTableModel tbModel = (DefaultTableModel) CustomerInfo.getModel();
                tbModel.addRow(tbData);
            }
            Reset();
            All_Transactions_View();
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {}
        
    }
    
    
    public void All_Transactions_View(){
        
        Order order = new Order();
        Transactions transactions = new Transactions();
        
        order.total_number_of_orders("Pending");
        Pending.setText(Integer.toString(order.getTotal_Orders()));
        
        order.total_number_of_orders("Delivered");
        Delivered.setText(Integer.toString(order.getTotal_Orders()));
        
        
        transactions.all_transaction_analysis();
        Total_Paid.setText(Integer.toString(transactions.getTotal_Paid_Amount()));
        Total_Rest.setText(Integer.toString(transactions.getTotal_Rest_Amount()));
        Total_Preparing_Cost.setText(Integer.toString(transactions.getTotal_Amount())); 
        
    }
    
    
    public void All_View_through_CustomerID(int CustomerID){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "SELECT * FROM Customer WHERE CustomerID LIKE '" + CustomerID + "%'";

            PreparedStatement sst = con.prepareStatement(sql);
            
            ResultSet res = sst.executeQuery();
            CustomerInfo.setModel(new DefaultTableModel(null, new String[] {"Customer ID","Name","Gender","Mobile Number","Address"}));
            
            while(res.next())
            {
                String tbData[] = {Integer.toString(res.getInt("CustomerID")),
                                    res.getString("Name"),
                                    res.getString("Gender"),
                                    res.getString("MobileNumber"),
                                    res.getString("Address")};
                DefaultTableModel tbModel = (DefaultTableModel) CustomerInfo.getModel();
                tbModel.addRow(tbData);
            }
            
            Set_All_the_Data_through_CustomerID(CustomerID);
            All_Transactions_View_thorugh_CustomerID(CustomerID);
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {}
        
    }
    
    
    public void All_Transactions_View_thorugh_CustomerID(int CustomerID){
        
        Order order = new Order();
        Transactions transactions = new Transactions();
        
        order.total_number_of_orders_through_CustomerID(CustomerID, "Pending");
        Pending.setText(Integer.toString(order.getTotal_Orders()));
        
        order.total_number_of_orders_through_CustomerID(CustomerID, "Delivered");
        Delivered.setText(Integer.toString(order.getTotal_Orders()));
        
        transactions.all_transaction_analysis_through_CustomerID(CustomerID);
                
        Total_Paid.setText(Integer.toString(transactions.getTotal_Paid_Amount()));
        Total_Rest.setText(Integer.toString(transactions.getTotal_Rest_Amount()));
        Total_Preparing_Cost.setText(Integer.toString(transactions.getTotal_Amount())); 
        
    }
    
    
    public void All_View_through_MobileNumber(String MobileNumber){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "SELECT * FROM Customer WHERE MobileNumber LIKE '" + MobileNumber + "%'";

            PreparedStatement sst = con.prepareStatement(sql);
            
            ResultSet res = sst.executeQuery();
            CustomerInfo.setModel(new DefaultTableModel(null, new String[] {"Customer ID","Name","Gender","Mobile Number","Address"}));
            
            while(res.next())
            {
                String tbData[] = {Integer.toString(res.getInt("CustomerID")),
                                    res.getString("Name"),
                                    res.getString("Gender"),
                                    res.getString("MobileNumber"),
                                    res.getString("Address")};
                DefaultTableModel tbModel = (DefaultTableModel) CustomerInfo.getModel();
                tbModel.addRow(tbData);
            }
            
            Set_All_the_Data_through_MobileNumber(MobileNumber);
            All_Transactions_View_through_MobileNumber(MobileNumber);
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {}
        
    }
    
    
    public void All_Transactions_View_through_MobileNumber(String MobileNumber){
        
        Order order = new Order();
        Transactions transactions = new Transactions();
        
        order.total_number_of_orders_through_MobileNumber(MobileNumber, "Pending");
        Pending.setText(Integer.toString(order.getTotal_Orders()));
        
        order.total_number_of_orders_through_MobileNumber(MobileNumber, "Delivered");
        Delivered.setText(Integer.toString(order.getTotal_Orders()));
        
        transactions.all_transaction_analysis_through_MobileNumber(MobileNumber);
                
        Total_Paid.setText(Integer.toString(transactions.getTotal_Paid_Amount()));
        Total_Rest.setText(Integer.toString(transactions.getTotal_Rest_Amount()));
        Total_Preparing_Cost.setText(Integer.toString(transactions.getTotal_Amount())); 
        
    }
    
    
    public void Set_All_the_Data_through_CustomerID(int CustomerID) throws ClassNotFoundException{
        
        Customer customer = new Customer();
        
        customer.searching_all_the_information_through_CustomerID(CustomerID);
        
        CustomerName.setText(customer.getName());
        MobileNo.setText(customer.getMobileNumber());
        Mobile_Number.setText(customer.getMobileNumber());
        Gender.setSelectedItem(customer.getGender());
        Address.setText(customer.getAddress());
        
    }
    
    
    public void Set_All_the_Data_through_MobileNumber(String MobileNumber) throws ClassNotFoundException{
        
        Customer customer = new Customer();
        
        customer.searching_all_the_information_through_MobileNumber(MobileNumber);
        
        CustomerID.setText(Integer.toString(customer.getCustomerID()));
        CustomerName.setText(customer.getName());
        Mobile_Number.setText(MobileNumber);
        Gender.setSelectedItem(customer.getGender());
        Address.setText(customer.getAddress());
        
    }
    
    
    public void Reset(){
        
        CustomerID.setText(null);
        MobileNo.setText(null);
        CustomerName.setText(null);
        Mobile_Number.setText(null);
        Address.setText(null);
        Gender.setSelectedIndex(0);
        Pending.setText(null);
        Delivered.setText(null);
        Total_Preparing_Cost.setText(null);
        Total_Paid.setText(null);
        Total_Rest.setText(null);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        CustomerInfo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Gender = new javax.swing.JComboBox<>();
        Address = new javax.swing.JTextField();
        CustomerName = new javax.swing.JTextField();
        Mobile_Number = new javax.swing.JTextField();
        Back = new javax.swing.JButton();
        Details = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        CustomerID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        MobileNo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Pending = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Delivered = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        Total_Preparing_Cost = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Total_Paid = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        Total_Rest = new javax.swing.JTextField();
        All_View = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Info_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CustomerInfo.setBackground(new java.awt.Color(249, 245, 242));
        CustomerInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Customer Name", "Gender", "Mobile Number", "Address"
            }
        ));
        CustomerInfo.setToolTipText("");
        CustomerInfo.setName(""); // NOI18N
        CustomerInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerInfoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(CustomerInfo);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 640, 230));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Customer Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Contact Address");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Mobile Number");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Gender");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, -1, -1));

        Gender.setBackground(new java.awt.Color(249, 245, 242));
        Gender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select>>", "Male", "Female" }));
        getContentPane().add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 490, 310, 31));

        Address.setBackground(new java.awt.Color(249, 245, 242));
        Address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressActionPerformed(evt);
            }
        });
        getContentPane().add(Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 310, 30));

        CustomerName.setBackground(new java.awt.Color(249, 245, 242));
        CustomerName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerNameActionPerformed(evt);
            }
        });
        getContentPane().add(CustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 310, 30));

        Mobile_Number.setBackground(new java.awt.Color(249, 245, 242));
        Mobile_Number.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Mobile_Number.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Mobile_NumberKeyTyped(evt);
            }
        });
        getContentPane().add(Mobile_Number, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 310, 30));

        Back.setBackground(new java.awt.Color(249, 245, 242));
        Back.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Back.setText("Back");
        Back.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BackMouseMoved(evt);
            }
        });
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 110, 40));

        Details.setBackground(new java.awt.Color(249, 245, 242));
        Details.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Details.setText("Details");
        Details.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DetailsMouseMoved(evt);
            }
        });
        Details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetailsActionPerformed(evt);
            }
        });
        getContentPane().add(Details, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 610, 110, 40));

        Add.setBackground(new java.awt.Color(249, 245, 242));
        Add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Add.setText("Add a new");
        Add.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                AddMouseMoved(evt);
            }
        });
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        getContentPane().add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 610, 110, 40));

        Update.setBackground(new java.awt.Color(249, 245, 242));
        Update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Update.setText("Update");
        Update.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                UpdateMouseMoved(evt);
            }
        });
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        getContentPane().add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 610, 110, 40));

        CustomerID.setBackground(new java.awt.Color(249, 245, 242));
        CustomerID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CustomerID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerIDMouseClicked(evt);
            }
        });
        CustomerID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CustomerIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CustomerIDKeyTyped(evt);
            }
        });
        getContentPane().add(CustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 210, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Customer ID");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 120, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Mobile Number");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 90, 20));

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
        MobileNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MobileNoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MobileNoKeyTyped(evt);
            }
        });
        getContentPane().add(MobileNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 190, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Pending Orders");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, -1, 20));

        Pending.setEditable(false);
        Pending.setBackground(new java.awt.Color(249, 245, 242));
        Pending.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Pending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PendingActionPerformed(evt);
            }
        });
        getContentPane().add(Pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 110, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Delivered Orders");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, -1, 20));

        Delivered.setEditable(false);
        Delivered.setBackground(new java.awt.Color(249, 245, 242));
        Delivered.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Delivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeliveredActionPerformed(evt);
            }
        });
        getContentPane().add(Delivered, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, 110, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Total Order (Taka)");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 530, 120, 20));

        Total_Preparing_Cost.setEditable(false);
        Total_Preparing_Cost.setBackground(new java.awt.Color(249, 245, 242));
        Total_Preparing_Cost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Total_Preparing_Cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 550, 120, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Total Paid (Taka)");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, -1, 20));

        Total_Paid.setEditable(false);
        Total_Paid.setBackground(new java.awt.Color(249, 245, 242));
        Total_Paid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Total_Paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total_PaidActionPerformed(evt);
            }
        });
        getContentPane().add(Total_Paid, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 550, 110, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Total Rest (Taka)");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 530, -1, 20));

        Total_Rest.setEditable(false);
        Total_Rest.setBackground(new java.awt.Color(249, 245, 242));
        Total_Rest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Total_Rest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total_RestActionPerformed(evt);
            }
        });
        getContentPane().add(Total_Rest, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, 110, 30));

        All_View.setBackground(new java.awt.Color(249, 245, 242));
        All_View.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        All_View.setText("All View");
        All_View.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                All_ViewMouseMoved(evt);
            }
        });
        All_View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                All_ViewActionPerformed(evt);
            }
        });
        getContentPane().add(All_View, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 120, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo2.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 10, -1, -1));

        jLabel9.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sewing.png"))); // NOI18N
        jLabel9.setText(" Customer Information ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 80));

        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg.jpg"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CustomerInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerInfoMouseClicked
        
        int i = CustomerInfo.getSelectedRow();
        TableModel model = CustomerInfo.getModel();
        
        CustomerID.setText((String) model.getValueAt(i, 0));
        
        try {
            Set_All_the_Data_through_CustomerID(Integer.parseInt(CustomerID.getText()));
                   
        } catch (ClassNotFoundException ex) {}
        
    }//GEN-LAST:event_CustomerInfoMouseClicked
    
    
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        
        new Information().setVisible(true);
        dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        //Update in database
        if(CustomerID.getText().isEmpty() || CustomerName.getText().isEmpty() || Gender.getSelectedItem().equals("<<Select>>") || Mobile_Number.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Enter the all the Information !");
        }
        else
        {
            Customer customer = new Customer();
            
            try {                
                customer.update_the_Customer_info(Integer.parseInt(CustomerID.getText()), CustomerName.getText(), (String) Gender.getSelectedItem(), Mobile_Number.getText(), Address.getText());
                 
            } catch (ClassNotFoundException ex) {}
                        
            All_View();
        }
        
    }//GEN-LAST:event_UpdateActionPerformed

    private void AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressActionPerformed

    private void CustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerNameActionPerformed

    private void CustomerIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerIDMouseClicked
        // TODO add your handling code here:
        All_View();
        Reset();
    }//GEN-LAST:event_CustomerIDMouseClicked

    private void MobileNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MobileNoMouseClicked
        // TODO add your handling code here:
        All_View();
        Reset();
    }//GEN-LAST:event_MobileNoMouseClicked

    private void MobileNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MobileNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MobileNoActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        //Add to database
        if(CustomerName.getText().isEmpty() || Gender.getSelectedItem().equals("<<Select>>") || Mobile_Number.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Enter the all the Information !");
        }
        else
        {
            Customer customer = new Customer();
            
            try {
                customer.insert_into_Customer_list(CustomerName.getText(), (String) Gender.getSelectedItem(), Mobile_Number.getText(), Address.getText());
                
            } catch (ClassNotFoundException ex) {}
                        
            All_View();
        }
    }//GEN-LAST:event_AddActionPerformed

    private void PendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PendingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PendingActionPerformed

    private void DeliveredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeliveredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeliveredActionPerformed

    private void Total_PaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Total_PaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Total_PaidActionPerformed

    private void Total_RestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Total_RestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Total_RestActionPerformed

    private void DetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetailsActionPerformed
        
        if(CustomerID.getText().isEmpty() || CustomerName.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Select a customer !");
        }
        else{
            try {
                new Customer_Details(Integer.parseInt(CustomerID.getText())).setVisible(true);
            } catch (ClassNotFoundException ex) {}
            
            dispose();
        }
        
    }//GEN-LAST:event_DetailsActionPerformed

    private void All_ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_All_ViewActionPerformed
        All_View();
        Reset();
    }//GEN-LAST:event_All_ViewActionPerformed

    private void CustomerIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CustomerIDKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_CustomerIDKeyTyped

    private void MobileNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MobileNoKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_MobileNoKeyTyped

    private void Mobile_NumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Mobile_NumberKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_Mobile_NumberKeyTyped

    private void CustomerIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CustomerIDKeyReleased
        
        if(CustomerID.getText().trim().isEmpty())
        {
            All_View();
        }
        else
        {
            All_View_through_CustomerID(Integer.parseInt(CustomerID.getText())); 
        } 
        
    }//GEN-LAST:event_CustomerIDKeyReleased

    private void MobileNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MobileNoKeyReleased
        
        if(MobileNo.getText().trim().isEmpty())
        {
            All_View();
        }
        else
        {
            All_View_through_MobileNumber(MobileNo.getText()); 
        } 
        
    }//GEN-LAST:event_MobileNoKeyReleased

    private void All_ViewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseMoved
        All_View.setCursor(cursor);
    }//GEN-LAST:event_All_ViewMouseMoved

    private void BackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseMoved
        Back.setCursor(cursor);
    }//GEN-LAST:event_BackMouseMoved

    private void AddMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseMoved
        Add.setCursor(cursor);
    }//GEN-LAST:event_AddMouseMoved

    private void UpdateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseMoved
        Update.setCursor(cursor);
    }//GEN-LAST:event_UpdateMouseMoved

    private void DetailsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DetailsMouseMoved
        Details.setCursor(cursor);
    }//GEN-LAST:event_DetailsMouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Customer_Info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTextField Address;
    private javax.swing.JButton All_View;
    private javax.swing.JButton Back;
    private javax.swing.JTextField CustomerID;
    private javax.swing.JTable CustomerInfo;
    private javax.swing.JTextField CustomerName;
    private javax.swing.JTextField Delivered;
    private javax.swing.JButton Details;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JTextField MobileNo;
    private javax.swing.JTextField Mobile_Number;
    private javax.swing.JTextField Pending;
    private javax.swing.JTextField Total_Paid;
    private javax.swing.JTextField Total_Preparing_Cost;
    private javax.swing.JTextField Total_Rest;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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