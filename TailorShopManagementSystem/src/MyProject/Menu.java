package MyProject;

import static MyProject.SignIN.cursor;
import javax.swing.JOptionPane;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public class Menu extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    public Menu() {
        initComponents();  
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Information = new javax.swing.JButton();
        Orders_List = new javax.swing.JButton();
        Transaction = new javax.swing.JButton();
        Dress_Category = new javax.swing.JButton();
        Expense = new javax.swing.JButton();
        New_Order = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Menu_icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Information.setBackground(new java.awt.Color(249, 245, 242));
        Information.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Information.setText("Information Panel");
        Information.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Information.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                InformationMouseMoved(evt);
            }
        });
        Information.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InformationActionPerformed(evt);
            }
        });
        getContentPane().add(Information, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 410, 200, 45));

        Orders_List.setBackground(new java.awt.Color(249, 245, 242));
        Orders_List.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Orders_List.setText("Orders List");
        Orders_List.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Orders_List.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Orders_ListMouseMoved(evt);
            }
        });
        Orders_List.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Orders_ListActionPerformed(evt);
            }
        });
        getContentPane().add(Orders_List, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 170, 200, 45));

        Transaction.setBackground(new java.awt.Color(249, 245, 242));
        Transaction.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Transaction.setText("Transaction");
        Transaction.setToolTipText("");
        Transaction.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Transaction.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TransactionMouseMoved(evt);
            }
        });
        Transaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransactionActionPerformed(evt);
            }
        });
        getContentPane().add(Transaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 230, 200, 45));

        Dress_Category.setBackground(new java.awt.Color(249, 245, 242));
        Dress_Category.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Dress_Category.setText("Dress Category");
        Dress_Category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Dress_Category.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Dress_CategoryMouseMoved(evt);
            }
        });
        Dress_Category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dress_CategoryActionPerformed(evt);
            }
        });
        getContentPane().add(Dress_Category, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 350, 200, 45));

        Expense.setBackground(new java.awt.Color(249, 245, 242));
        Expense.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Expense.setText("Expense");
        Expense.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Expense.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ExpenseMouseMoved(evt);
            }
        });
        Expense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpenseActionPerformed(evt);
            }
        });
        getContentPane().add(Expense, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 290, 200, 45));

        New_Order.setBackground(new java.awt.Color(249, 245, 242));
        New_Order.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        New_Order.setText("New Order");
        New_Order.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        New_Order.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                New_OrderMouseMoved(evt);
            }
        });
        New_Order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                New_OrderActionPerformed(evt);
            }
        });
        getContentPane().add(New_Order, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 110, 200, 45));

        Exit.setBackground(new java.awt.Color(249, 245, 242));
        Exit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Exit.setText("Exit");
        Exit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Exit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ExitMouseMoved(evt);
            }
        });
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        getContentPane().add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 470, 200, 45));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sewing.png"))); // NOI18N
        jLabel5.setText(" Tailor Shop Management System ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 110));

        Menu_icon.setBackground(new java.awt.Color(255, 255, 255));
        Menu_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg.jpg"))); // NOI18N
        getContentPane().add(Menu_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Dress_CategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Dress_CategoryActionPerformed
        
        new Dress_Category().setVisible(true);
        
    }//GEN-LAST:event_Dress_CategoryActionPerformed

    private void ExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpenseActionPerformed
        
        new Expense().setVisible(true);
        
    }//GEN-LAST:event_ExpenseActionPerformed

    private void InformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InformationActionPerformed
        
        new Information().setVisible(true);
        
    }//GEN-LAST:event_InformationActionPerformed

    private void Orders_ListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Orders_ListActionPerformed
        new Pending_Orders().setVisible(true);
    }//GEN-LAST:event_Orders_ListActionPerformed

    private void TransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransactionActionPerformed
        new Transactions_Analysis().setVisible(true);
    }//GEN-LAST:event_TransactionActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        
        int result = JOptionPane.showConfirmDialog(this,"Do you want to close ?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                
        if(result == JOptionPane.YES_OPTION){
           
              System.exit(0);              
        }   
    }//GEN-LAST:event_ExitActionPerformed

    private void InformationMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InformationMouseMoved
        Information.setCursor(cursor);
    }//GEN-LAST:event_InformationMouseMoved

    private void New_OrderMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_New_OrderMouseMoved
        New_Order.setCursor(cursor);
    }//GEN-LAST:event_New_OrderMouseMoved

    private void New_OrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_New_OrderActionPerformed
        
        try {
            new New_Order().setVisible(true);
        } catch (ClassNotFoundException ex) {}
        
    }//GEN-LAST:event_New_OrderActionPerformed

    private void Orders_ListMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Orders_ListMouseMoved
        Orders_List.setCursor(cursor);
    }//GEN-LAST:event_Orders_ListMouseMoved

    private void TransactionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionMouseMoved
        Transaction.setCursor(cursor);
    }//GEN-LAST:event_TransactionMouseMoved

    private void ExpenseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpenseMouseMoved
        Expense.setCursor(cursor);
    }//GEN-LAST:event_ExpenseMouseMoved

    private void Dress_CategoryMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Dress_CategoryMouseMoved
        Dress_Category.setCursor(cursor);
    }//GEN-LAST:event_Dress_CategoryMouseMoved

    private void ExitMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseMoved
        Exit.setCursor(cursor);
    }//GEN-LAST:event_ExitMouseMoved

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Dress_Category;
    private javax.swing.JButton Exit;
    private javax.swing.JButton Expense;
    private javax.swing.JButton Information;
    private javax.swing.JLabel Menu_icon;
    private javax.swing.JButton New_Order;
    private javax.swing.JButton Orders_List;
    private javax.swing.JButton Transaction;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
