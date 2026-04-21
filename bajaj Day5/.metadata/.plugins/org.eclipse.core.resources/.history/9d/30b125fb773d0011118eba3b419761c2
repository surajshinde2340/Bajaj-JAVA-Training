


package app;

import model.*;
import dao.CustomerDAO;
import util.ExcelUtil;
import exception.AppException;

import java.util.*;

public class MainApp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n1.Add 2.Display 3.Find 4.Excel 5.Top Customer 6.Exit");

            int ch = sc.nextInt();

            try {

                switch (ch) {

                    case 1 : addCustomer();

                    case 2 : CustomerDAO.getAllCustomers()
                            .forEach(c -> System.out.println(c.custName + " -> " + c.getTotalAmount()));

                    case 3 : {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        System.out.println(CustomerDAO.findCustomer(id).custName);
                    }

                    case 4 : ExcelUtil.generate(CustomerDAO.getAllCustomers());

                    case 5 : {
                        Customer c = CustomerDAO.mostValuableCustomer();
                        System.out.println("Top: " + c.custName + " Amount: " + c.getTotalAmount());
                    }

                    case 6 : System.exit(0);
                }

            } catch (AppException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static void addCustomer() {

        System.out.print("ID: ");
        int id = sc.nextInt();

        System.out.print("Name: ");
        String name = sc.next();

        System.out.print("Address: ");
        String addr = sc.next();

        System.out.print("Mobile: ");
        String mob = sc.next();

        Customer c = new Customer(id, name, addr, mob);

        System.out.print("Bills count: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("Bill ID: ");
            int bid = sc.nextInt();

            System.out.print("Date: ");
            String date = sc.next();

            System.out.print("Product: ");
            String prod = sc.next();

            System.out.print("Qty: ");
            int qty = sc.nextInt();

            System.out.print("Amount: ");
            double amt = sc.nextDouble();

            c.addBill(new BillBook(bid, date, prod, qty, amt));
        }

        try {
            CustomerDAO.addCustomer(c);
            System.out.println("Saved!");
        } catch (AppException e) {
            System.out.println(e.getMessage());
        }
    }
}



