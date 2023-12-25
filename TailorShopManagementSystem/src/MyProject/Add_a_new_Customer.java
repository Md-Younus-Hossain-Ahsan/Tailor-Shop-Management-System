package MyProject;

import JClasses.Customer;
import static MyProject.SignIN.cursor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public class Add_a_new_Customer extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    
    public Add_a_new_Customer() throws ClassNotFoundException {
        
        initComponents();  
        Customer customer = new Customer();
        customer.Last_ID_Search();
        CustomerID.setText(Integer.toString(customer.getCustomerID()));
                
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register_gender = new javax.swing.JComboBox<>();
        jpanelsignup = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        CustomerID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Address = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Gender = new javax.swing.JComboBox<>();
        MobileNo = new javax.swing.JTextField();
        Reset = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        Close = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        register_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male ", "Female" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpanelsignup.setBackground(new java.awt.Color(255, 255, 255));
        jpanelsignup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Customer ID");
        jpanelsignup.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 20));

        CustomerID.setEditable(false);
        CustomerID.setBackground(new java.awt.Color(249, 245, 242));
        CustomerID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jpanelsignup.add(CustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 233, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Customer Name");
        jpanelsignup.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        Name.setBackground(new java.awt.Color(249, 245, 242));
        Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NameMouseClicked(evt);
            }
        });
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        jpanelsignup.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 500, 31));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Gender");
        jpanelsignup.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 70, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Contact Address");
        jpanelsignup.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        Address.setBackground(new java.awt.Color(249, 245, 242));
        Address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressActionPerformed(evt);
            }
        });
        jpanelsignup.add(Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 233, 31));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Mobile number");
        jpanelsignup.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, 20));

        Gender.setBackground(new java.awt.Color(249, 245, 242));
        Gender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select>>", "Male", "Female" }));
        jpanelsignup.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 240, 31));

        MobileNo.setBackground(new java.awt.Color(249, 245, 242));
        MobileNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
        jpanelsignup.add(MobileNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 243, 31));

        Reset.setBackground(new java.awt.Color(249, 245, 242));
        Reset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Reset.setText("Reset");
        Reset.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ResetMouseMoved(evt);
            }
        });
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });
        jpanelsignup.add(Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 90, 37));

        Next.setBackground(new java.awt.Color(249, 245, 242));
        Next.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Next.setText("Next");
        Next.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                NextMouseMoved(evt);
            }
        });
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });
        jpanelsignup.add(Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 92, 39));

        Close.setBackground(new java.awt.Color(249, 245, 242));
        Close.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Close.setText("Close");
        Close.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CloseMouseMoved(evt);
            }
        });
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        jpanelsignup.add(Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 85, 37));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText(" *");
        jpanelsignup.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 230, 30, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");
        jpanelsignup.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText(" *");
        jpanelsignup.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 30, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");
        jpanelsignup.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 160, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo2.png"))); // NOI18N
        jpanelsignup.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        jLabel15.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sewing.png"))); // NOI18N
        jLabel15.setText(" Add a new Customer ");
        jpanelsignup.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 80));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin_Profile.jpg"))); // NOI18N
        jpanelsignup.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelsignup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelsignup, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MobileNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MobileNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MobileNoActionPerformed

    private void AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressActionPerformed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        
        if(Name.getText().trim().isEmpty() || Gender.getSelectedItem().equals("<<Select>>") || MobileNo.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Enter the all the Information !");
        }
        else
        {
            Customer customer = new Customer();
            
            try {
                customer.insert_into_Customer_list(Name.getText(), (String) Gender.getSelectedItem(), MobileNo.getText(), Address.getText());
                new New_Order(Integer.parseInt(CustomerID.getText())).setVisible(true);
                dispose();
            } catch (ClassNotFoundException ex) {}
        }
        
    }//GEN-LAST:event_NextActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        try {
            new New_Order().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Add_a_new_Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();        
    }//GEN-LAST:event_CloseActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        
        Gender.setSelectedIndex(0); 
        Name.setText("");
        Address.setText("");
        MobileNo.setText("01");
        
    }//GEN-LAST:event_ResetActionPerformed

    private void NameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NameMouseClicked

    private void MobileNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MobileNoKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_MobileNoKeyTyped

    private void CloseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseMoved
        Close.setCursor(cursor);
    }//GEN-LAST:event_CloseMouseMoved

    private void ResetMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetMouseMoved
        Reset.setCursor(cursor);
    }//GEN-LAST:event_ResetMouseMoved

    private void NextMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextMouseMoved
        Next.setCursor(cursor);
    }//GEN-LAST:event_NextMouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Add_a_new_Customer().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Add_a_new_Customer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address;
    private javax.swing.JButton Close;
    private javax.swing.JTextField CustomerID;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JTextField MobileNo;
    private javax.swing.JTextField Name;
    private javax.swing.JButton Next;
    private javax.swing.JButton Reset;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jpanelsignup;
    private javax.swing.JComboBox<String> register_gender;
    // End of variables declaration//GEN-END:variables
}
