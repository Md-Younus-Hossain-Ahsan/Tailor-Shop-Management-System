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

public class Measurements {
    
    float Neck;
    float Chest;
    float Height;
    float Wrist;
    float Hip;
    
    
    public void searching_all_the_information(int OrderID) throws ClassNotFoundException{
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "Select * from Measurements where OrderID = '"+ OrderID +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                Neck = rs.getFloat("Neck");
                Chest = rs.getFloat("Chest");
                Height = rs.getFloat("Height");
                Wrist = rs.getFloat("Wrist");
                Hip = rs.getFloat("Hip");
            }  
            
        }catch(SQLException e){}
        
    } 

    
    public void insert_into_Measurement_list(int OrderID, float Neck, float Chest, float Height, float Wrist, float Hip) throws ClassNotFoundException{
                
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "insert into Measurements(OrderID, Neck, Chest, Height, Wrist, Hip) values (?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, OrderID);
            pst.setFloat(2, Neck);
            pst.setFloat(3, Chest);
            pst.setFloat(4, Height);
            pst.setFloat(5, Wrist);
            pst.setFloat(6, Hip);
            
            pst.executeUpdate();

        }catch(SQLException e){JOptionPane.showMessageDialog(null, "Not found !"); }
            
    } 

    
    public void update_the_Measurement_list(int OrderID, float Neck, float Chest, float Height, float Wrist, float Hip) throws ClassNotFoundException {
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "update Measurements SET Neck=?, Chest=?, Height=?, Wrist=?, Hip=? WHERE OrderID=?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setFloat(1, Neck);
            pst.setFloat(2, Chest);
            pst.setFloat(3, Height);
            pst.setFloat(4, Wrist);
            pst.setFloat(5, Hip);
            pst.setInt(6, OrderID);

            pst.executeUpdate();

        } catch (SQLException e) {}
    }

    public float getNeck() {
        return Neck;
    }

    public float getChest() {
        return Chest;
    }

    public float getHeight() {
        return Height;
    }

    public float getWrist() {
        return Wrist;
    }

    public float getHip() {
        return Hip;
    }
    
}
