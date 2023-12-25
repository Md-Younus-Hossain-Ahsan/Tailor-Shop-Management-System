package MyProject;

import JClasses.AdminProfile;
import JClasses.VericationCodeSend;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.Cursor;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public final class SignIN extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    public static String url="jdbc:sqlserver://localhost:1433;databaseName=TailorShopManagementSystem;user=sa;password=p@ssword13";
    public static Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    
    public static String EmailID = "";
    public static String EmailPassword = "";
    String UserName = "";
    String UserPassword = "";
    
    
    public SignIN() throws ClassNotFoundException {
        
        initComponents();
        EmailID = SE.getText();
        EmailPassword = SEP.getText();  
        Set_all_the_information_of_User();
        
    }
    
    
    public void Set_all_the_information_of_User() throws ClassNotFoundException
    {
       
        AdminProfile admin = new AdminProfile();
        
        admin.searching_all_the_information();
        
        UserName = admin.getUserName();
        admin.getEmail();
        UserPassword = admin.getPassword();
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        SE = new javax.swing.JLabel();
        SEP = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        User_Name = new javax.swing.JTextField();
        Sign_IN = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ShowPassword = new javax.swing.JCheckBox();
        Forgot = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane2.setViewportView(jTextPane1);

        SE.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        SE.setForeground(new java.awt.Color(255, 255, 255));
        SE.setText("email ID");

        SEP.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        SEP.setForeground(new java.awt.Color(255, 255, 255));
        SEP.setText("p@ssword");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 1, 28)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Welcome to the Tailor Management System");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 660, 56));

        Password.setBackground(new java.awt.Color(249, 245, 242));
        Password.setFont(new java.awt.Font("DejaVu Serif", 0, 14)); // NOI18N
        Password.setText("Password");
        Password.setBorder(null);
        Password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PasswordFocusGained(evt);
            }
        });
        Password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PasswordMouseClicked(evt);
            }
        });
        jPanel1.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 200, 35));

        jSeparator2.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 260, 200, 10));

        User_Name.setBackground(new java.awt.Color(249, 245, 242));
        User_Name.setFont(new java.awt.Font("DejaVu Serif", 0, 14)); // NOI18N
        User_Name.setText("User Name");
        User_Name.setBorder(null);
        User_Name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                User_NameFocusGained(evt);
            }
        });
        User_Name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                User_NameMouseClicked(evt);
            }
        });
        User_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_NameActionPerformed(evt);
            }
        });
        jPanel1.add(User_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 200, 34));

        Sign_IN.setBackground(new java.awt.Color(249, 245, 242));
        Sign_IN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Sign_IN.setText("Sign IN");
        Sign_IN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Sign_IN.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Sign_INMouseMoved(evt);
            }
        });
        Sign_IN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sign_INActionPerformed(evt);
            }
        });
        jPanel1.add(Sign_IN, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 90, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 200, 200, 6));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo1.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/username.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, 34));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/password.jpg"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, 35));

        ShowPassword.setBackground(new java.awt.Color(249, 245, 242));
        ShowPassword.setText("Show Password");
        ShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(ShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 141, -1));

        Forgot.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Forgot.setForeground(new java.awt.Color(204, 0, 0));
        Forgot.setText("Do you forget your password ?");
        Forgot.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ForgotMouseMoved(evt);
            }
        });
        Forgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ForgotMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ForgotMousePressed(evt);
            }
        });
        jPanel1.add(Forgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SignIN.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFocusGained

    }//GEN-LAST:event_PasswordFocusGained

    private void PasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordMouseClicked
        Password.setText("");
    }//GEN-LAST:event_PasswordMouseClicked

    private void User_NameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_User_NameFocusGained

    }//GEN-LAST:event_User_NameFocusGained

    private void User_NameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_User_NameMouseClicked
        User_Name.setText("");
    }//GEN-LAST:event_User_NameMouseClicked

    private void User_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_User_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_User_NameActionPerformed

    private void ShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPasswordActionPerformed
        
        if(ShowPassword.isSelected())
        {
            Password.setEchoChar((char) 0);
        }else{
            Password.setEchoChar('*');
        }
        
    }//GEN-LAST:event_ShowPasswordActionPerformed

    private void Sign_INActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sign_INActionPerformed
        
        if(User_Name.getText().trim().isEmpty() || User_Name.getText().equals("User Name") || Password.getText().trim().isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "Enter the UserName and Password properly !");
        }
        else if(!User_Name.getText().equals(UserName) || !Password.getText().equals(UserPassword))
        {
            JOptionPane.showMessageDialog(null, "Not matched !");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Successfully done !");
            new Menu().setVisible(true);
            dispose();            
        }  
        
    }//GEN-LAST:event_Sign_INActionPerformed

    private void ForgotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ForgotMouseClicked

        Forgot.setForeground(new Color(51,51,51));
        VericationCodeSend verification = new VericationCodeSend();
        verification.Set();
        verification.Code_Generate();
        verification.Find_Recipient();
        
        try {
            verification.Code_Send();
        } catch (UnsupportedEncodingException ex) {
        }
        
        new Verify("Sign IN").setVisible(true);
        dispose();
        
    }//GEN-LAST:event_ForgotMouseClicked

    private void ForgotMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ForgotMouseMoved
        Forgot.setCursor(cursor);
    }//GEN-LAST:event_ForgotMouseMoved

    private void Sign_INMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sign_INMouseMoved
        Sign_IN.setCursor(cursor);
    }//GEN-LAST:event_Sign_INMouseMoved

    private void ForgotMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ForgotMousePressed
        Forgot.setForeground(new Color(51,51,51));
    }//GEN-LAST:event_ForgotMousePressed

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SignIN().setVisible(true);
                } catch (ClassNotFoundException ex) {}
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Forgot;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel SE;
    private javax.swing.JLabel SEP;
    private javax.swing.JCheckBox ShowPassword;
    private javax.swing.JButton Sign_IN;
    private javax.swing.JTextField User_Name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
