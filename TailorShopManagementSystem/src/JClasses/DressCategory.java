/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JClasses;

import static MyProject.SignIN.url;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public class DressCategory {
    
    String Name;
    int PreparingCost;
    
    public void searching_all_the_information(int DressID) throws ClassNotFoundException{
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "Select * from Dress_Category where DressID = '"+ DressID +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                Name = rs.getString("Name");
                PreparingCost = rs.getInt("PreparingCost");
            }            
            
        }catch(SQLException e){}
        
    }

    
    public void insert_into_Dress_Category(String DressName, String Gender, int PreparingCost) throws ClassNotFoundException{
                
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "insert into Dress_Category(Name, Gender, PreparingCost) values (?,?,?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, DressName);
            pst.setString(2, Gender);
            pst.setInt(3, PreparingCost);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Added !"); 

        }catch(SQLException e){JOptionPane.showMessageDialog(null, "Not found !"); }
            
    }

    
    public void update_the_Dress_Category(int DressID, String DressName, String Gender, int PreparingCost) throws ClassNotFoundException{
                
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "update Dress_Category set Name = '"+ DressName +"', Gender = '"+ Gender +"', PreparingCost = '"+ PreparingCost +"' where DressID = '"+ DressID +"'";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Updated !"); 

        }catch(SQLException e){}
            
    }

    public String getName() {
        return Name;
    }

    public int getPreparingCost() {
        return PreparingCost;
    }
    
}
