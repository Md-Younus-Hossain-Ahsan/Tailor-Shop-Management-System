package MyProject;

import JClasses.AdminProfile;
import javax.swing.JOptionPane;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public final class Admin_Profile extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
   
    
    public Admin_Profile() throws ClassNotFoundException {
        
        initComponents(); 
        Set_all_the_information_of_User();
        
    }
    
    
    public void Set_all_the_information_of_User() throws ClassNotFoundException
    {
       
        AdminProfile admin = new AdminProfile();
        
        admin.searching_all_the_information();
        
        UserID.setText(Integer.toString(admin.getUserID()));
        UserName.setText(admin.getUserName());
        Email.setText(admin.getEmail());
        Password.setText(admin.getPassword());
        
    }
    
    
    public void Reset(){
        
        UserName.setText(null); 
        Email.setText("");
        Password.setText("");
        ConfirmationPassword.setText("");
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register_gender = new javax.swing.JComboBox<>();
        jpanelsignup = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        UserName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        UserID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Update = new javax.swing.JButton();
        close = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        ShowPassword = new javax.swing.JCheckBox();
        ShowConPassword = new javax.swing.JCheckBox();
        Password = new javax.swing.JPasswordField();
        ConfirmationPassword = new javax.swing.JPasswordField();
        jLabel28 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        SE = new javax.swing.JLabel();
        SEP = new javax.swing.JLabel();

        register_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male ", "Female" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpanelsignup.setBackground(new java.awt.Color(255, 255, 255));
        jpanelsignup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo2.png"))); // NOI18N
        jpanelsignup.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 15, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Username");
        jpanelsignup.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        UserName.setBackground(new java.awt.Color(249, 245, 242));
        UserName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserNameActionPerformed(evt);
            }
        });
        jpanelsignup.add(UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 240, 31));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Email Address");
        jpanelsignup.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        Email.setBackground(new java.awt.Color(249, 245, 242));
        Email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        jpanelsignup.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 500, 31));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("UserID");
        jpanelsignup.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        UserID.setEditable(false);
        UserID.setBackground(new java.awt.Color(249, 245, 242));
        UserID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserIDActionPerformed(evt);
            }
        });
        jpanelsignup.add(UserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 240, 31));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Password");
        jpanelsignup.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Confimation Password");
        jpanelsignup.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, -1));

        Update.setBackground(new java.awt.Color(249, 245, 242));
        Update.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jpanelsignup.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 90, 40));

        close.setBackground(new java.awt.Color(249, 245, 242));
        close.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        jpanelsignup.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 92, 39));

        reset.setBackground(new java.awt.Color(249, 245, 242));
        reset.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jpanelsignup.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 85, 40));

        ShowPassword.setBackground(new java.awt.Color(249, 245, 242));
        ShowPassword.setText("Show Password");
        ShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPasswordActionPerformed(evt);
            }
        });
        jpanelsignup.add(ShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 167, -1));

        ShowConPassword.setBackground(new java.awt.Color(249, 245, 242));
        ShowConPassword.setText("Show Confirmation Password");
        ShowConPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowConPasswordActionPerformed(evt);
            }
        });
        jpanelsignup.add(ShowConPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));

        Password.setBackground(new java.awt.Color(249, 245, 242));
        Password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });
        jpanelsignup.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 240, 31));

        ConfirmationPassword.setBackground(new java.awt.Color(249, 245, 242));
        ConfirmationPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jpanelsignup.add(ConfirmationPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 240, 31));

        jLabel28.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sewing.png"))); // NOI18N
        jLabel28.setText(" Admin Profile ");
        jpanelsignup.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 80));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin_Profile.jpg"))); // NOI18N
        jpanelsignup.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 370));

        SE.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        SE.setForeground(new java.awt.Color(255, 255, 255));
        SE.setText("younushossainahsan@gmail.com");
        jpanelsignup.add(SE, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, -1));

        SEP.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        SEP.setForeground(new java.awt.Color(255, 255, 255));
        SEP.setText("AhSaN131");
        jpanelsignup.add(SEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelsignup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelsignup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void ShowConPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowConPasswordActionPerformed
        
        if(ShowConPassword.isSelected())
        {
            ConfirmationPassword.setEchoChar((char) 0);
        }else{
            ConfirmationPassword.setEchoChar('*');
        }
        
    }//GEN-LAST:event_ShowConPasswordActionPerformed

    private void ShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPasswordActionPerformed
        
        if(ShowPassword.isSelected())
        {
            Password.setEchoChar((char) 0);
        }else{
            Password.setEchoChar('*');
        }
        
    }//GEN-LAST:event_ShowPasswordActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        Reset();
    }//GEN-LAST:event_resetActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        dispose();
    }//GEN-LAST:event_closeActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        
        if(UserName.getText().isEmpty() || Email.getText().isEmpty() || Password.getText().isEmpty() || ConfirmationPassword.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please enter all the information !!!"); 
            
        }else if(!Password.getText().equals(ConfirmationPassword.getText()))
        {
            JOptionPane.showMessageDialog(null, "Password and Confirmation Password must be same !!!"); 
            
        }else{
            
            AdminProfile admin = new AdminProfile();
            
            try {
                admin.update_the_admin_info(UserName.getText(), Email.getText(), Password.getText());
            } catch (ClassNotFoundException ex) {} 
            
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void UserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserNameActionPerformed

    private void UserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserIDActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Admin_Profile().setVisible(true);
                } catch (ClassNotFoundException ex) {}
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ConfirmationPassword;
    private javax.swing.JTextField Email;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel SE;
    private javax.swing.JLabel SEP;
    private javax.swing.JCheckBox ShowConPassword;
    private javax.swing.JCheckBox ShowPassword;
    private javax.swing.JButton Update;
    private javax.swing.JTextField UserID;
    private javax.swing.JTextField UserName;
    private javax.swing.JButton close;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jpanelsignup;
    private javax.swing.JComboBox<String> register_gender;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables
}
