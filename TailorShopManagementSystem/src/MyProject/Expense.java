package MyProject;

import JClasses.Expenses;
import static MyProject.SignIN.cursor;
import static MyProject.SignIN.url;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public final class Expense extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    Timer timer;
    int ExpID = 0;
    SimpleDateFormat rdf = new SimpleDateFormat("HH");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    
    public Expense() {
        
        initComponents();        
        All_View_of_last_month();
        Current_Date_and_Time();        
    }
    
    
    public void All_View_of_last_month(){
        
        LocalDate currentDate = LocalDate.now();
        LocalDate dateBeforeOneMonth = currentDate.minusMonths(1);
        
        First_Date.setDate(java.sql.Date.valueOf(dateBeforeOneMonth));
        Last_Date.setDate(java.sql.Date.valueOf(currentDate));
        
        All_Expenses_View_between_two_Dates();
        
    }
    
    
    public void Current_Date_and_Time(){
        
        timer = new Timer(1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Date CurrentDate = new Date(); 
                
                int check = Integer.parseInt(rdf.format(CurrentDate));
                if(check > 11)
                    Cost_date.setText(sdf.format(CurrentDate) + " PM");
                else
                    Cost_date.setText(sdf.format(CurrentDate) + " AM");
            }

            private void setVisible(boolean b) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        timer.start();      
    }
    
    
    public void All_View(){
        
        try{
            Current_Date_and_Time();
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "Select * from Expenses order by Cost_date desc";
            PreparedStatement sst = con.prepareStatement(sql);
            
            ResultSet res = sst.executeQuery();
            All_Expenses.setModel(new DefaultTableModel(null, new String[] {"ExpID", "Issue", "Cost Amount", "Short Description", "Date"}));

            while(res.next())
            {
                    String tbData[] = {Integer.toString(res.getInt("ExpID")),
                                        res.getString("Issue"),
                                        Integer.toString(res.getInt("Amount")),
                                        res.getString("Description"),
                                        res.getTimestamp("Cost_date").toString()};
                    DefaultTableModel tbModel = (DefaultTableModel) All_Expenses.getModel();
                    tbModel.addRow(tbData);
            }
            Reset_all();
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {}
    
    }
    
    
    public void All_Expenses_View_between_two_Dates(){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "SELECT * FROM Expenses WHERE Cost_date BETWEEN ? AND ? ORDER BY Cost_date desc";

            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setDate(1, new java.sql.Date(First_Date.getDate().getTime()));
            
            Date nextDate = new Date(Last_Date.getDate().getTime() + TimeUnit.DAYS.toMillis(1));

            pst.setDate(2, new java.sql.Date(nextDate.getTime()));
            
            ResultSet res = pst.executeQuery();
                        
            All_Expenses.setModel(new DefaultTableModel(null, new String[] {"ExpID", "Issue", "Cost Amount", "Short Description", "Date"}));

            while(res.next())
            {
                    String tbData[] = {Integer.toString(res.getInt("ExpID")),
                                        res.getString("Issue"),
                                        Integer.toString(res.getInt("Amount")),
                                        res.getString("Description"),
                                        res.getTimestamp("Cost_date").toString()};
                    DefaultTableModel tbModel = (DefaultTableModel) All_Expenses.getModel();
                    tbModel.addRow(tbData);
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}
        
    }
    
    
    public void Reset_all(){
        
        First_Date.setDate(null);
        Last_Date.setDate(null);
        Reset();  
        
    }
    
    
    public void Reset(){
        
        Issue.setText(null);
        Amount.setText(null);
        Description.setText(null);  
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        All_Expenses = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Issue = new javax.swing.JTextField();
        Amount = new javax.swing.JTextField();
        Back = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Cost_date = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        First_Date = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        Last_Date = new com.toedter.calendar.JDateChooser();
        All_View = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Info_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        All_Expenses.setBackground(new java.awt.Color(249, 245, 242));
        All_Expenses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ExpID", "Issue", "Cost Amount", "Short Description", "Date"
            }
        ));
        All_Expenses.setToolTipText("");
        All_Expenses.setName(""); // NOI18N
        All_Expenses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                All_ExpensesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(All_Expenses);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 640, 230));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Short Description");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Current Date & Time");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, -1, -1));

        Issue.setBackground(new java.awt.Color(249, 245, 242));
        Issue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Issue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IssueMouseClicked(evt);
            }
        });
        Issue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IssueActionPerformed(evt);
            }
        });
        getContentPane().add(Issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 310, 30));

        Amount.setBackground(new java.awt.Color(249, 245, 242));
        Amount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Amount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AmountMouseClicked(evt);
            }
        });
        Amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AmountKeyTyped(evt);
            }
        });
        getContentPane().add(Amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 130, 30));

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
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 110, 40));

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
        getContentPane().add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 550, 110, 40));

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
        getContentPane().add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 550, 110, 40));

        Cost_date.setBackground(new java.awt.Color(249, 245, 242));
        Cost_date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Cost_date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cost_dateMouseClicked(evt);
            }
        });
        Cost_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cost_dateActionPerformed(evt);
            }
        });
        getContentPane().add(Cost_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 160, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Cost Ammount (Taka)");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("From (1st date)");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, 20));

        Search.setBackground(new java.awt.Color(249, 245, 242));
        Search.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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
        getContentPane().add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 80, 30));

        First_Date.setBackground(new java.awt.Color(249, 245, 242));
        First_Date.setDateFormatString("yyyy-MM-dd");
        First_Date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        First_Date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                First_DateMouseClicked(evt);
            }
        });
        getContentPane().add(First_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 210, 30));

        Description.setBackground(new java.awt.Color(249, 245, 242));
        Description.setColumns(20);
        Description.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        Description.setLineWrap(true);
        Description.setRows(5);
        Description.setTabSize(4);
        Description.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DescriptionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Description);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 310, 90));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("To (Last date)");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, 20));

        Last_Date.setBackground(new java.awt.Color(249, 245, 242));
        Last_Date.setDateFormatString("yyyy-MM-dd");
        Last_Date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Last_Date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Last_DateMouseClicked(evt);
            }
        });
        getContentPane().add(Last_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 210, 30));

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
        getContentPane().add(All_View, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 80, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo2.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sewing.png"))); // NOI18N
        jLabel8.setText(" Expenses ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 80));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Issue");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg.jpg"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void All_ExpensesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ExpensesMouseClicked
        
        int i = All_Expenses.getSelectedRow();
        TableModel model = All_Expenses.getModel();
        
        ExpID = Integer.parseInt((String) model.getValueAt(i, 0));
        Issue.setText((String) model.getValueAt(i, 1));
        Amount.setText((String) model.getValueAt(i, 2));
        Description.setText((String) model.getValueAt(i, 3));
        
    }//GEN-LAST:event_All_ExpensesMouseClicked
    
    
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        dispose();  
    }//GEN-LAST:event_BackActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        //Update in database        
        if(Issue.getText().isEmpty()|| Amount.getText().isEmpty() || Description.getText().isEmpty() || Cost_date.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Enter the all the Information !");
        }
        else
        {
            Expenses expense = new Expenses();
            
            try {
                expense.update_the_Expense_info(ExpID, Issue.getText(), Integer.parseInt(Amount.getText()), Description.getText());
            } catch (ClassNotFoundException ex) {}

            All_View();
        }
        
    }//GEN-LAST:event_UpdateActionPerformed

    private void IssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IssueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IssueActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        //Add to database
        if(Issue.getText().isEmpty()|| Amount.getText().isEmpty() || Description.getText().isEmpty() || Cost_date.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Enter the all the Information !");
        }
        else
        {
            Expenses expense = new Expenses();
            
            try {
                expense.insert_into_Expense_list(Issue.getText(), Integer.parseInt(Amount.getText()), Description.getText());
            } catch (ClassNotFoundException ex) {}

            All_View();
        }
        
    }//GEN-LAST:event_AddActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        
        if (First_Date.getDate() != null && Last_Date.getDate() != null) {
            
            try {
                Date firstDate = First_Date.getDate();
                Date lastDate = Last_Date.getDate();
                Reset();
                if (firstDate.before(lastDate) || firstDate.equals(lastDate)) 
                {                    
                    All_Expenses_View_between_two_Dates();
                    
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
        // TODO add your handling code here:     
    }//GEN-LAST:event_First_DateMouseClicked

    private void Cost_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cost_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cost_dateActionPerformed

    private void Last_DateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Last_DateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Last_DateMouseClicked

    private void All_ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_All_ViewActionPerformed
        All_View();
        Reset();
    }//GEN-LAST:event_All_ViewActionPerformed

    private void IssueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IssueMouseClicked
        
    }//GEN-LAST:event_IssueMouseClicked

    private void AmountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AmountMouseClicked
        
    }//GEN-LAST:event_AmountMouseClicked

    private void DescriptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DescriptionMouseClicked
        
    }//GEN-LAST:event_DescriptionMouseClicked

    private void Cost_dateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cost_dateMouseClicked
        
    }//GEN-LAST:event_Cost_dateMouseClicked

    private void AmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmountKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_AmountKeyTyped

    private void All_ViewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseMoved
        All_View.setCursor(cursor);
    }//GEN-LAST:event_All_ViewMouseMoved

    private void SearchMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseMoved
        Search.setCursor(cursor);
    }//GEN-LAST:event_SearchMouseMoved

    private void BackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseMoved
        Back.setCursor(cursor);
    }//GEN-LAST:event_BackMouseMoved

    private void UpdateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseMoved
        Update.setCursor(cursor);
    }//GEN-LAST:event_UpdateMouseMoved

    private void AddMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseMoved
        Add.setCursor(cursor);
    }//GEN-LAST:event_AddMouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Expense().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTable All_Expenses;
    private javax.swing.JButton All_View;
    private javax.swing.JTextField Amount;
    private javax.swing.JButton Back;
    private javax.swing.JTextField Cost_date;
    private javax.swing.JTextArea Description;
    private com.toedter.calendar.JDateChooser First_Date;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JTextField Issue;
    private com.toedter.calendar.JDateChooser Last_Date;
    private javax.swing.JButton Search;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
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