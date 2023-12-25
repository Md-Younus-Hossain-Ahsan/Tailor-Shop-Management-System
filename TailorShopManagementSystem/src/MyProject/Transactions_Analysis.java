package MyProject;

import JClasses.Expenses;
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

public final class Transactions_Analysis extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

        
    public Transactions_Analysis(){
        
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
            
            String sql1 = "select O.OrderID, T.Amount, T.Date, O.OrderType FROM Orders AS O JOIN Transactions AS T ON O.OrderID = T.OrderID order by T.Date asc";
            String sql2 = "select * FROM Expenses order by Cost_date asc";
            
            PreparedStatement pst1 = con.prepareStatement(sql1);
            PreparedStatement pst2 = con.prepareStatement(sql2);
            
            ResultSet res = pst1.executeQuery();
            ResultSet ress = pst2.executeQuery();
                        
            All_Transactions_Amount_Calculation();
            All_Expenses_Amount_Calculation();
                        
            First_Date.setDate(null);
            Last_Date.setDate(null);
            All_Earnings.setModel(new DefaultTableModel(null, new String[] {"Order ID","Amount","Transaction Date","Order Type"}));
            All_Expenses.setModel(new DefaultTableModel(null, new String[] {"ExpID","Issue","Expense Date","Cost Amount"}));
            
            while(res.next())
            {
                String tbData[] = {Integer.toString(res.getInt("OrderID")),
                                    Integer.toString(res.getInt("Amount")),                                   
                                    res.getTimestamp("Date").toString(),
                                    res.getString("OrderType")};
                
                DefaultTableModel tbModel = (DefaultTableModel) All_Earnings.getModel();
                tbModel.addRow(tbData);
            }
            
            while(ress.next())
            {
                String tbData[] = {Integer.toString(ress.getInt("ExpID")),
                                    ress.getString("Issue"),                                   
                                    ress.getTimestamp("Cost_date").toString(),
                                    Integer.toString(ress.getInt("Amount"))};
                
                DefaultTableModel tbModel = (DefaultTableModel) All_Expenses.getModel();
                tbModel.addRow(tbData);
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}
        
    }
    
    
    public void All_Transactions_Amount_Calculation(){
        
        Transactions transactions = new Transactions();
        
        transactions.all_transactions_amount_calculation();
        
        Total_Earnings_Amount.setText(Integer.toString(transactions.getTotal_Earnings_Amount())); 
        
    }
    
    
    public void All_Expenses_Amount_Calculation(){
        
        Expenses expense = new Expenses();
        
        expense.all_expenses_amount_calculation();
        
        Total_Expense_Amount.setText(Integer.toString(expense.getTotal_Expenses_Amount())); 
        
    }
    
    
    public void All_View_between_two_Dates(){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql1 = "select O.OrderID, T.Amount, T.Date, O.OrderType FROM Orders AS O JOIN Transactions AS T ON O.OrderID = T.OrderID WHERE T.Date BETWEEN ? AND ? order by T.Date asc";
            String sql2 = "select * FROM Expenses WHERE Cost_date BETWEEN ? AND ? order by Cost_date asc";
            
            PreparedStatement pst1 = con.prepareStatement(sql1);
            PreparedStatement pst2 = con.prepareStatement(sql2);
            
            pst1.setDate(1, new java.sql.Date(First_Date.getDate().getTime()));
            
            Date nextDate = new Date(Last_Date.getDate().getTime() + TimeUnit.DAYS.toMillis(1));

            pst1.setDate(2, new java.sql.Date(nextDate.getTime()));
            
            pst2.setDate(1, new java.sql.Date(First_Date.getDate().getTime()));
            pst2.setDate(2, new java.sql.Date(nextDate.getTime()));
            
            ResultSet res = pst1.executeQuery();
            ResultSet ress = pst2.executeQuery();
                        
            All_Transactions_Amount_Calculation_between_two_Dates();
            All_Expenses_Amount_Calculation_between_two_Dates();
                        
            All_Earnings.setModel(new DefaultTableModel(null, new String[] {"Order ID","Amount","Transaction Date","Order Type"}));
            All_Expenses.setModel(new DefaultTableModel(null, new String[] {"ExpID","Issue","Expense Date","Cost Amount"}));
            
            while(res.next())
            {
                String tbData[] = {Integer.toString(res.getInt("OrderID")),
                                    Integer.toString(res.getInt("Amount")),                                   
                                    res.getTimestamp("Date").toString(),
                                    res.getString("OrderType")};
                
                DefaultTableModel tbModel = (DefaultTableModel) All_Earnings.getModel();
                tbModel.addRow(tbData);
            }
            
            while(ress.next())
            {
                String tbData[] = {Integer.toString(ress.getInt("ExpID")),
                                    ress.getString("Issue"),                                   
                                    ress.getTimestamp("Cost_date").toString(),
                                    Integer.toString(ress.getInt("Amount"))};
                
                DefaultTableModel tbModel = (DefaultTableModel) All_Expenses.getModel();
                tbModel.addRow(tbData);
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}
        
    }
    
    
    public void All_Transactions_Amount_Calculation_between_two_Dates(){
        
        Transactions transactions = new Transactions();
        
        Date nextDate = new Date(Last_Date.getDate().getTime() + TimeUnit.DAYS.toMillis(1));

        transactions.all_transactions_amount_calculation_between_two_Dates(First_Date.getDate(), nextDate);
        
        Total_Expense_Amount.setText(Integer.toString(transactions.getTotal_Amount())); 
        
    }
    
    
    public void All_Expenses_Amount_Calculation_between_two_Dates(){
        
        Expenses expense = new Expenses();
        
        Date nextDate = new Date(Last_Date.getDate().getTime() + TimeUnit.DAYS.toMillis(1));

        expense.all_transactions_amount_calculation_between_two_Dates(First_Date.getDate(), nextDate);
        
        Total_Expense_Amount.setText(Integer.toString(expense.getTotal_Expenses_Amount())); 
        
    }
    
    
    public void Reset_all(){
        
        First_Date.setDate(null);
        Last_Date.setDate(null);
        Reset();
        
    }
    
    
    public void Reset(){
        
        Issue.setText(null);
        Description.setText(null);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        All_Earnings = new javax.swing.JTable();
        MainMenu = new javax.swing.JButton();
        All_View = new javax.swing.JButton();
        Search = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Total_Earnings_Amount = new javax.swing.JTextField();
        First_Date = new com.toedter.calendar.JDateChooser();
        Last_Date = new com.toedter.calendar.JDateChooser();
        Total_Expense_Amount = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Issue = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        All_Expenses = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextArea();
        RootSelectionIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        All_Earnings.setBackground(new java.awt.Color(249, 245, 242));
        All_Earnings.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        All_Earnings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Amount", " Transaction Date", "Order Type"
            }
        ));
        All_Earnings.setToolTipText("");
        All_Earnings.setName(""); // NOI18N
        All_Earnings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                All_EarningsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                All_EarningsMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(All_Earnings);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 1070, 160));

        MainMenu.setBackground(new java.awt.Color(249, 245, 242));
        MainMenu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MainMenu.setText("Main Menu");
        MainMenu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MainMenuMouseMoved(evt);
            }
        });
        MainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuActionPerformed(evt);
            }
        });
        getContentPane().add(MainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 675, 140, 40));

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
        getContentPane().add(All_View, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 110, 30));

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
        getContentPane().add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, 110, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("From (1st date)");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 90, 20));

        Total_Earnings_Amount.setEditable(false);
        Total_Earnings_Amount.setBackground(new java.awt.Color(249, 245, 242));
        Total_Earnings_Amount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Total_Earnings_Amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total_Earnings_AmountActionPerformed(evt);
            }
        });
        getContentPane().add(Total_Earnings_Amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 180, 30));

        First_Date.setBackground(new java.awt.Color(249, 245, 242));
        First_Date.setDateFormatString("yyyy-MM-dd");
        First_Date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        First_Date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                First_DateMouseClicked(evt);
            }
        });
        getContentPane().add(First_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 210, 30));

        Last_Date.setBackground(new java.awt.Color(249, 245, 242));
        Last_Date.setDateFormatString("yyyy-MM-dd");
        Last_Date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Last_Date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Last_DateMouseClicked(evt);
            }
        });
        getContentPane().add(Last_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 210, 30));

        Total_Expense_Amount.setEditable(false);
        Total_Expense_Amount.setBackground(new java.awt.Color(249, 245, 242));
        Total_Expense_Amount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Total_Expense_Amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total_Expense_AmountActionPerformed(evt);
            }
        });
        getContentPane().add(Total_Expense_Amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, 180, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Total Earnings Amount");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, -1, 20));

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("All types of Expenses");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 1070, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("To (Last date)");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 90, 20));

        jLabel6.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("All types of Earnings");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 1070, 40));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Expense's Issue");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, -1, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Short Description");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, -1, 20));

        Issue.setEditable(false);
        Issue.setBackground(new java.awt.Color(249, 245, 242));
        Issue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Issue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IssueActionPerformed(evt);
            }
        });
        getContentPane().add(Issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 390, 30));

        All_Expenses.setBackground(new java.awt.Color(249, 245, 242));
        All_Expenses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SI No", "Issue", "Expense Date", "Cost Amount"
            }
        ));
        All_Expenses.setToolTipText("");
        All_Expenses.setName(""); // NOI18N
        All_Expenses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                All_ExpensesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(All_Expenses);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 1070, 130));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Total Cost Amount");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, -1, 20));

        jLabel9.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sewing.png"))); // NOI18N
        jLabel9.setText(" Transactions Analysis ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 80));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo2.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1035, 10, -1, -1));

        Description.setEditable(false);
        Description.setBackground(new java.awt.Color(249, 245, 242));
        Description.setColumns(20);
        Description.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Description.setRows(5);
        jScrollPane1.setViewportView(Description);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 560, 630, -1));

        RootSelectionIcon.setBackground(new java.awt.Color(255, 255, 255));
        RootSelectionIcon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        RootSelectionIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg.jpg"))); // NOI18N
        getContentPane().add(RootSelectionIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuActionPerformed
        dispose();  
    }//GEN-LAST:event_MainMenuActionPerformed

    private void All_EarningsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_EarningsMouseClicked
        
    }//GEN-LAST:event_All_EarningsMouseClicked

    private void Total_Expense_AmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Total_Expense_AmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Total_Expense_AmountActionPerformed

    private void IssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IssueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IssueActionPerformed

    private void All_ExpensesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ExpensesMouseClicked
        
        int i = All_Expenses.getSelectedRow();
        TableModel model = All_Expenses.getModel();
        
        Expenses expense = new Expenses();
        
        expense.description_from_SI_no(Integer.parseInt((String) model.getValueAt(i, 0)));
        Issue.setText((String) model.getValueAt(i, 1));
        Description.setText(expense.getDescription());
        
    }//GEN-LAST:event_All_ExpensesMouseClicked

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        
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

    }                                      

    private void First_DateMouseClicked() {                                        
        
    }//GEN-LAST:event_SearchActionPerformed

    private void First_DateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_First_DateMouseClicked
        All_View();
        Reset();
    }//GEN-LAST:event_First_DateMouseClicked

    private void Last_DateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Last_DateMouseClicked
        All_View();
        Reset();
    }//GEN-LAST:event_Last_DateMouseClicked

    private void All_ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_All_ViewActionPerformed
        All_View();
        Reset_all();
    }//GEN-LAST:event_All_ViewActionPerformed

    private void Total_Earnings_AmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Total_Earnings_AmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Total_Earnings_AmountActionPerformed

    private void All_ViewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseMoved
        All_View.setCursor(cursor);
    }//GEN-LAST:event_All_ViewMouseMoved

    private void SearchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseMoved
        Search.setCursor(cursor);
    }//GEN-LAST:event_SearchMouseMoved

    private void MainMenuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainMenuMouseMoved
        MainMenu.setCursor(cursor);
    }//GEN-LAST:event_MainMenuMouseMoved

    private void All_EarningsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_EarningsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_All_EarningsMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Transactions_Analysis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable All_Earnings;
    private javax.swing.JTable All_Expenses;
    private javax.swing.JButton All_View;
    private javax.swing.JTextArea Description;
    private com.toedter.calendar.JDateChooser First_Date;
    private javax.swing.JTextField Issue;
    private com.toedter.calendar.JDateChooser Last_Date;
    private javax.swing.JButton MainMenu;
    private javax.swing.JLabel RootSelectionIcon;
    private javax.swing.JButton Search;
    private javax.swing.JTextField Total_Earnings_Amount;
    private javax.swing.JTextField Total_Expense_Amount;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
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