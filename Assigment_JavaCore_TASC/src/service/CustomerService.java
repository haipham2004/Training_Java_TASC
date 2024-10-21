package service;

import model.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    private Map<String, Customer> customers; 

    private static final String FILE_NAME = "customers.txt";

    public CustomerService() {
        customers = new HashMap<>();
        loadCustomers();
    }

    public void addCustomer(Customer customer) {
        if (!isValidCustomer(customer)) {
            System.out.println("Thông tin khách hàng không hợp lệ. Vui lòng kiểm tra lại.");
            return;
        }

        if (customers.containsKey(customer.getPhoneNumber())) {
            System.out.println("Số điện thoại này đã tồn tại. Vui lòng nhập số điện thoại khác.");
            return;
        }

        customers.put(customer.getPhoneNumber(), customer);
        saveCustomers();
    }

    public void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("Danh sách khách hàng trống.");
            return;
        }

        for (Customer customer : customers.values()) {
            System.out.println(customer);
        }
    }

    public Customer searchCustomerByPhoneNumber(String phoneNumber) {
        return customers.get(phoneNumber);
    }

    public void editCustomer(String phoneNumber, String newName, String newEmail, String newPhoneNumber) {
        Customer customer = searchCustomerByPhoneNumber(phoneNumber);
        if (customer == null) {
            System.out.println("Không tìm thấy khách hàng với số điện thoại này.");
            return;
        }

        if (newName != null && !newName.isEmpty()) {
            customer.setName(newName);
        }

        if (newEmail != null && !newEmail.isEmpty() && newEmail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            customer.setEmail(newEmail);
        } else if (newEmail != null && !newEmail.isEmpty()) {
            System.out.println("Email không hợp lệ. Vui lòng nhập email đúng định dạng.");
        }

        if (newPhoneNumber != null && !newPhoneNumber.isEmpty() && newPhoneNumber.matches("^[0-9]{10}$")) {

            customers.remove(phoneNumber);
            customer.setPhoneNumber(newPhoneNumber);
            customers.put(newPhoneNumber, customer);
        } else if (newPhoneNumber != null && !newPhoneNumber.isEmpty()) {
            System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập số điện thoại 10 số.");
        }

        saveCustomers();
        viewCustomers();
    }

    public void deleteCustomer(String phoneNumber) {
        if (!customers.containsKey(phoneNumber)) {
            System.out.println("Không tìm thấy khách hàng với số điện thoại này.");
            return;
        }
        System.out.println("Đã xoá thành công khách hàng có số điện thoại: "+phoneNumber);
        customers.remove(phoneNumber);
        saveCustomers();
        viewCustomers();
    }

    private boolean isValidCustomer(Customer customer) {
        boolean isValid = true;
        if (customer.getName() == null || customer.getName().isEmpty()) {
            System.out.println("Tên không được để trống.");
            isValid = false;
        }

        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if (customer.getEmail() == null || !customer.getEmail().matches(emailRegex)) {
            System.out.println("Email không hợp lệ. Vui lòng nhập email đúng định dạng.");
            isValid = false;
        }

        String phoneRegex = "^[0-9]{10}$";
        if (customer.getPhoneNumber() == null || !customer.getPhoneNumber().matches(phoneRegex)) {
            System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập số điện thoại 10 số.");
            isValid = false;
        }

        return isValid;
    }

    private void loadCustomers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Customer customer = new Customer(parts[0], parts[1], parts[2]);
                    customers.put(customer.getPhoneNumber(), customer);
                }
            }
        } catch (IOException e) {
            System.out.println("Không thể tải dữ liệu khách hàng: " + e.getMessage());
        }
    }

    private void saveCustomers() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Customer customer : customers.values()) {
                writer.println(customer.getName() + "," + customer.getEmail() + "," + customer.getPhoneNumber());
            }
        } catch (IOException e) {
            System.out.println("Không thể lưu dữ liệu khách hàng: " + e.getMessage());
        }
    }
}
