create table Customers (
	CustomerID int,
	CompanyName varchar(50),
	FirstName varchar(30),
	LastName varchar(50),
	BillingAddress varchar(255),
	City varchar(50),
	StateOrProvince varchar(20),
	ZIPCode varchar(20),
	Email varchar(75),
	CompanyWebsite varchar(200),
	PhoneNumber varchar(30),
	FaxNumber varchar(30),
	ShipAddress varchar(255),
	ShipCity varchar(50),
	ShipStateOrProvince varchar(50),
	ShipZipCode varchar(20),
	ShipPhoneNumber varchar(30),
	primary key (CustomerID)
);


create table Employees (
	EmployeeID int,
	FirstName varchar(50),
	LastName varchar(50),
	Title varchar(50),
	WorkPhone varchar(30),
	primary key (EmployeeID)
);


create table Shipping_Methods (
	ShippingMethodID int,
	ShippingMethod varchar(20),
	primary key (ShippingMethodID)
);


create table Products (
	ProductID int,
	ProductName varchar(50),
	UnitPrice int,
	InStock char(1),
	primary key (ProductID)
);

create table Orders(
	OrderID int,
	CustomerID int,
	EmployeeID int,
	OrderDate date default null,
	PurchaseOrderNumber varchar(30),
	ShipDate date default null,
	ShippingMethodID int,
	FreightCharge int,
	Taxes int,
	PaymentReceived char(1),
	Comment varchar(150),
	primary key (OrderID),
	foreign key (CustomerID) references Customers(CustomerID),
	foreign key (EmployeeID) references Employees(EmployeeID),
	foreign key (ShippingMethodID) references Shipping_Methods(ShippingMethodID)
);

create table Order_Details (
	OrderDetailID int,
	OrderID int,
	ProductID int,
	Quantity int,
	UnitPrice int,
	Discount int,
	primary key (OrderDetailID),
	foreign key (OrderID) references Orders(OrderID),
	foreign key (ProductID) references Products(ProductID)
);