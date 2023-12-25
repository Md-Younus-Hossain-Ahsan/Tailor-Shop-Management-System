package MyProject;

import JClasses.Customer;
import JClasses.DressCategory;
import JClasses.Measurements;
import JClasses.Order;
import static MyProject.SignIN.cursor;
import static MyProject.SignIN.url;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public final class Edit_an_Order extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    Timer timer;
    SimpleDateFormat rdf = new SimpleDateFormat("HH");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    int Total = 0;  
    float DiscountRate = 0;  
    float PaymentRate = 0; 
    int Payment_Amount = 0;
        
    public Edit_an_Order() throws ClassNotFoundException{
        
        initComponents();
        Current_Date_and_Time();
        
        Date date = new Date();
        DeliveryDate.getDayChooser().setMinSelectableDate(date);
        
        Dress_Category((String) DressType.getSelectedItem());
        
    }
    
    
    public Edit_an_Order(int Customer_ID, int Order_ID) throws ClassNotFoundException{
        
        initComponents();
        Current_Date_and_Time();
        
        Date date = new Date();
        DeliveryDate.getDayChooser().setMinSelectableDate(date);
        
        CustomerID.setText(Integer.toString(Customer_ID));
        Set_All_the_Data_through_CustomerID(Customer_ID);
        OrderID.setText(Integer.toString(Order_ID));
        Set_All_the_Data_through_OrderID(Order_ID);
        
        Dress_Category((String) DressType.getSelectedItem());
    
    }
    
    
    public void Current_Date_and_Time(){
        
        timer = new Timer(1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Date CurrentDate = new Date(); 
                
                int check = Integer.parseInt(rdf.format(CurrentDate));
                if(check > 11)
                    OrderDate.setText(sdf.format(CurrentDate) + " PM");
                else
                    OrderDate.setText(sdf.format(CurrentDate) + " AM");
            }

            private void setVisible(boolean b) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        timer.start();      
    }
    
    
    public void Data_Updating() throws ClassNotFoundException, ParseException{
        
        Order order = new Order();
        Measurements measurement = new Measurements();
               
        order.update_the_Order_list(Integer.parseInt(OrderID.getText()), Integer.parseInt(DressID.getText()), DeliveryDate.getDate(), Float.parseFloat(Discount.getText()), Integer.parseInt(TotalCost.getText()) - Integer.parseInt(Minimum_Payment.getText()), Integer.parseInt(TotalCost.getText()));
        measurement.update_the_Measurement_list(Integer.parseInt(OrderID.getText()), Float.parseFloat(Neck.getText()), Float.parseFloat(Chest.getText()), Float.parseFloat(Height.getText()), Float.parseFloat(Wrist.getText()), Float.parseFloat(Hip.getText()));

        new Order_Buffer(Integer.parseInt(CustomerID.getText())).setVisible(true);
        dispose();
        
    }
    
    
    public void Last_OrderID_set() throws ClassNotFoundException{
        
        Order order = new Order();
        order.Last_ID_Search();
        OrderID.setText(Integer.toString(order.getOrderID()));            
        
    }
    
    
    public void Dress_Category(String DressType){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql;
            
            if(DressType.equals("All types"))
                sql = "Select * from Dress_Category";
            else
                sql = "Select * from Dress_Category where Gender = '"+ DressType +"'";
            
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();            
            Dress_Category.setModel(new DefaultTableModel(null, new String[] {"Dress ID","Dress Name","Gender","Preparing Cost"}));
            
            while(rs.next())
            {
                String tbData[] = {Integer.toString(rs.getInt("DressID")),
                                   rs.getString("Name"),
                                   rs.getString("Gender"),
                                   Integer.toString(rs.getInt("PreparingCost"))};
                DefaultTableModel tbModel = (DefaultTableModel) Dress_Category.getModel();
                tbModel.addRow(tbData);
            }
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {}
    }
    
    
    public void Reset()
    {
        CustomerID.setText(null);
        MobileNo.setText(null);
        CustomerName.setText(null);
        Gender.setText(null);
        Address.setText(null);
        DressID.setText(null);
        DressName.setText(null);
        PreparingCost.setText(null);
        Minimum_Payment.setText(null);
        TotalCost.setText(null);
        Neck.setText("0");
        Chest.setText("0");
        Height.setText("0");
        Wrist.setText("0");
        Hip.setText("0");
        DressType.setSelectedIndex(0);
    }
    
    
    public void Set_All_the_Data_through_CustomerID(int CustomerID) throws ClassNotFoundException{
        
        Customer customer = new Customer();
        
        customer.searching_all_the_information_through_CustomerID(CustomerID);
        
        CustomerName.setText(customer.getName());
        MobileNo.setText(customer.getMobileNumber());
        Gender.setText(customer.getGender());
        Address.setText(customer.getAddress());
        
    }
    
    
    public void Set_All_the_Data_through_OrderID(int OrderID) throws ClassNotFoundException{
        
        Order order = new Order();
        DressCategory dressCategory = new DressCategory();
        Measurements measurement = new Measurements();
        
        order.searching_all_the_information(OrderID);
        measurement.searching_all_the_information(OrderID);
        
        DressID.setText(Integer.toString(order.getDressID()));
        
        dressCategory.searching_all_the_information(order.getDressID());
        DressName.setText(dressCategory.getName());
        PreparingCost.setText(Integer.toString(dressCategory.getPreparingCost()));
        
        Discount.setText(Float.toString(order.getDiscount()));
        TotalCost.setText(Integer.toString(order.getTotal_cost()));
        Minimum_Payment.setText(Integer.toString(order.getTotal_cost() - order.getRest_amount()));
        
        PaymentRate = (float) ((float) Float.parseFloat(Minimum_Payment.getText()) * 100.0 / Float.parseFloat(PreparingCost.getText()));
        PaymentRate = (float) (Math.round(PaymentRate * 100.0) / 100.0);
        Payment_Rate.setText(Float.toString(PaymentRate));
        
        Neck.setText(Float.toString(measurement.getNeck()));
        Chest.setText(Float.toString(measurement.getChest()));
        Height.setText(Float.toString(measurement.getHeight()));
        Wrist.setText(Float.toString(measurement.getWrist()));
        Hip.setText(Float.toString(measurement.getHip()));
        
    }
    
    
    public void Set_All_the_Data_through_MobileNumber(String MobileNumber) throws ClassNotFoundException{
        
        Customer customer = new Customer();
        
        customer.searching_all_the_information_through_MobileNumber(MobileNumber);
        
        CustomerID.setText(Integer.toString(customer.getCustomerID()));
        CustomerName.setText(customer.getName());
        Gender.setText(customer.getGender());
        Address.setText(customer.getAddress());
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel35 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        Payment_Rate = new javax.swing.JTextField();
        CustomerName = new javax.swing.JTextField();
        OrderID = new javax.swing.JTextField();
        Gender = new javax.swing.JTextField();
        DressID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Dress_Category = new javax.swing.JTable();
        Address = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Height = new javax.swing.JTextField();
        PreparingCost = new javax.swing.JTextField();
        Back = new javax.swing.JButton();
        MobileNo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Update = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TotalCost = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        CustomerID = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Chest = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Hip = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Wrist = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Neck = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        Minimum_Payment = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        Discount = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        DressName = new javax.swing.JTextField();
        DressType = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        DeliveryDate = new com.toedter.calendar.JCalendar();
        OrderDate = new javax.swing.JTextField();
        RootSelectionIcon = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel35.setText("%");
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 30, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Payment Rate");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 90, 20));

        Payment_Rate.setBackground(new java.awt.Color(249, 245, 242));
        Payment_Rate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Payment_Rate.setText("30");
        Payment_Rate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Payment_RateMouseClicked(evt);
            }
        });
        Payment_Rate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Payment_RateKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Payment_RateKeyTyped(evt);
            }
        });
        getContentPane().add(Payment_Rate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 90, 30));

        CustomerName.setEditable(false);
        CustomerName.setBackground(new java.awt.Color(249, 245, 242));
        CustomerName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerNameActionPerformed(evt);
            }
        });
        getContentPane().add(CustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 180, 30));

        OrderID.setEditable(false);
        OrderID.setBackground(new java.awt.Color(249, 245, 242));
        OrderID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(OrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 30));

        Gender.setEditable(false);
        Gender.setBackground(new java.awt.Color(249, 245, 242));
        Gender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderActionPerformed(evt);
            }
        });
        getContentPane().add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 80, 30));

        DressID.setEditable(false);
        DressID.setBackground(new java.awt.Color(249, 245, 242));
        DressID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DressID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DressIDActionPerformed(evt);
            }
        });
        getContentPane().add(DressID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 90, 30));

        Dress_Category.setBackground(new java.awt.Color(249, 245, 242));
        Dress_Category.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dress ID", "Dress Name", "Preparing Cost (with all expenses)"
            }
        ));
        Dress_Category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Dress_CategoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Dress_Category);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 750, 170));

        Address.setEditable(false);
        Address.setBackground(new java.awt.Color(249, 245, 242));
        Address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressActionPerformed(evt);
            }
        });
        getContentPane().add(Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 230, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Contact Address");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Dress ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 60, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Customer Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Order ID");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 60, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Gender");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 50, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Mobile_Number");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 90, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Height");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 60, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Customer ID");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        Height.setBackground(new java.awt.Color(249, 245, 242));
        Height.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Height.setText("0");
        Height.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeightMouseClicked(evt);
            }
        });
        Height.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                HeightKeyTyped(evt);
            }
        });
        getContentPane().add(Height, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 60, 30));

        PreparingCost.setEditable(false);
        PreparingCost.setBackground(new java.awt.Color(249, 245, 242));
        PreparingCost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PreparingCost.setText("0");
        PreparingCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreparingCostActionPerformed(evt);
            }
        });
        getContentPane().add(PreparingCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 110, 30));

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
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 110, 40));

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
        getContentPane().add(MobileNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 130, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("  inch");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, 30, 30));

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
        getContentPane().add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 560, 110, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Delivery Date");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 90, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Dress Name");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 80, 20));

        TotalCost.setBackground(new java.awt.Color(249, 245, 242));
        TotalCost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TotalCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalCostActionPerformed(evt);
            }
        });
        TotalCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TotalCostKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TotalCostKeyTyped(evt);
            }
        });
        getContentPane().add(TotalCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 110, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setText(" /=");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, 40, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Total after discount");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, -1, 20));

        CustomerID.setEditable(false);
        CustomerID.setBackground(new java.awt.Color(249, 245, 242));
        CustomerID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CustomerID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerIDMouseClicked(evt);
            }
        });
        getContentPane().add(CustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Preparing Cost");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, 20));

        Chest.setBackground(new java.awt.Color(249, 245, 242));
        Chest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Chest.setText("0");
        Chest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChestMouseClicked(evt);
            }
        });
        Chest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ChestKeyTyped(evt);
            }
        });
        getContentPane().add(Chest, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 60, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Chest");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 60, 20));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("  inch");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 30, 30));

        Hip.setBackground(new java.awt.Color(249, 245, 242));
        Hip.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Hip.setText("0");
        Hip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HipMouseClicked(evt);
            }
        });
        Hip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                HipKeyTyped(evt);
            }
        });
        getContentPane().add(Hip, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 60, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Hip");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 60, 20));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("  inch");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, 30, 30));

        Wrist.setBackground(new java.awt.Color(249, 245, 242));
        Wrist.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Wrist.setText("0");
        Wrist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WristMouseClicked(evt);
            }
        });
        Wrist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                WristKeyTyped(evt);
            }
        });
        getContentPane().add(Wrist, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 60, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Dress Category for Specific Gender : ");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 260, 30));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("  inch");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 30, 30));

        Neck.setBackground(new java.awt.Color(249, 245, 242));
        Neck.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Neck.setText("0");
        Neck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NeckMouseClicked(evt);
            }
        });
        Neck.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NeckKeyTyped(evt);
            }
        });
        getContentPane().add(Neck, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 60, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Neck");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 60, 20));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Minimum Payment");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 150, 20));

        Minimum_Payment.setBackground(new java.awt.Color(249, 245, 242));
        Minimum_Payment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Minimum_Payment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Minimum_PaymentKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Minimum_PaymentKeyTyped(evt);
            }
        });
        getContentPane().add(Minimum_Payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 150, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel29.setText("%");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 100, -1, 30));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("  inch");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 40, 30));

        Discount.setBackground(new java.awt.Color(249, 245, 242));
        Discount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Discount.setText("0");
        Discount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DiscountMouseClicked(evt);
            }
        });
        Discount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DiscountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DiscountKeyTyped(evt);
            }
        });
        getContentPane().add(Discount, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 50, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Discount");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 60, 20));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Wrist");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 60, 20));

        DressName.setEditable(false);
        DressName.setBackground(new java.awt.Color(249, 245, 242));
        DressName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DressName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DressNameActionPerformed(evt);
            }
        });
        getContentPane().add(DressName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 180, 30));

        DressType.setBackground(new java.awt.Color(249, 245, 242));
        DressType.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DressType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All types", "Male", "Female" }));
        DressType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DressTypeMouseClicked(evt);
            }
        });
        DressType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DressTypeActionPerformed(evt);
            }
        });
        getContentPane().add(DressType, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 100, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Order Date & Time");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 20));

        DeliveryDate.setBackground(new java.awt.Color(255, 255, 255));
        DeliveryDate.setToolTipText("");
        getContentPane().add(DeliveryDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 240, 160));

        OrderDate.setEditable(false);
        OrderDate.setBackground(new java.awt.Color(249, 245, 242));
        OrderDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        OrderDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderDateActionPerformed(evt);
            }
        });
        getContentPane().add(OrderDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 190, 30));

        RootSelectionIcon.setBackground(new java.awt.Color(255, 255, 255));
        RootSelectionIcon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        RootSelectionIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg.jpg"))); // NOI18N
        getContentPane().add(RootSelectionIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 620));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel30.setText(" /=");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 40, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Dress_CategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Dress_CategoryMouseClicked
        
        int i = Dress_Category.getSelectedRow();
        TableModel model = Dress_Category.getModel();
        
        DressID.setText((String) model.getValueAt(i, 0));
        DressName.setText((String) model.getValueAt(i, 1));
        PreparingCost.setText((String) model.getValueAt(i, 3));
        TotalCost.setText((String) model.getValueAt(i, 3));
                
        Payment_Amount = (int) ((float)Integer.parseInt(TotalCost.getText()) * Float.parseFloat(Payment_Rate.getText())/100);
        Minimum_Payment.setText(Integer.toString(Payment_Amount));
        Discount.setText("0");
        Neck.setText("0");
        Chest.setText("0");
        Height.setText("0");
        Wrist.setText("0");
        Hip.setText("0");
        
    }//GEN-LAST:event_Dress_CategoryMouseClicked

    private void CustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerNameActionPerformed

    private void MobileNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MobileNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MobileNoActionPerformed

    @SuppressWarnings({"deprecation", "deprecation", "deprecation"})
    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        
        if(CustomerID.getText().isEmpty() || CustomerName.getText().isEmpty() || DressID.getText().isEmpty() || Discount.getText().isEmpty() || TotalCost.getText().isEmpty() || Payment_Rate.getText().isEmpty() || Minimum_Payment.getText().isEmpty() || Neck.getText().isEmpty() || Chest.getText().isEmpty() || Height.getText().isEmpty() || Wrist.getText().isEmpty() || Hip.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Enter the all the Information !");
        }
        else{
            try {    
                Data_Updating();
            } catch (ClassNotFoundException | ParseException ex) {}
        }      
        
    }//GEN-LAST:event_UpdateActionPerformed

    private void AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressActionPerformed

    private void PreparingCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreparingCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PreparingCostActionPerformed

    private void GenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenderActionPerformed

    private void DressIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DressIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DressIDActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        
        try {
            new Order_Buffer(Integer.parseInt(CustomerID.getText())).setVisible(true);
        } catch (ClassNotFoundException ex) {}
        dispose();
        
    }//GEN-LAST:event_BackActionPerformed

    private void TotalCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalCostActionPerformed

    private void DressNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DressNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DressNameActionPerformed

    private void DiscountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DiscountMouseClicked
        Discount.setText(null);
        Minimum_Payment.setText(null);
    }//GEN-LAST:event_DiscountMouseClicked

    private void NeckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NeckMouseClicked
        Neck.setText(null);        
    }//GEN-LAST:event_NeckMouseClicked

    private void ChestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChestMouseClicked
        Chest.setText(null);
    }//GEN-LAST:event_ChestMouseClicked

    private void HeightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeightMouseClicked
        Current_Date_and_Time();
        Height.setText(null);
    }//GEN-LAST:event_HeightMouseClicked

    private void WristMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WristMouseClicked
        Wrist.setText(null);
    }//GEN-LAST:event_WristMouseClicked

    private void HipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HipMouseClicked
        Hip.setText(null);
    }//GEN-LAST:event_HipMouseClicked

    private void CustomerIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerIDMouseClicked
        Reset();
    }//GEN-LAST:event_CustomerIDMouseClicked

    private void MobileNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MobileNoMouseClicked
        Reset();
    }//GEN-LAST:event_MobileNoMouseClicked

    private void DressTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DressTypeMouseClicked
        Dress_Category((String) DressType.getSelectedItem());
    }//GEN-LAST:event_DressTypeMouseClicked

    private void DressTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DressTypeActionPerformed
        Dress_Category((String) DressType.getSelectedItem());
    }//GEN-LAST:event_DressTypeActionPerformed

    private void OrderDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrderDateActionPerformed

    private void Payment_RateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Payment_RateMouseClicked
        Payment_Rate.setText(null);
        Minimum_Payment.setText(null);
    }//GEN-LAST:event_Payment_RateMouseClicked

    private void DiscountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DiscountKeyTyped
        if(!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.')
            evt.consume();
    }//GEN-LAST:event_DiscountKeyTyped

    private void Payment_RateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Payment_RateKeyTyped
        if(!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.')
            evt.consume();
    }//GEN-LAST:event_Payment_RateKeyTyped

    private void NeckKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NeckKeyTyped
        if(!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.')
            evt.consume();
    }//GEN-LAST:event_NeckKeyTyped

    private void ChestKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ChestKeyTyped
        if(!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.')
            evt.consume();
    }//GEN-LAST:event_ChestKeyTyped

    private void HeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HeightKeyTyped
        if(!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.')
            evt.consume();
    }//GEN-LAST:event_HeightKeyTyped

    private void WristKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_WristKeyTyped
        if(!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.')
            evt.consume();
    }//GEN-LAST:event_WristKeyTyped

    private void HipKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HipKeyTyped
        if(!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.')
            evt.consume();
    }//GEN-LAST:event_HipKeyTyped

    private void DiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DiscountKeyReleased
        
        if(!Discount.getText().isEmpty())
        {
            Total = (int) (Float.parseFloat(PreparingCost.getText()) * (float)((100-Float.parseFloat(Discount.getText()))/100.0));
            TotalCost.setText(Integer.toString(Total));
            
            if(!Payment_Rate.getText().isEmpty())
            {
                Payment_Amount = (int) ((float)Integer.parseInt(TotalCost.getText()) * Float.parseFloat(Payment_Rate.getText())/100);
                Minimum_Payment.setText(Integer.toString(Payment_Amount));
            }
        }
        else
            TotalCost.setText(null);
        
    }//GEN-LAST:event_DiscountKeyReleased

    private void TotalCostKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TotalCostKeyReleased
        
        if(!TotalCost.getText().isEmpty())
        {
            DiscountRate = (float) (100.0 - (Float.parseFloat(TotalCost.getText()) * 100.0 / Float.parseFloat(PreparingCost.getText())));
            DiscountRate = (float) (Math.round(DiscountRate * 100.0) / 100.0);
            Discount.setText(Float.toString(DiscountRate));

            if(!Payment_Rate.getText().isEmpty())
            {
                Payment_Amount = (int) ((float)Integer.parseInt(TotalCost.getText()) * Float.parseFloat(Payment_Rate.getText())/100);
                Minimum_Payment.setText(Integer.toString(Payment_Amount));        
            }
        }
        else
            Discount.setText(null);
        
    }//GEN-LAST:event_TotalCostKeyReleased

    private void Payment_RateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Payment_RateKeyReleased
        
        if(!Payment_Rate.getText().isEmpty())
        {
            Payment_Amount = (int) ((float)Integer.parseInt(TotalCost.getText()) * Float.parseFloat(Payment_Rate.getText())/100);
            Minimum_Payment.setText(Integer.toString(Payment_Amount));
            
        }
        else
            Minimum_Payment.setText(null);
            
    }//GEN-LAST:event_Payment_RateKeyReleased

    private void Minimum_PaymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Minimum_PaymentKeyReleased
        
        if(!Minimum_Payment.getText().isEmpty())
        {
            PaymentRate = (float) ((float) Float.parseFloat(Minimum_Payment.getText()) * 100.0 / Float.parseFloat(PreparingCost.getText()));
            PaymentRate = (float) (Math.round(PaymentRate * 100.0) / 100.0);
            Payment_Rate.setText(Float.toString(PaymentRate));
        }
        else
            Payment_Rate.setText(null);
        
    }//GEN-LAST:event_Minimum_PaymentKeyReleased

    private void TotalCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TotalCostKeyTyped
        if(!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.')
            evt.consume();
    }//GEN-LAST:event_TotalCostKeyTyped

    private void Minimum_PaymentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Minimum_PaymentKeyTyped
        if(!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.')
            evt.consume();
    }//GEN-LAST:event_Minimum_PaymentKeyTyped

    private void BackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseMoved
        Back.setCursor(cursor);
    }//GEN-LAST:event_BackMouseMoved

    private void UpdateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseMoved
        Update.setCursor(cursor);
    }//GEN-LAST:event_UpdateMouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Edit_an_Order().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Edit_an_Order.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address;
    private javax.swing.JButton Back;
    private javax.swing.JTextField Chest;
    private javax.swing.JTextField CustomerID;
    private javax.swing.JTextField CustomerName;
    private com.toedter.calendar.JCalendar DeliveryDate;
    private javax.swing.JTextField Discount;
    private javax.swing.JTextField DressID;
    private javax.swing.JTextField DressName;
    private javax.swing.JComboBox<String> DressType;
    private javax.swing.JTable Dress_Category;
    private javax.swing.JTextField Gender;
    private javax.swing.JTextField Height;
    private javax.swing.JTextField Hip;
    private javax.swing.JTextField Minimum_Payment;
    private javax.swing.JTextField MobileNo;
    private javax.swing.JTextField Neck;
    private javax.swing.JTextField OrderDate;
    private javax.swing.JTextField OrderID;
    private javax.swing.JTextField Payment_Rate;
    private javax.swing.JTextField PreparingCost;
    private javax.swing.JLabel RootSelectionIcon;
    private javax.swing.JTextField TotalCost;
    private javax.swing.JButton Update;
    private javax.swing.JTextField Wrist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
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