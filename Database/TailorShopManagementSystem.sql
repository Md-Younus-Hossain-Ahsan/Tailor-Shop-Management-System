create database tailor_shop_management_system



CREATE TABLE Customer (
    CustomerID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    Gender VARCHAR(50),
    MobileNumber VARCHAR(15),
    Address VARCHAR(255)
) AUTO_INCREMENT = 10001;



CREATE TABLE User (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    UserName VARCHAR(100),
    Email VARCHAR(100),
    Password VARCHAR(25)
) AUTO_INCREMENT = 100001;



CREATE TABLE Employee (
    EmployeeID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    Gender VARCHAR(50),
    MobileNumber VARCHAR(15),
    NID VARCHAR(25),
	Email VARCHAR(100),
    PresentAddress VARCHAR(255),
	PermanentAddress VARCHAR(255),
	Position VARCHAR(50),	
	Salary INT	
) AUTO_INCREMENT = 101;



CREATE TABLE Dress_Category (
    DressID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    Gender VARCHAR(10),
    PreparingCost INT
) AUTO_INCREMENT = 1001;



CREATE TABLE Expenses (
    ExpID INT AUTO_INCREMENT PRIMARY KEY,
    Issue VARCHAR(100),
    Amount INT,
    Description VARCHAR(255),
	Cost_date DATETIME
) AUTO_INCREMENT = 100001;



CREATE TABLE Orders (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
	CustomerID INT,
	DressID INT,
    OrderDate DATETIME,
    DeliveryDate DATETIME,    
    Discount FLOAT,
    Rest_amount INT,
    Total_cost INT,
    OrderType VARCHAR(255),
	FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
	FOREIGN KEY (DressID) REFERENCES Dress_Category(DressID)
) AUTO_INCREMENT = 1001;



CREATE TABLE Transactions (
	OrderID INT,
	Date DATETIME,
	Amount INT,
	FOREIGN KEY (OrderID) REFERENCES Orders(OrderID)
);



CREATE TABLE Measurements (
	OrderID INT,
	Neck FLOAT,
	Chest FLOAT,
	Height FLOAT,
	Wrist FLOAT,
	Hip FLOAT,
	FOREIGN KEY (OrderID) REFERENCES Orders(OrderID)
);

