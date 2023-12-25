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

public class Customer {
    
    int CustomerID;
    String Name;
    String Gender;
    String MobileNumber;
    String Address;
    
    
    public void Last_ID_Search() throws ClassNotFoundException{
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "Select * from Customer";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            CustomerID = 1000;
            while(rs.next())
            {
                CustomerID = rs.getInt("CustomerID");
            }   
            CustomerID++;
            
        }catch(SQLException e){}
        
    } 

    
    public void searching_all_the_information_through_CustomerID(int CustomerID) throws ClassNotFoundException{
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "Select * from Customer where CustomerID = '"+ CustomerID +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                Name = rs.getString("Name");
                Gender = rs.getString("Gender");
                MobileNumber = rs.getString("MobileNumber");
                Address = rs.getString("Address");
            }            
            
        }catch(SQLException e){}
        
    } 

    
    public void searching_all_the_information_through_MobileNumber(String MobileNumber) throws ClassNotFoundException{
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "Select * from Customer where MobileNumber = '"+ MobileNumber +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                CustomerID = rs.getInt("CustomerID");
                Name = rs.getString("Name");
                Gender = rs.getString("Gender");
                Address = rs.getString("Address");
            }            
            
        }catch(SQLException e){}
        
    } 

    
    public void insert_into_Customer_list(String Name, String Gender, String MobileNumber, String Address) throws ClassNotFoundException{
                
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "insert into Customer(Name, Gender, MobileNumber, Address) values (?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, Name);
            pst.setString(2, Gender);
            pst.setString(3, MobileNumber);
            pst.setString(4, Address);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Added !"); 

        }catch(SQLException e){JOptionPane.showMessageDialog(null, "Not found !"); }
            
    }

    
    public void update_the_Customer_info(int CustomerID, String Name, String Gender, String MobileNumber, String Address) throws ClassNotFoundException{
                
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "update Customer set Name = '"+ Name +"', Gender = '"+ Gender +"', MobileNumber = '"+ MobileNumber +"', Address = '"+ Address +"' where CustomerID = '"+ CustomerID +"'";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Updated !"); 

        }catch(SQLException e){}
            
    }   

    public int getCustomerID() {
        return CustomerID;
    }

    public String getName() {
        return Name;
    }

    public String getGender() {
        return Gender;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public String getAddress() {
        return Address;
    }    
    
}
