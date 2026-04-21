
package dao;

import model.*;

import exception.AppException;
import util.*;
import java.sql.*;
import java.util.*;

public class CustomerDAO {

    // . Add Customer with Transaction
    public static void addCustomer(Customer c) throws AppException {

        String custSQL = "INSERT INTO customers VALUES (?, ?, ?, ?)";
        String billSQL = "INSERT INTO bills VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBUtil.getConnection()) {

            con.setAutoCommit(false);

            PreparedStatement ps1 = con.prepareStatement(custSQL);
            ps1.setInt(1, c.custId);
            ps1.setString(2, c.custName);
            ps1.setString(3, c.custAddress);
            ps1.setString(4, c.custMobile);
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(billSQL);

            for (BillBook b : c.bills) {
                ps2.setInt(1, b.billId);
                ps2.setInt(2, c.custId);
                ps2.setString(3, b.billDate);
                ps2.setString(4, b.product);
                ps2.setInt(5, b.quantity);
                ps2.setDouble(6, b.totalAmount);
                ps2.executeUpdate();
            }

            con.commit();

        } catch (Exception e) {
            throw new AppException("Error adding customer: " + e.getMessage());
        }
    }

    // . Get All Customers
    public static List<Customer> getAllCustomers() throws AppException {

        Map<Integer, Customer> map = new HashMap<>();

        String sql = "SELECT c.*, b.* FROM customers c LEFT JOIN bills b ON c.cust_id=b.cust_id";

        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                int id = rs.getInt("cust_id");

                Customer c = map.getOrDefault(id,
                        new Customer(id,
                                rs.getString("cust_name"),
                                rs.getString("cust_address"),
                                rs.getString("cust_mobile")));

                int billId = rs.getInt("bill_id");

                if (billId != 0) {
                    c.addBill(new BillBook(
                            billId,
                            rs.getString("bill_date"),
                            rs.getString("product"),
                            rs.getInt("quantity"),
                            rs.getDouble("total_amount")
                    ));
                }

                map.put(id, c);
            }

        } catch (Exception e) {
            throw new AppException("Error fetching customers");
        }

        return new ArrayList<>(map.values());
    }

    // . Find Customer
    public static Customer findCustomer(int id) throws AppException {

        List<Customer> list = getAllCustomers();

        return list.stream()
                .filter(c -> c.custId == id)
                .findFirst()
                .orElseThrow(() -> new AppException("Customer not found"));
    }

    // . Most Valuable Customer
    public static Customer mostValuableCustomer() throws AppException {

        return getAllCustomers().stream()
                .max(Comparator.comparing(Customer::getTotalAmount))
                .orElseThrow(() -> new AppException("No customers found"));
    }
}




