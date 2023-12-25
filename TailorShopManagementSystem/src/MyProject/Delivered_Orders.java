package MyProject;

import JClasses.Customer;
import JClasses.DressCategory;
import JClasses.Measurements;
import JClasses.Order;
import JClasses.Transactions;
import static MyProject.SignIN.cursor;
import static MyProject.SignIN.url;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public final class Delivered_Orders extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    
    public Delivered_Orders() {
        
        initComponents();
        All_View_of_last_month();     
    }
    
    
    public void All_View_of_last_month(){
        
        LocalDate currentDate = LocalDate.now();
        LocalDate dateBeforeOneMonth = currentDate.minusMonths(1);
        
        First_Date.setDate(java.sql.Date.valueOf(dateBeforeOneMonth));
        Last_Date.setDate(java.sql.Date.valueOf(currentDate));
        
        All_View_between_two_Dates();
        
    }
    
    
    public void All_View(){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "Select * from Orders where OrderType = 'Delivered' order by OrderDate desc";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet res = pst.executeQuery();
                        
            All_Transactions_View();
                        
            DeliveredOrders.setModel(new DefaultTableModel(null, new String[] {"Order ID","Customer ID","Dress ID","Order Date","Delivery Date","Cost","Discount (%)"}));
            First_Date.setDate(null);
            Last_Date.setDate(null);
            
            while(res.next())
            {
                String tbData[] = {Integer.toString(res.getInt("OrderID")),
                                    Integer.toString(res.getInt("CustomerID")),
                                    Integer.toString(res.getInt("DressID")),                                    
                                    res.getTimestamp("OrderDate").toString(),
                                    res.getTimestamp("DeliveryDate").toString(),
                                    Integer.toString(res.getInt("Total_cost")),
                                    Float.toString(res.getFloat("Discount"))};
                
                DefaultTableModel tbModel = (DefaultTableModel) DeliveredOrders.getModel();
                tbModel.addRow(tbData);
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}
        
    }
    
    
    public void All_View_between_two_Dates(){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "SELECT * FROM Orders WHERE OrderDate BETWEEN ? AND ? AND OrderType = 'Delivered' ORDER BY OrderDate desc";

            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setDate(1, new java.sql.Date(First_Date.getDate().getTime()));
            
            Date nextDate = new Date(Last_Date.getDate().getTime() + TimeUnit.DAYS.toMillis(1));

            pst.setDate(2, new java.sql.Date(nextDate.getTime()));

            ResultSet res = pst.executeQuery();
                        
            All_Transactions_View_between_two_Dates();
                        
            DeliveredOrders.setModel(new DefaultTableModel(null, new String[] {"Order ID","Customer ID","Dress ID","Order Date","Delivery Date","Cost","Discount (%)"}));
            
            while(res.next())
            {
                String tbData[] = {Integer.toString(res.getInt("OrderID")),
                                    Integer.toString(res.getInt("CustomerID")),
                                    Integer.toString(res.getInt("DressID")),                                    
                                    res.getTimestamp("OrderDate").toString(),
                                    res.getTimestamp("DeliveryDate").toString(),
                                    Integer.toString(res.getInt("Total_cost")),
                                    Float.toString(res.getFloat("Discount"))};
                
                DefaultTableModel tbModel = (DefaultTableModel) DeliveredOrders.getModel();
                tbModel.addRow(tbData);
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}
        
    }
    
    
    public void All_View_through_OrderID(int OrderID){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "SELECT * FROM Orders WHERE OrderID LIKE ? AND OrderType = 'Delivered' ORDER BY OrderDate desc";

            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, "%" + OrderID + "%");
            
            ResultSet res = pst.executeQuery();
                        
            All_Transactions_View();
                        
            DeliveredOrders.setModel(new DefaultTableModel(null, new String[] {"Order ID","Customer ID","Dress ID","Order Date","Delivery Date","Cost","Discount (%)"}));
            First_Date.setDate(null);
            Last_Date.setDate(null);
            
            while(res.next())
            {
                String tbData[] = {Integer.toString(res.getInt("OrderID")),
                                    Integer.toString(res.getInt("CustomerID")),
                                    Integer.toString(res.getInt("DressID")),                                    
                                    res.getTimestamp("OrderDate").toString(),
                                    res.getTimestamp("DeliveryDate").toString(),
                                    Integer.toString(res.getInt("Total_cost")),
                                    Float.toString(res.getFloat("Discount"))};
                
                DefaultTableModel tbModel = (DefaultTableModel) DeliveredOrders.getModel();
                tbModel.addRow(tbData);
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}
        
    }
    
    
    public void All_View_through_CustomerID(int CustomerID){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "SELECT * FROM Orders WHERE CustomerID LIKE ? AND OrderType = 'Delivered' ORDER BY OrderDate desc";

            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, "%" + CustomerID + "%");
            
            ResultSet res = pst.executeQuery();
                       
            All_Transactions_View_thorugh_CustomerID(CustomerID);
            Set_All_the_Data_through_CustomerID(CustomerID);
                        
            DeliveredOrders.setModel(new DefaultTableModel(null, new String[] {"Order ID","Customer ID","Dress ID","Order Date","Delivery Date","Cost","Discount (%)"}));
            First_Date.setDate(null);
            Last_Date.setDate(null);
            
            while(res.next())
            {
                String tbData[] = {Integer.toString(res.getInt("OrderID")),
                                    Integer.toString(res.getInt("CustomerID")),
                                    Integer.toString(res.getInt("DressID")),                                    
                                    res.getTimestamp("OrderDate").toString(),
                                    res.getTimestamp("DeliveryDate").toString(),
                                    Integer.toString(res.getInt("Total_cost")),
                                    Float.toString(res.getFloat("Discount"))};
                
                DefaultTableModel tbModel = (DefaultTableModel) DeliveredOrders.getModel();
                tbModel.addRow(tbData);
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}
        
    }
    
    
    public void All_View_through_MobileNumber(String MobileNumber){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select * from Customer c JOIN Orders o ON c.CustomerID = o.CustomerID WHERE c.MobileNumber LIKE ? AND OrderType = 'Delivered' ORDER BY OrderDate desc";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, "%" + MobileNumber + "%");
            
            ResultSet res = pst.executeQuery();
                       
            All_Transactions_View_thorugh_MobileNumber(MobileNumber);
            Set_All_the_Data_through_MobileNumber(MobileNumber);
                        
            DeliveredOrders.setModel(new DefaultTableModel(null, new String[] {"Order ID","Customer ID","Dress ID","Order Date","Delivery Date","Cost","Discount (%)"}));
            First_Date.setDate(null);
            Last_Date.setDate(null);
            
            while(res.next())
            {
                String tbData[] = {Integer.toString(res.getInt("o.OrderID")),
                                    Integer.toString(res.getInt("o.CustomerID")),
                                    Integer.toString(res.getInt("o.DressID")),                                    
                                    res.getTimestamp("o.OrderDate").toString(),
                                    res.getTimestamp("o.DeliveryDate").toString(),
                                    Integer.toString(res.getInt("o.Total_cost")),
                                    Float.toString(res.getFloat("o.Discount"))};
                
                DefaultTableModel tbModel = (DefaultTableModel) DeliveredOrders.getModel();
                tbModel.addRow(tbData);
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}
        
    }
    
    
    public void All_Transactions_View(){
        
        Order order = new Order();
        Transactions transactions = new Transactions();
        
        order.total_number_of_orders("Delivered");
        transactions.all_transaction_analysis("Delivered");
        
        Delivered_Orders_no.setText(Integer.toString(order.getTotal_Orders()));
        Total_Preparing_Cost.setText(Integer.toString(transactions.getTotal_Amount())); 
        
    }
    
    
    public void All_Transactions_View_between_two_Dates(){
        
        Order order = new Order();
        Transactions transactions = new Transactions();
        
        Date nextDate = new Date(Last_Date.getDate().getTime() + TimeUnit.DAYS.toMillis(1));

        order.total_number_of_orders_between_two_Dates(First_Date.getDate(), nextDate, "Delivered");
        transactions.all_transaction_analysis_between_two_Dates(First_Date.getDate(), nextDate, "Delivered");
        
        Delivered_Orders_no.setText(Integer.toString(order.getTotal_Orders()));
        Total_Preparing_Cost.setText(Integer.toString(transactions.getTotal_Amount())); 
        
    }
    
    
    public void All_Transactions_View_thorugh_CustomerID(int CustomerID){
        
        Order order = new Order();
        Transactions transactions = new Transactions();
        
        order.total_number_of_orders_through_CustomerID(CustomerID, "Delivered");
        transactions.all_transaction_analysis_through_CustomerID(CustomerID, "Delivered");
        
        Delivered_Orders_no.setText(Integer.toString(order.getTotal_Orders()));
        Total_Preparing_Cost.setText(Integer.toString(transactions.getTotal_Amount())); 
        
    }
    
    
    public void Set_All_the_Data_through_CustomerID(int Customer_ID) throws ClassNotFoundException{
        
        Customer customer = new Customer();
        
        customer.searching_all_the_information_through_CustomerID(Customer_ID);
        
        CustomerID.setText(Integer.toString(Customer_ID));
        CustomerName.setText(customer.getName());
        MobileNo.setText(customer.getMobileNumber());
        Address.setText(customer.getAddress());
        
    }
    
    
    public void All_Transactions_View_thorugh_MobileNumber(String MobileNumber){
        
        Order order = new Order();
        Transactions transactions = new Transactions();
        
        order.total_number_of_orders_through_MobileNumber(MobileNumber, "Delivered");
        transactions.all_transaction_analysis_through_MobileNumber(MobileNumber, "Delivered");
        
        Delivered_Orders_no.setText(Integer.toString(order.getTotal_Orders()));
        Total_Preparing_Cost.setText(Integer.toString(transactions.getTotal_Amount())); 
        
    }
    
    
    public void Set_All_the_Data_through_MobileNumber(String MobileNumber) throws ClassNotFoundException{
        
        Customer customer = new Customer();
        
        customer.searching_all_the_information_through_MobileNumber(MobileNumber);
        
        CustomerID.setText(Integer.toString(customer.getCustomerID()));
        CustomerName.setText(customer.getName());
        Address.setText(customer.getAddress());
        
    }
    
    
    public void Set_All_the_Dress_information(int OrderID, int DressID) throws ClassNotFoundException{
        
        DressCategory dressCategory = new DressCategory();
        Measurements measurement = new Measurements();
        
        dressCategory.searching_all_the_information(DressID);
        measurement.searching_all_the_information(OrderID);
        
        DressName.setText(dressCategory.getName());
        Neck.setText(Float.toString(measurement.getNeck()));
        Chest.setText(Float.toString(measurement.getChest()));
        Height.setText(Float.toString(measurement.getHeight()));
        Wrist.setText(Float.toString(measurement.getWrist()));
        Hip.setText(Float.toString(measurement.getHip()));
        
    }
    
    
    public void Reset_all(){
        
        First_Date.setDate(null);
        Last_Date.setDate(null);
        Reset();
    }
    
    
    public void Reset(){
        
        Order_ID.setText(null);
        CustomerID.setText(null);
        MobileNo.setText(null);
        CustomerName.setText(null);
        Address.setText(null);
        DressName.setText(null);
        DeliveryDate.setText(null);
        Neck.setText(null);
        Chest.setText(null);
        Height.setText(null);
        Wrist.setText(null);
        Hip.setText(null);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        DeliveredOrders = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        Neck = new javax.swing.JTextField();
        Address = new javax.swing.JTextField();
        CustomerName = new javax.swing.JTextField();
        DressName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Hip = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Chest = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Wrist = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        All_View = new javax.swing.JButton();
        Search_using_Date = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        Last_Date = new com.toedter.calendar.JDateChooser();
        First_Date = new com.toedter.calendar.JDateChooser();
        MobileNo = new javax.swing.JTextField();
        DeliveryDate = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        Order_ID = new javax.swing.JTextField();
        CustomerID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Height = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        Delivered_Orders_no = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        Total_Preparing_Cost = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Info_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DeliveredOrders.setBackground(new java.awt.Color(249, 245, 242));
        DeliveredOrders.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        DeliveredOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Customer ID", "Dress ID", "Order Date", "Delivery Date", "Rest Amount", "Cost", "Discount (%)"
            }
        ));
        DeliveredOrders.setToolTipText("");
        DeliveredOrders.setName(""); // NOI18N
        DeliveredOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeliveredOrdersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(DeliveredOrders);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 1070, 220));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Customer Name");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, -1));

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
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 530, 110, 40));

        Neck.setEditable(false);
        Neck.setBackground(new java.awt.Color(249, 245, 242));
        Neck.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Neck, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 480, 70, 30));

        Address.setEditable(false);
        Address.setBackground(new java.awt.Color(249, 245, 242));
        Address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 380, 30));

        CustomerName.setEditable(false);
        CustomerName.setBackground(new java.awt.Color(249, 245, 242));
        CustomerName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(CustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 250, 30));

        DressName.setEditable(false);
        DressName.setBackground(new java.awt.Color(249, 245, 242));
        DressName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(DressName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 170, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Neck");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Contact Address");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Dress Name");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        Hip.setEditable(false);
        Hip.setBackground(new java.awt.Color(249, 245, 242));
        Hip.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Hip, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 480, 70, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Hip");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 460, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("inch");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 490, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("inch");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 490, -1, -1));

        Chest.setEditable(false);
        Chest.setBackground(new java.awt.Color(249, 245, 242));
        Chest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Chest, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 480, 70, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("inch");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Chest");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, -1, -1));

        Wrist.setEditable(false);
        Wrist.setBackground(new java.awt.Color(249, 245, 242));
        Wrist.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Wrist, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 480, 70, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("inch");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 490, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Wrist");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 460, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Order ID");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 80, 20));

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
        getContentPane().add(All_View, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, 30));

        Search_using_Date.setBackground(new java.awt.Color(249, 245, 242));
        Search_using_Date.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Search_using_Date.setText("Search");
        Search_using_Date.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Search_using_DateMouseMoved(evt);
            }
        });
        Search_using_Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_using_DateActionPerformed(evt);
            }
        });
        getContentPane().add(Search_using_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, -1, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Mobile Number");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 90, 90, 20));

        Last_Date.setBackground(new java.awt.Color(249, 245, 242));
        Last_Date.setDateFormatString("yyyy-MM-dd");
        Last_Date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Last_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 160, 30));

        First_Date.setBackground(new java.awt.Color(249, 245, 242));
        First_Date.setDateFormatString("yyyy-MM-dd");
        First_Date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(First_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 160, 30));

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
        getContentPane().add(MobileNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 110, 160, 30));

        DeliveryDate.setEditable(false);
        DeliveryDate.setBackground(new java.awt.Color(249, 245, 242));
        DeliveryDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(DeliveryDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 410, 210, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Delivery Date");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 390, -1, -1));

        Order_ID.setBackground(new java.awt.Color(249, 245, 242));
        Order_ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Order_ID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Order_IDMouseClicked(evt);
            }
        });
        Order_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Order_IDActionPerformed(evt);
            }
        });
        Order_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Order_IDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Order_IDKeyTyped(evt);
            }
        });
        getContentPane().add(Order_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 130, 30));

        CustomerID.setBackground(new java.awt.Color(249, 245, 242));
        CustomerID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CustomerID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerIDMouseClicked(evt);
            }
        });
        CustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerIDActionPerformed(evt);
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
        getContentPane().add(CustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 120, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Customer ID");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 90, 20));

        Height.setEditable(false);
        Height.setBackground(new java.awt.Color(249, 245, 242));
        Height.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Height, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 480, 70, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("inch");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 490, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Height");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 460, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Last Date : ");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 70, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("First Date : ");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 70, 30));

        Delivered_Orders_no.setEditable(false);
        Delivered_Orders_no.setBackground(new java.awt.Color(249, 245, 242));
        Delivered_Orders_no.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Delivered_Orders_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delivered_Orders_noActionPerformed(evt);
            }
        });
        getContentPane().add(Delivered_Orders_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 180, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Total Delivered Orders");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, 20));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Total Preparing Cost");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 140, 20));

        Total_Preparing_Cost.setEditable(false);
        Total_Preparing_Cost.setBackground(new java.awt.Color(249, 245, 242));
        Total_Preparing_Cost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Total_Preparing_Cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, 180, 30));

        jLabel28.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sewing.png"))); // NOI18N
        jLabel28.setText(" Delivered Order List ");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 80));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo2.png"))); // NOI18N
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1035, 10, -1, -1));

        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg.jpg"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeliveredOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeliveredOrdersMouseClicked
        
        int i = DeliveredOrders.getSelectedRow();
        TableModel model = DeliveredOrders.getModel();
        
        Order_ID.setText((String) model.getValueAt(i, 0));
        Integer.valueOf((String) model.getValueAt(i, 0));
        CustomerID.setText((String) model.getValueAt(i, 1));
        DeliveryDate.setText((String) model.getValueAt(i, 4));
        
        try {
            Set_All_the_Data_through_CustomerID(Integer.parseInt((String) model.getValueAt(i, 1)));
            Set_All_the_Dress_information(Integer.parseInt((String) model.getValueAt(i, 0)), Integer.parseInt((String) model.getValueAt(i, 2)));
        } catch (ClassNotFoundException ex) {}
        
    }//GEN-LAST:event_DeliveredOrdersMouseClicked
    
    
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        new Pending_Orders().setVisible(true);
        dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void MobileNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MobileNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MobileNoActionPerformed

    private void CustomerIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerIDMouseClicked
        All_View();
        Reset_all();
    }//GEN-LAST:event_CustomerIDMouseClicked

    private void MobileNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MobileNoMouseClicked
        All_View();
        Reset_all();
    }//GEN-LAST:event_MobileNoMouseClicked

    private void CustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerIDActionPerformed

    private void Search_using_DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_using_DateActionPerformed
        
        if (First_Date.getDate() != null && Last_Date.getDate() != null) {
            
            try {
                Date firstDate = First_Date.getDate();
                Date lastDate = Last_Date.getDate();
                Reset();
                if (firstDate.before(lastDate) || firstDate.equals(lastDate)) 
                {                    
                    All_View_between_two_Dates();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid date range: First date should be before or equal to the last date.");
                    First_Date.setDate(null);
                    Last_Date.setDate(null);
                }

            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Error !!!");
            }
        }
        else 
            JOptionPane.showMessageDialog(null, "Error !!!");

    }//GEN-LAST:event_Search_using_DateActionPerformed

    private void All_ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_All_ViewActionPerformed
        All_View();
        Reset_all();
    }//GEN-LAST:event_All_ViewActionPerformed

    private void Order_IDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Order_IDMouseClicked
        All_View();
        Reset_all();
    }//GEN-LAST:event_Order_IDMouseClicked

    private void Order_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Order_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Order_IDActionPerformed

    private void Delivered_Orders_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delivered_Orders_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Delivered_Orders_noActionPerformed

    private void Order_IDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Order_IDKeyReleased
        
        if(!Order_ID.getText().trim().isEmpty())
            All_View_through_OrderID(Integer.parseInt(Order_ID.getText()));
        else
        {
            All_View(); 
            Reset_all();
        }
        
    }//GEN-LAST:event_Order_IDKeyReleased

    private void Order_IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Order_IDKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_Order_IDKeyTyped

    private void CustomerIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CustomerIDKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_CustomerIDKeyTyped

    private void MobileNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MobileNoKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_MobileNoKeyTyped

    private void CustomerIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CustomerIDKeyReleased
        
        if(!CustomerID.getText().trim().isEmpty())
            All_View_through_CustomerID(Integer.parseInt(CustomerID.getText()));
        else
        {
            All_View(); 
            Reset_all();
        }
        
    }//GEN-LAST:event_CustomerIDKeyReleased

    private void MobileNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MobileNoKeyReleased
        
        if(!MobileNo.getText().trim().isEmpty())
            All_View_through_MobileNumber(MobileNo.getText());
        else
        {
            All_View(); 
            Reset_all();
        }
        
    }//GEN-LAST:event_MobileNoKeyReleased

    private void All_ViewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseMoved
        All_View.setCursor(cursor);

    }//GEN-LAST:event_All_ViewMouseMoved

    private void Search_using_DateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search_using_DateMouseMoved
        Search_using_Date.setCursor(cursor);
    }//GEN-LAST:event_Search_using_DateMouseMoved

    private void BackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseMoved
        Back.setCursor(cursor);
    }//GEN-LAST:event_BackMouseMoved

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {}
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Delivered_Orders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address;
    private javax.swing.JButton All_View;
    private javax.swing.JButton Back;
    private javax.swing.JTextField Chest;
    private javax.swing.JTextField CustomerID;
    private javax.swing.JTextField CustomerName;
    private javax.swing.JTable DeliveredOrders;
    private javax.swing.JTextField Delivered_Orders_no;
    private javax.swing.JTextField DeliveryDate;
    private javax.swing.JTextField DressName;
    private com.toedter.calendar.JDateChooser First_Date;
    private javax.swing.JTextField Height;
    private javax.swing.JTextField Hip;
    private javax.swing.JLabel Info_Icon;
    private com.toedter.calendar.JDateChooser Last_Date;
    private javax.swing.JTextField MobileNo;
    private javax.swing.JTextField Neck;
    private javax.swing.JTextField Order_ID;
    private javax.swing.JButton Search_using_Date;
    private javax.swing.JTextField Total_Preparing_Cost;
    private javax.swing.JTextField Wrist;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
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