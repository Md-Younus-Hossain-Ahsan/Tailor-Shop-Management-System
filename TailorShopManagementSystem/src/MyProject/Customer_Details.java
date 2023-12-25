package MyProject;

import JClasses.Customer;
import JClasses.Order;
import JClasses.Transactions;
import static MyProject.SignIN.cursor;
import static MyProject.SignIN.url;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public final class Customer_Details extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

        
    public Customer_Details(){
        
        initComponents();
    }
    
    public Customer_Details(int CustomerID) throws ClassNotFoundException{
        
        initComponents();
        this.CustomerID.setText(Integer.toString(CustomerID));
        
        All_View();
        Set_All_the_Data_through_CustomerID(CustomerID);
        All_Transactions_View_thorugh_CustomerID(CustomerID);
        
    }
    
    
    public void All_View(){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql1 = "Select * from Orders where CustomerID = '"+ Integer.valueOf(CustomerID.getText()) +"' and OrderType = 'Pending' order by OrderDate asc";
            String sql2 = "Select * from Orders where CustomerID = '"+ Integer.valueOf(CustomerID.getText()) +"' and OrderType = 'Delivered' order by OrderDate desc";
            
            PreparedStatement pst1 = con.prepareStatement(sql1);
            PreparedStatement pst2 = con.prepareStatement(sql2);
            
            ResultSet res = pst1.executeQuery();
            ResultSet ress = pst2.executeQuery();
                        
            First_Date.setCalendar(null);
            Last_Date.setCalendar(null);
            
            PendingOrders.setModel(new DefaultTableModel(null, new String[] {"Order ID","Customer ID","Dress ID","Order Date","Delivery Date","Rest Amount","Cost","Discount (%)"}));
            DeliveredOrders.setModel(new DefaultTableModel(null, new String[] {"Order ID","Customer ID","Dress ID","Order Date","Delivery Date","Preparing Cost","Discount (%)"}));
            
            while(res.next())
            {
                String tbData[] = {Integer.toString(res.getInt("OrderID")),
                                    Integer.toString(res.getInt("CustomerID")),
                                    Integer.toString(res.getInt("DressID")),                                    
                                    res.getTimestamp("OrderDate").toString(),
                                    res.getTimestamp("DeliveryDate").toString(),
                                    Integer.toString(res.getInt("Rest_amount")),
                                    Integer.toString(res.getInt("Total_cost")),
                                    Float.toString(res.getFloat("Discount"))};
                
                DefaultTableModel tbModel = (DefaultTableModel) PendingOrders.getModel();
                tbModel.addRow(tbData);
            }
            
            while(ress.next())
            {
                String tbData[] = {Integer.toString(ress.getInt("OrderID")),
                                    Integer.toString(ress.getInt("CustomerID")),
                                    Integer.toString(ress.getInt("DressID")),                                    
                                    ress.getTimestamp("OrderDate").toString(),
                                    ress.getTimestamp("DeliveryDate").toString(),
                                    Integer.toString(ress.getInt("Total_cost")),
                                    Float.toString(ress.getFloat("Discount"))};
                
                DefaultTableModel tbModel = (DefaultTableModel) DeliveredOrders.getModel();
                tbModel.addRow(tbData);
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}
        
    }
    
    
    public void Set_All_the_Data_through_CustomerID(int CustomerID) throws ClassNotFoundException{
        
        Customer customer = new Customer();
        
        customer.searching_all_the_information_through_CustomerID(CustomerID);
        
        CustomerName.setText(customer.getName());
        MobileNo.setText(customer.getMobileNumber());
        Gender.setText(customer.getGender());
        Address.setText(customer.getAddress());
        
    }
    
    
    public void All_Transactions_View_thorugh_CustomerID(int CustomerID){
        
        Order order = new Order();
        Transactions transactions = new Transactions();
        
        order.total_number_of_orders_through_CustomerID(CustomerID);
        Total_Orders.setText(Integer.toString(order.getTotal_Orders()));
        
        order.total_number_of_orders_through_CustomerID(CustomerID, "Pending");
        Pending.setText(Integer.toString(order.getTotal_Orders()));
        
        order.total_number_of_orders_through_CustomerID(CustomerID, "Delivered");
        Delivered.setText(Integer.toString(order.getTotal_Orders()));
        
        transactions.all_transaction_analysis_through_CustomerID(CustomerID);
                
        Total_Paid.setText(Integer.toString(transactions.getTotal_Paid_Amount()));
        Total_Rest.setText(Integer.toString(transactions.getTotal_Rest_Amount()));
        Total_Preparing_Cost.setText(Integer.toString(transactions.getTotal_Amount())); 
        
    }
    
        
    public void All_View_between_two_Dates(){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql1 = "SELECT * FROM Orders WHERE OrderDate BETWEEN ? AND ? AND OrderType = 'Pending' ORDER BY OrderDate ASC";
            String sql2 = "SELECT * FROM Orders WHERE OrderDate BETWEEN ? AND ? AND OrderType = 'Delivered' ORDER BY OrderDate DESC";

            PreparedStatement pst1 = con.prepareStatement(sql1);
            PreparedStatement pst2 = con.prepareStatement(sql2);
            
            pst1.setDate(1, new java.sql.Date(First_Date.getDate().getTime()));
            Date nextDate1 = new Date(Last_Date.getDate().getTime() + TimeUnit.DAYS.toMillis(1));
            pst1.setDate(2, new java.sql.Date(nextDate1.getTime()));

            pst2.setDate(1, new java.sql.Date(First_Date.getDate().getTime()));
            Date nextDate2 = new Date(Last_Date.getDate().getTime() + TimeUnit.DAYS.toMillis(1));
            pst2.setDate(2, new java.sql.Date(nextDate2.getTime()));

            ResultSet res = pst1.executeQuery();
            ResultSet ress = pst2.executeQuery();
                        
            All_Transactions_View_between_two_Dates(Integer.parseInt(CustomerID.getText()));
            
            PendingOrders.setModel(new DefaultTableModel(null, new String[] {"Order ID","Customer ID","Dress ID","Order Date","Delivery Date","Rest Amount","Cost","Discount (%)"}));
            DeliveredOrders.setModel(new DefaultTableModel(null, new String[] {"Order ID","Customer ID","Dress ID","Order Date","Delivery Date","Preparing Cost","Discount (%)"}));
            
            while(res.next())
            {
                String tbData[] = {Integer.toString(res.getInt("OrderID")),
                                    Integer.toString(res.getInt("CustomerID")),
                                    Integer.toString(res.getInt("DressID")),                                    
                                    res.getTimestamp("OrderDate").toString(),
                                    res.getTimestamp("DeliveryDate").toString(),
                                    Integer.toString(res.getInt("Rest_amount")),
                                    Integer.toString(res.getInt("Total_cost")),
                                    Float.toString(res.getFloat("Discount"))};
                
                DefaultTableModel tbModel = (DefaultTableModel) PendingOrders.getModel();
                tbModel.addRow(tbData);
            }
            
            while(ress.next())
            {
                String tbData[] = {Integer.toString(ress.getInt("OrderID")),
                                    Integer.toString(ress.getInt("CustomerID")),
                                    Integer.toString(ress.getInt("DressID")),                                    
                                    ress.getTimestamp("OrderDate").toString(),
                                    ress.getTimestamp("DeliveryDate").toString(),
                                    Integer.toString(ress.getInt("Total_cost")),
                                    Float.toString(ress.getFloat("Discount"))};
                
                DefaultTableModel tbModel = (DefaultTableModel) DeliveredOrders.getModel();
                tbModel.addRow(tbData);
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}
        
    }
    
    
    public void All_Transactions_View_between_two_Dates(int CustomerID){
        
        Order order = new Order();
        Transactions transactions = new Transactions();
        
        Date nextDate = new Date(Last_Date.getDate().getTime() + TimeUnit.DAYS.toMillis(1));

        order.total_number_of_orders_between_two_Dates(CustomerID, First_Date.getDate(), nextDate);
        Total_Orders.setText(Integer.toString(order.getTotal_Orders()));
        
        order.total_number_of_orders_between_two_Dates(CustomerID, First_Date.getDate(), nextDate, "Pending");
        Pending.setText(Integer.toString(order.getTotal_Orders()));
        
        order.total_number_of_orders_between_two_Dates(CustomerID, First_Date.getDate(), nextDate, "Delivered");
        Delivered.setText(Integer.toString(order.getTotal_Orders()));
        
        transactions.all_transaction_analysis_between_two_Dates(CustomerID, First_Date.getDate(), nextDate);
               
        Total_Paid.setText(Integer.toString(transactions.getTotal_Paid_Amount()));
        Total_Rest.setText(Integer.toString(transactions.getTotal_Rest_Amount()));
        Total_Preparing_Cost.setText(Integer.toString(transactions.getTotal_Amount())); 
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        CustomerID = new javax.swing.JTextField();
        Back = new javax.swing.JButton();
        All_View = new javax.swing.JButton();
        Search = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        First_Date = new com.toedter.calendar.JDateChooser();
        Last_Date = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        Total_Orders = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        CustomerName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Gender = new javax.swing.JTextField();
        Address = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        MobileNo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Pending = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Delivered = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Total_Paid = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        Total_Rest = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        Total_Preparing_Cost = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        DeliveredOrders = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        PendingOrders = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        RootSelectionIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Customer ID");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 110, -1));

        CustomerID.setEditable(false);
        CustomerID.setBackground(new java.awt.Color(249, 245, 242));
        CustomerID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerIDActionPerformed(evt);
            }
        });
        getContentPane().add(CustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 110, 30));

        Back.setBackground(new java.awt.Color(249, 245, 242));
        Back.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 680, 110, 40));

        All_View.setBackground(new java.awt.Color(249, 245, 242));
        All_View.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        getContentPane().add(All_View, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 110, 30));

        Search.setBackground(new java.awt.Color(249, 245, 242));
        Search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Search.setText("Search");
        Search.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                SearchMouseMoved(evt);
            }
        });
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        getContentPane().add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, 110, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("From (1st date)");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 90, 20));

        First_Date.setBackground(new java.awt.Color(249, 245, 242));
        First_Date.setDateFormatString("yyyy-MM-dd");
        First_Date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        First_Date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                First_DateMouseClicked(evt);
            }
        });
        getContentPane().add(First_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 210, 30));

        Last_Date.setBackground(new java.awt.Color(249, 245, 242));
        Last_Date.setDateFormatString("yyyy-MM-dd");
        Last_Date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Last_Date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Last_DateMouseClicked(evt);
            }
        });
        getContentPane().add(Last_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 210, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Customer Name");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, -1, -1));

        Total_Orders.setEditable(false);
        Total_Orders.setBackground(new java.awt.Color(249, 245, 242));
        Total_Orders.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Total_Orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total_OrdersActionPerformed(evt);
            }
        });
        getContentPane().add(Total_Orders, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 100, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Total Orders");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, 20));

        CustomerName.setEditable(false);
        CustomerName.setBackground(new java.awt.Color(249, 245, 242));
        CustomerName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerNameActionPerformed(evt);
            }
        });
        getContentPane().add(CustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 180, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Contact Address");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, -1, -1));

        Gender.setEditable(false);
        Gender.setBackground(new java.awt.Color(249, 245, 242));
        Gender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderActionPerformed(evt);
            }
        });
        getContentPane().add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 90, 30));

        Address.setEditable(false);
        Address.setBackground(new java.awt.Color(249, 245, 242));
        Address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressActionPerformed(evt);
            }
        });
        getContentPane().add(Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 310, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Mobile Number");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        MobileNo.setEditable(false);
        MobileNo.setBackground(new java.awt.Color(249, 245, 242));
        MobileNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(MobileNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 120, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Gender");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Pending");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, -1, 20));

        Pending.setEditable(false);
        Pending.setBackground(new java.awt.Color(249, 245, 242));
        Pending.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Pending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PendingActionPerformed(evt);
            }
        });
        getContentPane().add(Pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 90, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Delivered");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, 20));

        Delivered.setEditable(false);
        Delivered.setBackground(new java.awt.Color(249, 245, 242));
        Delivered.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Delivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeliveredActionPerformed(evt);
            }
        });
        getContentPane().add(Delivered, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 90, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Total Paid (Taka)");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, -1, 20));

        Total_Paid.setEditable(false);
        Total_Paid.setBackground(new java.awt.Color(249, 245, 242));
        Total_Paid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Total_Paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total_PaidActionPerformed(evt);
            }
        });
        getContentPane().add(Total_Paid, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 140, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Total Rest (Taka)");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, -1, 20));

        Total_Rest.setEditable(false);
        Total_Rest.setBackground(new java.awt.Color(249, 245, 242));
        Total_Rest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Total_Rest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total_RestActionPerformed(evt);
            }
        });
        getContentPane().add(Total_Rest, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 130, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Total Order (Taka)");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 220, 120, 20));

        Total_Preparing_Cost.setEditable(false);
        Total_Preparing_Cost.setBackground(new java.awt.Color(249, 245, 242));
        Total_Preparing_Cost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Total_Preparing_Cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 240, 140, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("To (Last date)");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 90, 20));

        jLabel6.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Pending Orders");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 980, 40));

        DeliveredOrders.setBackground(new java.awt.Color(249, 245, 242));
        DeliveredOrders.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DeliveredOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Customer ID", "Dress ID", "Order Date", "Delivery Date", "Preparing Cost", "Discount (%)"
            }
        ));
        DeliveredOrders.setToolTipText("");
        DeliveredOrders.setName(""); // NOI18N
        DeliveredOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeliveredOrdersMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(DeliveredOrders);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 980, 150));

        PendingOrders.setBackground(new java.awt.Color(249, 245, 242));
        PendingOrders.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PendingOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Customer ID", "Dress ID", "Order Date", "Delivery Date", "Rest Amount", "Cost", "Discount (%)"
            }
        ));
        PendingOrders.setToolTipText("");
        PendingOrders.setName(""); // NOI18N
        PendingOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PendingOrdersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(PendingOrders);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 980, 150));

        jLabel7.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Delivered Orders");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 980, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, -1));

        jLabel15.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sewing.png"))); // NOI18N
        jLabel15.setText(" Customer Details ");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 80));

        RootSelectionIcon.setBackground(new java.awt.Color(249, 245, 242));
        RootSelectionIcon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        RootSelectionIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg.jpg"))); // NOI18N
        getContentPane().add(RootSelectionIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        
        new Customer_Info().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        
        if (First_Date.getDate() != null && Last_Date.getDate() != null) {
            
            try {
                Date firstDate = First_Date.getDate();
                Date lastDate = Last_Date.getDate();

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

    }//GEN-LAST:event_SearchActionPerformed

    private void First_DateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_First_DateMouseClicked
        
        try {
            All_View();
            Set_All_the_Data_through_CustomerID(Integer.parseInt(CustomerID.getText()));
            All_Transactions_View_thorugh_CustomerID(Integer.parseInt(CustomerID.getText()));
        } catch (ClassNotFoundException ex) {}
        
    }//GEN-LAST:event_First_DateMouseClicked

    private void Last_DateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Last_DateMouseClicked
        
        try {
            All_View();
            Set_All_the_Data_through_CustomerID(Integer.parseInt(CustomerID.getText()));
            All_Transactions_View_thorugh_CustomerID(Integer.parseInt(CustomerID.getText()));
        } catch (ClassNotFoundException ex) {}
        
    }//GEN-LAST:event_Last_DateMouseClicked

    private void All_ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_All_ViewActionPerformed
        
        try {
            All_View();
            Set_All_the_Data_through_CustomerID(Integer.parseInt(CustomerID.getText()));
            All_Transactions_View_thorugh_CustomerID(Integer.parseInt(CustomerID.getText()));
        } catch (ClassNotFoundException ex) {}
        
    }//GEN-LAST:event_All_ViewActionPerformed

    private void PendingOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PendingOrdersMouseClicked
        
    }//GEN-LAST:event_PendingOrdersMouseClicked

    private void DeliveredOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeliveredOrdersMouseClicked
        
    }//GEN-LAST:event_DeliveredOrdersMouseClicked

    private void CustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerNameActionPerformed

    private void AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressActionPerformed

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

    private void GenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenderActionPerformed

    private void CustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerIDActionPerformed

    private void Total_OrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Total_OrdersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Total_OrdersActionPerformed

    private void All_ViewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseMoved
        All_View.setCursor(cursor);
    }//GEN-LAST:event_All_ViewMouseMoved

    private void SearchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseMoved
        Search.setCursor(cursor);
    }//GEN-LAST:event_SearchMouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Customer_Details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address;
    private javax.swing.JButton All_View;
    private javax.swing.JButton Back;
    private javax.swing.JTextField CustomerID;
    private javax.swing.JTextField CustomerName;
    private javax.swing.JTextField Delivered;
    private javax.swing.JTable DeliveredOrders;
    private com.toedter.calendar.JDateChooser First_Date;
    private javax.swing.JTextField Gender;
    private com.toedter.calendar.JDateChooser Last_Date;
    private javax.swing.JTextField MobileNo;
    private javax.swing.JTextField Pending;
    private javax.swing.JTable PendingOrders;
    private javax.swing.JLabel RootSelectionIcon;
    private javax.swing.JButton Search;
    private javax.swing.JTextField Total_Orders;
    private javax.swing.JTextField Total_Paid;
    private javax.swing.JTextField Total_Preparing_Cost;
    private javax.swing.JTextField Total_Rest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
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