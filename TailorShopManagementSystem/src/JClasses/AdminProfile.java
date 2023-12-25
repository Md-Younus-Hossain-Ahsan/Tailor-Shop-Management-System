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

public class AdminProfile {
    
    int UserID = 100001;
    String UserName;
    String Email;
    String Password;
    
    
    public void searching_all_the_information() throws ClassNotFoundException{
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "Select * from User where UserID = ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, 100001);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                UserName = rs.getString("UserName");
                Email = rs.getString("Email");
                Password = rs.getString("Password");
            }            
            
        }catch(SQLException e){}
        
    } 

    
    
    public void update_the_admin_info(String UserName, String Email, String Password) throws ClassNotFoundException{
                
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "update User set UserName = '"+ UserName +"', Email = '"+ Email +"', Password = '"+ Password +"' where UserID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, 100001);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Updated !"); 

        }catch(SQLException e){}
            
    }

    
    public int getUserID() {
        return UserID;
    }

    public String getUserName() {
        return UserName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }
    
}
