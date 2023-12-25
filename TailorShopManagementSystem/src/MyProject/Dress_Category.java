package MyProject;

import JClasses.DressCategory;
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

public final class Dress_Category extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    int SelectedID = 0;    
    
    
    public Dress_Category() {
        
        initComponents();        
        All_View();
    }
    
    public void All_View(){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "Select * from Dress_Category";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            Dress_Category.setModel(new DefaultTableModel(null, new String[] {"Dress ID","Name","Gender","Preparing Cost"}));
            
            while(rs.next())
            {
                String tbData[] = {Integer.toString(rs.getInt("DressID")),
                                   rs.getString("Name"),
                                   rs.getString("Gender"),
                                   Integer.toString(rs.getInt("PreparingCost"))};
                DefaultTableModel tbModel = (DefaultTableModel) Dress_Category.getModel();
                tbModel.addRow(tbData);
            }
            
            DressName.setText(null);
            Gender.setSelectedIndex(0); 
            PreparingCost.setText(null);
            
            
        }catch(SQLException e){
        
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dress_Category.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        Dress_Category = new javax.swing.JTable();
        Back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PreparingCost = new javax.swing.JTextField();
        DressName = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        All_View = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Gender = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Info_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dress_Category.setBackground(new java.awt.Color(249, 245, 242));
        Dress_Category.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Dress_Category.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dress ID", "Dress Name", "Gender", "Preparing Cost"
            }
        ));
        Dress_Category.setToolTipText("");
        Dress_Category.setName(""); // NOI18N
        Dress_Category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Dress_CategoryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Dress_Category);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 640, 280));

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
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 110, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Preparing Cost (with all expenses)");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Gender");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        PreparingCost.setBackground(new java.awt.Color(249, 245, 242));
        PreparingCost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PreparingCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PreparingCostKeyTyped(evt);
            }
        });
        getContentPane().add(PreparingCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 190, 30));

        DressName.setBackground(new java.awt.Color(249, 245, 242));
        DressName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(DressName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 200, 30));

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
        getContentPane().add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 480, 110, 40));

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
        getContentPane().add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, 110, 40));

        All_View.setBackground(new java.awt.Color(249, 245, 242));
        All_View.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
        getContentPane().add(All_View, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 110, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Dress Name");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 10, -1, -1));

        Gender.setBackground(new java.awt.Color(249, 245, 242));
        Gender.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All types", "Male", "Female" }));
        getContentPane().add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 170, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText(" /=");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 40, 30));

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sewing.png"))); // NOI18N
        jLabel2.setText(" Dress Category ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 80));

        Info_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg.jpg"))); // NOI18N
        getContentPane().add(Info_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Dress_CategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Dress_CategoryMouseClicked
        
        int i = Dress_Category.getSelectedRow();
        TableModel model = Dress_Category.getModel();
        
        SelectedID = Integer.parseInt((String) model.getValueAt(i, 0));
        DressName.setText((String) model.getValueAt(i, 1));
        Gender.setSelectedItem((String) model.getValueAt(i, 2));
        PreparingCost.setText((String) model.getValueAt(i, 3));
        
    }//GEN-LAST:event_Dress_CategoryMouseClicked
    
    
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        //Add to database
        if(DressName.getText().isEmpty() || PreparingCost.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Enter the all the Information !");
        }
        else
        {
            DressCategory dressCategory = new DressCategory();
            
            try {
                
                dressCategory.insert_into_Dress_Category(DressName.getText(), (String) Gender.getSelectedItem(), Integer.parseInt(PreparingCost.getText()));
            
            } catch (ClassNotFoundException ex) {}

            All_View();   
        }
    }//GEN-LAST:event_AddActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        //Update in database
        if(DressName.getText().isEmpty() || PreparingCost.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Enter the all the Information !");
        }
        else
        {
            DressCategory dressCategory = new DressCategory();
                        
            try {
                
                dressCategory.update_the_Dress_Category(SelectedID, DressName.getText(), (String) Gender.getSelectedItem(), Integer.parseInt(PreparingCost.getText()));
            
            } catch (ClassNotFoundException ex) {}                

            All_View();   
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void PreparingCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PreparingCostKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_PreparingCostKeyTyped

    private void All_ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_All_ViewActionPerformed
        All_View();   
    }//GEN-LAST:event_All_ViewActionPerformed

    private void BackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseMoved
        Back.setCursor(cursor);
    }//GEN-LAST:event_BackMouseMoved

    private void All_ViewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_All_ViewMouseMoved
        All_View.setCursor(cursor);
    }//GEN-LAST:event_All_ViewMouseMoved

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
                new Dress_Category().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton All_View;
    private javax.swing.JButton Back;
    private javax.swing.JTextField DressName;
    private javax.swing.JTable Dress_Category;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JLabel Info_Icon;
    private javax.swing.JTextField PreparingCost;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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