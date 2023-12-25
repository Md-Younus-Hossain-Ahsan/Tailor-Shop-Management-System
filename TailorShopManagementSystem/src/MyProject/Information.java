package MyProject;

import static MyProject.SignIN.cursor;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public class Information extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

        
    public Information() {
        initComponents();       
        
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Employee_Info = new javax.swing.JButton();
        Customer_Info = new javax.swing.JButton();
        Admin_Profile = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Menu_icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Employee_Info.setBackground(new java.awt.Color(249, 245, 242));
        Employee_Info.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Employee_Info.setText("Employee Information");
        Employee_Info.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Employee_Info.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Employee_InfoMouseMoved(evt);
            }
        });
        Employee_Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Employee_InfoActionPerformed(evt);
            }
        });
        getContentPane().add(Employee_Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 200, 45));

        Customer_Info.setBackground(new java.awt.Color(249, 245, 242));
        Customer_Info.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Customer_Info.setText("Customer Information");
        Customer_Info.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Customer_Info.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Customer_InfoMouseMoved(evt);
            }
        });
        Customer_Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Customer_InfoActionPerformed(evt);
            }
        });
        getContentPane().add(Customer_Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 200, 45));

        Admin_Profile.setBackground(new java.awt.Color(249, 245, 242));
        Admin_Profile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Admin_Profile.setText("Admin Profile");
        Admin_Profile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Admin_Profile.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Admin_ProfileMouseMoved(evt);
            }
        });
        Admin_Profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Admin_ProfileActionPerformed(evt);
            }
        });
        getContentPane().add(Admin_Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 200, 45));

        Back.setBackground(new java.awt.Color(249, 245, 242));
        Back.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Back.setText("Back");
        Back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 200, 45));

        jLabel5.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sewing.png"))); // NOI18N
        jLabel5.setText(" Information Panel ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 110));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo3.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, 120));

        Menu_icon.setBackground(new java.awt.Color(255, 255, 255));
        Menu_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg.jpg"))); // NOI18N
        getContentPane().add(Menu_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Admin_ProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Admin_ProfileActionPerformed
        try {
            new Admin_Profile().setVisible(true);
        } catch (ClassNotFoundException ex) {}
        dispose();
    }//GEN-LAST:event_Admin_ProfileActionPerformed

    private void Customer_InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Customer_InfoActionPerformed
        new Customer_Info().setVisible(true);
        dispose();
    }//GEN-LAST:event_Customer_InfoActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void Customer_InfoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Customer_InfoMouseMoved
        Customer_Info.setCursor(cursor);
    }//GEN-LAST:event_Customer_InfoMouseMoved

    private void Employee_InfoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Employee_InfoMouseMoved
        Employee_Info.setCursor(cursor);
    }//GEN-LAST:event_Employee_InfoMouseMoved

    private void Employee_InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Employee_InfoActionPerformed
        new Employee_Info().setVisible(true);
        dispose();
    }//GEN-LAST:event_Employee_InfoActionPerformed

    private void Admin_ProfileMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Admin_ProfileMouseMoved
        Admin_Profile.setCursor(cursor);
    }//GEN-LAST:event_Admin_ProfileMouseMoved

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Information().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Admin_Profile;
    private javax.swing.JButton Back;
    private javax.swing.JButton Customer_Info;
    private javax.swing.JButton Employee_Info;
    private javax.swing.JLabel Menu_icon;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
