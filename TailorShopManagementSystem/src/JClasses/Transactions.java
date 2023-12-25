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
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Md. Younus Hossain Ahsan
 */

public class Transactions {
    
    int Total_Earnings_Amount;
    int Total_Amount;
    int Total_Paid_Amount;
    int Total_Rest_Amount;

    
    public void all_transactions_amount_calculation(){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select SUM(Amount) AS Total_Earnings from Transactions";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Earnings_Amount = res.getInt("Total_Earnings");
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }
    
    
    public void all_transactions_amount_calculation_between_two_Dates(Date Date1, Date Date2){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select SUM(Amount) AS Total_Earnings, Date from Transactions where Date BETWEEN ? and ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, new java.sql.Date(Date1.getTime()));
            pst.setDate(2, new java.sql.Date(Date2.getTime()));
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Earnings_Amount = res.getInt("Total_Earnings");
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }

    
    public void all_transaction_analysis(){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select SUM(Total_cost) AS Total_Amount, SUM(Rest_amount) AS Total_Rest_Amount from Orders";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Amount = res.getInt("Total_Amount");
                Total_Rest_Amount = res.getInt("Total_Rest_Amount");
            }
            Total_Paid_Amount = Total_Amount - Total_Rest_Amount;
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }

    
    public void all_transaction_analysis(String OrderType){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select SUM(Total_cost) AS Total_Amount, SUM(Rest_amount) AS Total_Rest_Amount from Orders where OrderType = '"+ OrderType +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Amount = res.getInt("Total_Amount");
                Total_Rest_Amount = res.getInt("Total_Rest_Amount");
            }
            Total_Paid_Amount = Total_Amount - Total_Rest_Amount;
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }

    
    public void all_transaction_analysis_between_two_Dates(Date Date1, Date Date2, String OrderType){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select SUM(Total_cost) AS Total_Amount, SUM(Rest_amount) AS Total_Rest_Amount from Orders where OrderDate BETWEEN ? and ? and OrderType = '"+ OrderType +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, new java.sql.Date(Date1.getTime()));
            pst.setDate(2, new java.sql.Date(Date2.getTime()));
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Amount = res.getInt("Total_Amount");
                Total_Rest_Amount = res.getInt("Total_Rest_Amount");
            }
            Total_Paid_Amount = Total_Amount - Total_Rest_Amount;
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }

    
    public void all_transaction_analysis_between_two_Dates(int CustomerID, Date Date1, Date Date2){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select SUM(Total_cost) AS Total_Amount, SUM(Rest_amount) AS Total_Rest_Amount from Orders where CustomerID = '"+ CustomerID +"' and OrderDate BETWEEN ? and ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, new java.sql.Date(Date1.getTime()));
            pst.setDate(2, new java.sql.Date(Date2.getTime()));
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Amount = res.getInt("Total_Amount");
                Total_Rest_Amount = res.getInt("Total_Rest_Amount");
            }
            Total_Paid_Amount = Total_Amount - Total_Rest_Amount;
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }

    
    public void all_transaction_analysis_through_CustomerID(int CustomerID){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select SUM(Total_cost) AS Total_Amount, SUM(Rest_amount) AS Total_Rest_Amount from Orders where CustomerID = '"+ CustomerID +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Amount = res.getInt("Total_Amount");
                Total_Rest_Amount = res.getInt("Total_Rest_Amount");
            }
            Total_Paid_Amount = Total_Amount - Total_Rest_Amount;
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }

    
    public void all_transaction_analysis_through_CustomerID(int CustomerID, String OrderType){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select SUM(Total_cost) AS Total_Amount, SUM(Rest_amount) AS Total_Rest_Amount from Orders where CustomerID = '"+ CustomerID +"' and OrderType = '"+ OrderType +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Amount = res.getInt("Total_Amount");
                Total_Rest_Amount = res.getInt("Total_Rest_Amount");
            }
            Total_Paid_Amount = Total_Amount - Total_Rest_Amount;
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }

    
    public void all_transaction_analysis_through_MobileNumber(String MobileNumber){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select SUM(o.Total_cost) AS Total_Amount, SUM(o.Rest_amount) AS Total_Rest_Amount from Customer c JOIN Orders o ON c.CustomerID = o.CustomerID where c.MobileNumber = '"+ MobileNumber +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Amount = res.getInt("Total_Amount");
                Total_Rest_Amount = res.getInt("Total_Rest_Amount");
            }
            Total_Paid_Amount = Total_Amount - Total_Rest_Amount;
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }

    
    public void all_transaction_analysis_through_MobileNumber(String MobileNumber, String OrderType){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select SUM(o.Total_cost) AS Total_Amount, SUM(o.Rest_amount) AS Total_Rest_Amount from Customer c JOIN Orders o ON c.CustomerID = o.CustomerID where c.MobileNumber = '"+ MobileNumber +"' and o.OrderType = '"+ OrderType +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Amount = res.getInt("Total_Amount");
                Total_Rest_Amount = res.getInt("Total_Rest_Amount");
            }
            Total_Paid_Amount = Total_Amount - Total_Rest_Amount;
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }

    
    public void insert_into_Transaction_list(int OrderID, int Amount) throws ClassNotFoundException, ParseException{
                
        try{
            LocalDateTime transactionDate = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(transactionDate);
                    
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "insert into Transactions(OrderID, Date, Amount) values (?,?,?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, OrderID);
            pst.setTimestamp(2, timestamp);
            pst.setInt(3, Amount);
            
            pst.executeUpdate();

        }catch(SQLException e){JOptionPane.showMessageDialog(null, "Not found !"); }
            
    }

    public int getTotal_Earnings_Amount() {
        return Total_Earnings_Amount;
    }

    public int getTotal_Amount() {
        return Total_Amount;
    }

    public int getTotal_Paid_Amount() {
        return Total_Paid_Amount;
    }

    public int getTotal_Rest_Amount() {
        return Total_Rest_Amount;
    }
    
}
