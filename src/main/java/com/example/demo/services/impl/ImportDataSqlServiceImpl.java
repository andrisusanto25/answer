package com.example.demo.services.impl;

import com.example.demo.services.ImportDataSqlService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



@Service
public class ImportDataSqlServiceImpl implements ImportDataSqlService {

    public void executeImport() {
        readCsvCustomers();
        readCsvEmployee();
        readCsvShippingMethods();
        readCsvOrders();
        readCsvProducts();
        readCsvOrderDetails();
    }

    private static void readCsvCustomers() {
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/demo?", "root", "")) {
            String loadQuery = "LOAD DATA LOCAL INFILE 'src/main/resources/csv/Customers.csv'" +
                    " INTO TABLE customers FIELDS TERMINATED BY ';'" +
                    " LINES TERMINATED BY '\n' IGNORE 1 LINES" +
                    " (CustomerID,CompanyName,FirstName,LastName,BillingAddress,City,StateOrProvince,ZIPCode,Email,CompanyWebsite,PhoneNumber,FaxNumber,ShipCity,ShipAddress,ShipStateOrProvince,ShipZipCode,ShipPhoneNumber)";
            System.out.println(loadQuery);
            Statement stmt = connection.createStatement();
            stmt.execute(loadQuery);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readCsvEmployee() {
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/demo?", "root", "")) {
            String loadQuery = "LOAD DATA LOCAL INFILE '"
                    + "src/main/resources/csv/Employees.csv"
                    + "' INTO TABLE employees FIELDS TERMINATED BY ';'"
                    + " LINES TERMINATED BY '\n' IGNORE 1 LINES (EmployeeID, FirstName, LastName, Title, WorkPhone) ";
            System.out.println(loadQuery);
            Statement stmt = connection.createStatement();
            stmt.execute(loadQuery);
            stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readCsvShippingMethods() {
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/demo?", "root", "")) {
            String loadQuery = "LOAD DATA LOCAL INFILE 'src/main/resources/csv/ShippingMethods.csv'" +
                    " INTO TABLE shipping_methods FIELDS TERMINATED BY ';'" +
                    " LINES TERMINATED BY '\n' IGNORE 1 LINES" +
                    " (ShippingMethodID,ShippingMethod)";
            System.out.println(loadQuery);
            Statement stmt = connection.createStatement();
            stmt.execute(loadQuery);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readCsvProducts() {
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/demo?", "root", "")) {
            String loadQuery = "LOAD DATA LOCAL INFILE 'src/main/resources/csv/Products.csv'" +
                    " INTO TABLE products FIELDS TERMINATED BY ';'" +
                    " LINES TERMINATED BY '\n' IGNORE 1 LINES" +
                    " (ProductID,ProductName, UnitPrice, InStock)";
            System.out.println(loadQuery);
            Statement stmt = connection.createStatement();
            stmt.execute(loadQuery);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readCsvOrders() {
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/demo?", "root", "")) {
            String loadQuery = "LOAD DATA LOCAL INFILE 'src/main/resources/csv/Orders.csv'" +
                    " INTO TABLE orders FIELDS TERMINATED BY ';'" +
                    " LINES TERMINATED BY '\n' IGNORE 1 LINES" +
                    " (OrderID,CustomerID,EmployeeID,@OrderDate,PurchaseOrderNumber,@ShipDate,ShippingMethodID,FreightCharge,Taxes,PaymentReceived,Comment)" +
                    " SET OrderDate = STR_TO_DATE(@OrderDate,'%d/%m/%Y'), ShipDate = STR_TO_DATE(@ShipDate,'%d/%m/%Y')";
            System.out.println(loadQuery);
            Statement stmt = connection.createStatement();
            stmt.execute(loadQuery);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readCsvOrderDetails() {
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/demo?", "root", "")) {
            String loadQuery = "LOAD DATA LOCAL INFILE 'src/main/resources/csv/OrderDetails.csv'" +
                    " INTO TABLE order_details FIELDS TERMINATED BY ';'" +
                    " LINES TERMINATED BY '\n' IGNORE 1 LINES" +
                    " (OrderDetailID,OrderID,ProductID,Quantity,UnitPrice,Discount)";
            System.out.println(loadQuery);
            Statement stmt = connection.createStatement();
            stmt.execute(loadQuery);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
