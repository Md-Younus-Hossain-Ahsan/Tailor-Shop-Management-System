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

public class Order {
    
    int Total_Orders;
    int OrderID;
    int DressID;
    float Discount;
    int Rest_amount;
    int Total_cost;
    
    
    public void Last_ID_Search() throws ClassNotFoundException{
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "Select * from Orders";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            OrderID = 1000;
            while(rs.next())
            {
                OrderID = rs.getInt("OrderID");
            }            
            
        }catch(SQLException e){}
        
    } 
    
    
    public void total_number_of_orders(String OrderType){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select COUNT(*) AS Total_Orders from Orders where OrderType = '"+ OrderType +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Orders = res.getInt("Total_Orders");
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }

    
    public void total_number_of_orders_between_two_Dates(Date Date1, Date Date2, String OrderType){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select COUNT(*) AS Total_Orders from Orders where OrderDate BETWEEN ? and ? and OrderType = '"+ OrderType +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, new java.sql.Date(Date1.getTime()));
            pst.setDate(2, new java.sql.Date(Date2.getTime()));
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Orders = res.getInt("Total_Orders");
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }

    
    public void total_number_of_orders_between_two_Dates(int CustomerID, Date Date1, Date Date2){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select COUNT(*) AS Total_Orders from Orders where OrderDate BETWEEN ? and ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, new java.sql.Date(Date1.getTime()));
            pst.setDate(2, new java.sql.Date(Date2.getTime()));
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Orders = res.getInt("Total_Orders");
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }

    
    public void total_number_of_orders_between_two_Dates(int CustomerID, Date Date1, Date Date2, String OrderType){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select COUNT(*) AS Total_Orders from Orders where OrderDate BETWEEN ? and ? and OrderType = '"+ OrderType +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, new java.sql.Date(Date1.getTime()));
            pst.setDate(2, new java.sql.Date(Date2.getTime()));
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Orders = res.getInt("Total_Orders");
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }

    
    public void total_number_of_orders_through_CustomerID(int CustomerID){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select COUNT(*) AS Total_Orders from Orders where CustomerID = '"+ CustomerID +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Orders = res.getInt("Total_Orders");
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }

    
    public void total_number_of_orders_through_CustomerID(int CustomerID, String OrderType){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select COUNT(*) AS Total_Orders from Orders where CustomerID = '"+ CustomerID +"' and OrderType = '"+ OrderType +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Orders = res.getInt("Total_Orders");
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }

    
    public void total_number_of_orders_through_MobileNumber(String MobileNumber, String OrderType){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "select COUNT(*) AS Total_Orders from Customer c JOIN Orders o ON c.CustomerID = o.CustomerID where c.MobileNumber = '"+ MobileNumber +"' and o.OrderType = '"+ OrderType +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet res = pst.executeQuery();
            
            while(res.next())
            {
                Total_Orders = res.getInt("Total_Orders");
            }
            
        }catch(SQLException | ClassNotFoundException ex) {}      
        
    }
    
    
    public void searching_all_the_information(int OrderID) throws ClassNotFoundException{
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "Select * from Orders where OrderID = '"+ OrderID +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                DressID = rs.getInt("DressID");
                Discount = rs.getFloat("Discount");
                Rest_amount = rs.getInt("Rest_amount");
                Total_cost = rs.getInt("Total_cost");
            }  
            
        }catch(SQLException e){}
        
    } 

    
    public void insert_into_Order_list(int CustomerID, int DressID, Date DeliveryDate, float Discount, int Rest_amount, int Total_cost, String OrderType) throws ClassNotFoundException{
                
        try{
            LocalDateTime orderDate = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(orderDate);
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "insert into Orders(CustomerID, DressID, OrderDate, DeliveryDate, Discount, Rest_amount, Total_cost, OrderType) values (?,?,?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, CustomerID);
            pst.setInt(2, DressID);
            pst.setTimestamp(3, timestamp);
            pst.setDate(4, new java.sql.Date(DeliveryDate.getTime()));
            pst.setFloat(5, Discount);
            pst.setInt(6, Rest_amount);
            pst.setInt(7, Total_cost);
            pst.setString(8, OrderType);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Added !"); 

        }catch(SQLException e){System.out.println(e);}
            
    }

    
    public void update_the_Order_list(int OrderID, int DressID, Date DeliveryDate, float Discount, int Rest_amount, int Total_cost) throws ClassNotFoundException{
                
        try{
            LocalDateTime orderDate = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(orderDate);
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "update Orders set DressID=?, OrderDate=?, DeliveryDate=?, Discount=?, Rest_amount=?, Total_cost=? where OrderID=?";
            
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, DressID);
            pst.setTimestamp(2, timestamp);
            pst.setDate(3, new java.sql.Date(DeliveryDate.getTime()));
            pst.setFloat(4, Discount);
            pst.setInt(5, Rest_amount);
            pst.setInt(6, Total_cost);
            pst.setInt(7, OrderID);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Updated !"); 

        }catch(SQLException e){System.out.println(e);}
            
    }

    
    public void confirm_all_the_temporary_orders(int CustomerID) throws ClassNotFoundException, ParseException{
                
        try{
            LocalDateTime orderDate = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(orderDate);
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "update Orders set OrderDate=?, OrderType=? where CustomerID=?";
            
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setTimestamp(1, timestamp);
            pst.setString(2, "Pending");
            pst.setInt(3, CustomerID);

            pst.executeUpdate();

        }catch(SQLException e){JOptionPane.showMessageDialog(null, "Not found !"); }
            
    }
    

    public void delivered_a_pending_order(int OrderID) throws ClassNotFoundException, ParseException{
                
        try{
            LocalDateTime deliveryDate = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(deliveryDate);
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "update Orders set DeliveryDate=?, Rest_amount=?, OrderType=? where OrderID=?";
            
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setTimestamp(1, timestamp);
            pst.setInt(2, 0);
            pst.setString(3, "Delivered");
            pst.setInt(4, OrderID);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Done !"); 

        }catch(SQLException e){JOptionPane.showMessageDialog(null, "Not found !"); }
            
    }

    public int getTotal_Orders() {
        return Total_Orders;
    }    

    public int getOrderID() {
        return ++OrderID;
    }

    public int getDressID() {
        return DressID;
    }

    public float getDiscount() {
        return Discount;
    }

    public int getRest_amount() {
        return Rest_amount;
    }

    public int getTotal_cost() {
        return Total_cost;
    }
    
}
