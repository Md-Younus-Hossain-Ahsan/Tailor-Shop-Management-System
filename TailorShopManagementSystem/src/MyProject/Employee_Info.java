package MyProject;

import JClasses.Employee;
import static MyProject.SignIN.cursor;
import static MyProject.SignIN.url;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public final class Employee_Info extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    
    public Employee_Info() {
        
        initComponents();        
        All_View();
    }
    
    public void All_View(){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "Select * from Employee";
            
            PreparedStatement sst = con.prepareStatement(sql);
            
            ResultSet res = sst.executeQuery();
            
            EmployeeInfo.setModel(new DefaultTableModel(null, new String[] {"Employee ID","Employee Name","Gender","Rank","Salary"}));
            
            while(res.next())
            {
                String tbData[] = {res.getString("EmployeeID"),
                                    res.getString("Name"),
                                    res.getString("Gender"),
                                    res.getString("Position"),
                                    Integer.toString(res.getInt("Salary"))};
                DefaultTableModel tbModel = (DefaultTableModel) EmployeeInfo.getModel();
                tbModel.addRow(tbData);
            }
            Reset();
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Employee_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
    public void Reset(){
        
        EmployeeID.setText(null);
        MobileNo.setText(null);
        EmployeeName.setText(null);
        Mobile_Number.setText(null);
        Email.setText(null);
        PresentAddress.setText(null);
        PermanentAddress.setText(null);
        Gender.setSelectedIndex(0);
        NID.setText(null);
        Position.setText(null);
        Salary.setText(null);    
        
    }
    
    
    public void Set_All_the_Data_through_EmployeeID(int EmployeeID) throws ClassNotFoundException{
        
        Employee employee = new Employee();
        
        employee.searching_all_the_information_through_EmployeeID(EmployeeID);
        
        EmployeeName.setText(employee.getName());
        MobileNo.setText(employee.getMobileNumber());
        Mobile_Number.setText(employee.getMobileNumber());
        Email.setText(employee.getEmail());
        PresentAddress.setText(employee.getPresentAddress());
        PermanentAddress.setText(employee.getPermanentAddress());
        Gender.setSelectedItem(employee.getGender());
        NID.setText(employee.getNID());
        Position.setText(employee.getPosition());
        Salary.setText(Integer.toString(employee.getSalary()));
        
    }
    
    
    public void Set_All_the_Data_through_MobileNumber(String MobileNumber) throws ClassNotFoundException{
        
        Employee employee = new Employee();
        
        employee.searching_all_the_information_through_MobileNumber(MobileNumber);
        
        EmployeeID.setText(Integer.toString(employee.getEmployeeID()));
        EmployeeName.setText(employee.getName());
        Mobile_Number.setText(MobileNumber);
        Email.setText(employee.getEmail());
        PresentAddress.setText(employee.getPresentAddress());
        PermanentAddress.setText(employee.getPermanentAddress());
        Gender.setSelectedItem(employee.getGender());
        NID.setText(employee.getNID());
        Position.setText(employee.getPosition());
        Salary.setText(Integer.toString(employee.getSalary()));
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        EmployeeInfo = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Gender = new javax.swing.JComboBox<>();
        PresentAddress = new javax.swing.JTextField();
        EmployeeName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        Mobile_Number = new javax.swing.JTextField();
        Back = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        EmployeeID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Search_using_EmployeeID = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        MobileNo = new javax.swing.JTextField();
        Search_using_MobileNo = new javax.swing.JButton();
        All_View = new javax.swing.JButton();
        PermanentAddress = new javax.swing.JTextField();
        Salary = new javax.swing.JTextField();
        Position = new javax.swing.JTextField();
        NID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Info_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EmployeeInfo.setBackground(new java.awt.Color(249, 245, 242));
        EmployeeInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Employee Name", "Gender", "Rank", "Salary"
            }
        ));
        EmployeeInfo.setToolTipText("");
        EmployeeInfo.setName(""); // NOI18N
        EmployeeInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeeInfoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(EmployeeInfo);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 640, 230));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Permanent Address");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Employee Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Contact Address");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Mobile Number");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Gender");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, -1, -1));

        Gender.setBackground(new java.awt.Color(249, 245, 242));
        Gender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select>>", "Male", "Female" }));
        getContentPane().add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 120, 31));

        PresentAddress.setBackground(new java.awt.Color(249, 245, 242));
        PresentAddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PresentAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PresentAddressActionPerformed(evt);
            }
        });
        getContentPane().add(PresentAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 310, 30));

        EmployeeName.setBackground(new java.awt.Color(249, 245, 242));
        EmployeeName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        EmployeeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeNameActionPerformed(evt);
            }
        });
        getContentPane().add(EmployeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 220, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Email ID");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 200, -1));

        Email.setBackground(new java.awt.Color(249, 245, 242));
        Email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, 200, 30));

        Mobile_Number.setBackground(new java.awt.Color(249, 245, 242));
        Mobile_Number.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Mobile_Number.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Mobile_NumberKeyTyped(evt);
            }
        });
        getContentPane().add(Mobile_Number, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 200, 30));

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
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, 110, 40));

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
        getContentPane().add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 630, 110, 40));

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
        getContentPane().add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 630, 110, 40));

        EmployeeID.setBackground(new java.awt.Color(249, 245, 242));
        EmployeeID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        EmployeeID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeeIDMouseClicked(evt);
            }
        });
        EmployeeID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EmployeeIDKeyTyped(evt);
            }
        });
        getContentPane().add(EmployeeID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 110, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Employee ID");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, 20));

        Search_using_EmployeeID.setBackground(new java.awt.Color(249, 245, 242));
        Search_using_EmployeeID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Search_using_EmployeeID.setText("Search");
        Search_using_EmployeeID.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Search_using_EmployeeIDMouseMoved(evt);
            }
        });
        Search_using_EmployeeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_using_EmployeeIDActionPerformed(evt);
            }
        });
        getContentPane().add(Search_using_EmployeeID, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 80, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Mobile Number");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 90, 20));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MobileNoKeyTyped(evt);
            }
        });
        getContentPane().add(MobileNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 150, 30));

        Search_using_MobileNo.setBackground(new java.awt.Color(249, 245, 242));
        Search_using_MobileNo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Search_using_MobileNo.setText("Search");
        Search_using_MobileNo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Search_using_MobileNoMouseMoved(evt);
            }
        });
        Search_using_MobileNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_using_MobileNoActionPerformed(evt);
            }
        });
        getContentPane().add(Search_using_MobileNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 80, 30));

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
        getContentPane().add(All_View, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 120, 30));

        PermanentAddress.setBackground(new java.awt.Color(249, 245, 242));
        PermanentAddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PermanentAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PermanentAddressActionPerformed(evt);
            }
        });
        getContentPane().add(PermanentAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, 320, 30));

        Salary.setBackground(new java.awt.Color(249, 245, 242));
        Salary.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalaryActionPerformed(evt);
            }
        });
        Salary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SalaryKeyTyped(evt);
            }
        });
        getContentPane().add(Salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 570, 100, 30));

        Position.setBackground(new java.awt.Color(249, 245, 242));
        Position.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PositionActionPerformed(evt);
            }
        });
        getContentPane().add(Position, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 570, 170, 30));

        NID.setBackground(new java.awt.Color(249, 245, 242));
        NID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        NID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NIDActionPerformed(evt);
            }
        });
        NID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NIDKeyTyped(evt);
            }
        });
        getContentPane().add(NID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 190, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Salary (Taka)");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 550, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Position");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 550, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("NID No.");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, -1, -1));

        jLabel16.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sewing.png"))); // NOI18N
        jLabel16.setText(" Employee Information ");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 80));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo2.png"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 10, -1, -1));

        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg.jpg"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmployeeInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeInfoMouseClicked
        
        int i = EmployeeInfo.getSelectedRow();
        TableModel model = EmployeeInfo.getModel();
        
        EmployeeID.setText((String) model.getValueAt(i, 0));
        
        try {
            Set_All_the_Data_through_EmployeeID(Integer.parseInt(EmployeeID.getText()));
        } catch (ClassNotFoundException ex) {}
        
    }//GEN-LAST:event_EmployeeInfoMouseClicked
    
    
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        
        new Information().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_BackActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        //Update in database
        if(EmployeeName.getText().isEmpty() || Mobile_Number.getText().isEmpty() || Email.getText().isEmpty() || PresentAddress.getText().isEmpty() || PermanentAddress.getText().isEmpty() || Gender.getSelectedItem().equals("<<Select>>") || NID.getText().isEmpty() || Position.getText().isEmpty() || Salary.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Enter the all the Information !");
        }
        else
        {
            Employee employee = new Employee();

            try {
                employee.update_the_Employee_info(Integer.parseInt(EmployeeID.getText()), EmployeeName.getText(), (String) Gender.getSelectedItem(), Mobile_Number.getText(), NID.getText(), Email.getText(), PresentAddress.getText(), PermanentAddress.getText(), Position.getText(), Integer.parseInt(Salary.getText()));
            } catch (ClassNotFoundException ex) {}
            
            All_View();
        }
        
    }//GEN-LAST:event_UpdateActionPerformed

    private void PresentAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PresentAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PresentAddressActionPerformed

    private void EmployeeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmployeeNameActionPerformed

    private void EmployeeIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeIDMouseClicked
        // TODO add your handling code here:
        All_View();
        Reset();
    }//GEN-LAST:event_EmployeeIDMouseClicked

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
        if(EmployeeName.getText().isEmpty() || Mobile_Number.getText().isEmpty() || Email.getText().isEmpty() || PresentAddress.getText().isEmpty() || PermanentAddress.getText().isEmpty() || Gender.getSelectedItem().equals("<<Select>>") || NID.getText().isEmpty() || Position.getText().isEmpty() || Salary.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Enter the all the Information !");
        }
        else
        {
            Employee employee = new Employee();

            try {
                employee.insert_into_Employee_list(EmployeeName.getText(), (String) Gender.getSelectedItem(), Mobile_Number.getText(), NID.getText(), Email.getText(), PresentAddress.getText(), PermanentAddress.getText(), Position.getText(), Integer.parseInt(Salary.getText()));
            } catch (ClassNotFoundException ex) {}
            
            All_View();
        }
    }//GEN-LAST:event_AddActionPerformed

    private void Search_using_EmployeeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_using_EmployeeIDActionPerformed
        
        if(EmployeeID.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Enter the Employee ID !"); 
        }else{
            try {
                Set_All_the_Data_through_EmployeeID(Integer.parseInt(EmployeeID.getText()));
            } catch (ClassNotFoundException ex) {} 
        }
        
    }//GEN-LAST:event_Search_using_EmployeeIDActionPerformed

    private void Search_using_MobileNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_using_MobileNoActionPerformed
        
        if(MobileNo.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Enter the mobile number !"); 
        }else{
            try {
                Set_All_the_Data_through_MobileNumber(MobileNo.getText());
            } catch (ClassNotFoundException ex) {} 
        }
        
    }//GEN-LAST:event_Search_using_MobileNoActionPerformed

    private void All_ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_All_ViewActionPerformed
        
        All_View();
        Reset();
        
    }//GEN-LAST:event_All_ViewActionPerformed

    private void SalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalaryActionPerformed

    private void PermanentAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PermanentAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PermanentAddressActionPerformed

    private void PositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PositionActionPerformed

    private void NIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NIDActionPerformed

    private void EmployeeIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmployeeIDKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_EmployeeIDKeyTyped

    private void MobileNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MobileNoKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_MobileNoKeyTyped

    private void Mobile_NumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Mobile_NumberKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_Mobile_NumberKeyTyped

    private void NIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NIDKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_NIDKeyTyped

    private void SalaryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalaryKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_SalaryKeyTyped

    private void All_ViewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseMoved
        All_View.setCursor(cursor);
    }//GEN-LAST:event_All_ViewMouseMoved

    private void Search_using_EmployeeIDMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search_using_EmployeeIDMouseMoved
        Search_using_EmployeeID.setCursor(cursor);
    }//GEN-LAST:event_Search_using_EmployeeIDMouseMoved

    private void Search_using_MobileNoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search_using_MobileNoMouseMoved
        Search_using_MobileNo.setCursor(cursor);
    }//GEN-LAST:event_Search_using_MobileNoMouseMoved

    private void BackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseMoved
        Back.setCursor(cursor);
    }//GEN-LAST:event_BackMouseMoved

    private void AddMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseMoved
        Add.setCursor(cursor);
    }//GEN-LAST:event_AddMouseMoved

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
                new Employee_Info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton All_View;
    private javax.swing.JButton Back;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField EmployeeID;
    private javax.swing.JTable EmployeeInfo;
    private javax.swing.JTextField EmployeeName;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JTextField MobileNo;
    private javax.swing.JTextField Mobile_Number;
    private javax.swing.JTextField NID;
    private javax.swing.JTextField PermanentAddress;
    private javax.swing.JTextField Position;
    private javax.swing.JTextField PresentAddress;
    private javax.swing.JTextField Salary;
    private javax.swing.JButton Search_using_EmployeeID;
    private javax.swing.JButton Search_using_MobileNo;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
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