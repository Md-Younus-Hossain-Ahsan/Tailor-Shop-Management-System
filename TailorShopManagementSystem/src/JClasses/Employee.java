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

public class Employee {
    
    int EmployeeID;
    String Name;
    String Gender;
    String MobileNumber;
    String NID;
    String Email;
    String PresentAddress;
    String PermanentAddress;
    String Position;
    int Salary;
    
    
    public void searching_all_the_information_through_EmployeeID(int EmployeeID) throws ClassNotFoundException{
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "Select * from Employee where EmployeeID = '"+ EmployeeID +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                Name = rs.getString("Name");
                Gender = rs.getString("Gender");
                MobileNumber = rs.getString("MobileNumber");
                NID = rs.getString("NID");
                Email = rs.getString("Email");
                PresentAddress = rs.getString("PresentAddress");
                PermanentAddress = rs.getString("PermanentAddress");
                Position = rs.getString("Position");
                Salary = rs.getInt("Salary");
            }            
            
        }catch(SQLException e){}
        
    } 

    
    public void searching_all_the_information_through_MobileNumber(String MobileNumber) throws ClassNotFoundException{
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "Select * from Employee where MobileNumber = '"+ MobileNumber +"'";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next())
            {
                EmployeeID = rs.getInt("EmployeeID");
                Name = rs.getString("Name");
                Gender = rs.getString("Gender");
                NID = rs.getString("NID");
                Email = rs.getString("Email");
                PresentAddress = rs.getString("PresentAddress");
                PermanentAddress = rs.getString("PermanentAddress");
                Position = rs.getString("Position");
                Salary = rs.getInt("Salary");
            }            
            
        }catch(SQLException e){}
        
    } 

    
    public void insert_into_Employee_list(String Name, String Gender, String MobileNumber, String NID, String Email, String PresentAddress, String PermanentAddress, String Position, int Salary) throws ClassNotFoundException{
                
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "insert into Employee(Name, Gender, MobileNumber, NID, Email, PresentAddress, PermanentAddress, Position, Salary) values (?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, Name);
            pst.setString(2, Gender);
            pst.setString(3, MobileNumber);
            pst.setString(4, NID);
            pst.setString(5, Email);
            pst.setString(6, PresentAddress);
            pst.setString(7, PermanentAddress);
            pst.setString(8, Position);
            pst.setInt(9, Salary);
            
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Added !"); 

        }catch(SQLException e){JOptionPane.showMessageDialog(null, "Not found !"); }
            
    }

    
    public void update_the_Employee_info(int EmployeeID, String Name, String Gender, String MobileNumber, String NID, String Email, String PresentAddress, String PermanentAddress, String Position, int Salary) throws ClassNotFoundException{
                
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            
            String sql = "update Employee set Name = '"+ Name +"', Gender = '"+ Gender +"', MobileNumber = '"+ MobileNumber +"', NID = '"+ NID +"', Email = '"+ Email +"', PresentAddress = '"+ PresentAddress +"', PermanentAddress = '"+ PermanentAddress +"', Position = '"+ Position +"', Salary = '"+ Salary +"' where EmployeeID = '"+ EmployeeID +"'";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Updated !"); 

        }catch(SQLException e){}
            
    }

    public int getEmployeeID() {
        return EmployeeID;
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

    public String getNID() {
        return NID;
    }

    public String getEmail() {
        return Email;
    }

    public String getPresentAddress() {
        return PresentAddress;
    }

    public String getPermanentAddress() {
        return PermanentAddress;
    }

    public String getPosition() {
        return Position;
    }

    public int getSalary() {
        return Salary;
    }
    
}
