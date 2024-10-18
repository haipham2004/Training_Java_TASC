package service;

import model.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers;
    private static final String FILE_NAME = "customers.txt";

    public CustomerManager() {
        customers = new ArrayList<>();
        loadCustomers();
    }

    public void addCustomer(Customer customer) {
        if (!isValidCustomer(customer)) {
            System.out.println("Thông tin khách hàng không hợp lệ. Vui lòng kiểm tra lại.");
            return;
        }

        for (Customer c : customers) {
            if (c.getPhoneNumber().equals(customer.getPhoneNumber())) {
                System.out.println("Số điện thoại này đã tồn tại. Vui lòng nhập số điện thoại khác.");
                return;
            }
        }

        customers.add(customer);
        saveCustomers();
    }

    public void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("Danh sách khách hàng trống.");
            return;
        }

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public Customer searchCustomerByPhoneNumber(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return customer;
            }
        }
        return null;
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
            customer.setPhoneNumber(newPhoneNumber);
        } else if (newPhoneNumber != null && !newPhoneNumber.isEmpty()) {
            System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập số điện thoại 10 số.");
        }

        saveCustomers();
    }


    public void deleteCustomer(String phoneNumber) {
        Customer customer = searchCustomerByPhoneNumber(phoneNumber);
        if (customer == null) {
            System.out.println("Không tìm thấy khách hàng với số điện thoại này.");
            return;
        }

        customers.remove(customer);
        saveCustomers();
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
                    customers.add(new Customer(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Không thể tải dữ liệu khách hàng: " + e.getMessage());
        }
    }

    private void saveCustomers() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Customer customer : customers) {
                writer.println(customer.getName() + "," + customer.getEmail() + "," + customer.getPhoneNumber());
            }
        } catch (IOException e) {
            System.out.println("Không thể lưu dữ liệu khách hàng: " + e.getMessage());
        }
    }
}
