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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public class Expenses {
    
    String Description;
    int Total_Expenses_Amount;
    
    
    public void all_expenses_amount_calculation(){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select SUM(Amount) AS Total_Expenses from Expenses";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Expenses_Amount = res.getInt("Total_Expenses");
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }
    
    
    public void all_transactions_amount_calculation_between_two_Dates(Date Date1, Date Date2){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select SUM(Amount) AS Total_Expenses from Expenses where Cost_date BETWEEN ? and ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, new java.sql.Date(Date1.getTime()));
            pst.setDate(2, new java.sql.Date(Date2.getTime()));
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Expenses_Amount = res.getInt("Total_Expenses");
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }

    
    public void description_from_SI_no(int ExpID){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select * from Expenses where ExpID = '"+ ExpID +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Description = res.getString("Description");
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }  
    
    
    public void insert_into_Expense_list(String Issue, int Amount, String Description) throws ClassNotFoundException{
                
        try{
            LocalDateTime orderDate = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(orderDate);
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "insert into Expenses(Issue, Amount, Description, Cost_date) values (?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, Issue);
            pst.setInt(2, Amount);
            pst.setString(3, Description);
            pst.setTimestamp(4, timestamp);
               
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Added !"); 

        }catch(SQLException e){JOptionPane.showMessageDialog(null, "Not found !"); }
            
    }

    
    public void update_the_Expense_info(int ExpID, String Issue, int Amount, String Description) throws ClassNotFoundException{
                
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "update Expenses set Issue = '"+ Issue +"', Amount = '"+ Amount +"', Description = '"+ Description +"' where ExpID = '"+ ExpID +"'";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Updated !"); 

        }catch(SQLException e){}
            
    }

    public int getTotal_Expenses_Amount() {
        return Total_Expenses_Amount;
    }

    public String getDescription() {
        return Description;
    }
    
}
