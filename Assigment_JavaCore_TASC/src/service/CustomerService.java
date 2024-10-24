package service;

import model.Customer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomerService {

    private Map<String, Customer> customers; 

    private static final String FILE_NAME = "customers.txt";

    public CustomerService() {
        customers = new HashMap<>();
        loadCustomers();
    }

    public void addCustomer(Customer customer) {
        if (checkPhoneNumberExists(customer.getPhoneNumber())) {
            return; // Không thêm khách hàng nếu số điện thoại đã tồn tại
        }

        customers.put(customer.getPhoneNumber(), customer);
        saveCustomers(); // Lưu danh sách khách hàng
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

        customer.setName(newName);
        customer.setEmail(newEmail);

        customers.remove(phoneNumber);
        customer.setPhoneNumber(newPhoneNumber);
        customers.put(newPhoneNumber, customer);

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

    public boolean checkPhoneNumberExists(String phoneNumber) {
        if (customers.containsKey(phoneNumber)) {
            System.out.println("Số điện thoại này đã tồn tại. Vui lòng nhập số điện thoại khác.");
            return true; // Số điện thoại đã tồn tại
        }
        return false; // Số điện thoại chưa tồn tại
    }


//    private void loadCustomers() {
//        try (FileInputStream fis = new FileInputStream(FILE_NAME);
//             InputStreamReader isr = new InputStreamReader(fis);
//             BufferedReader reader = new BufferedReader(isr)) {
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts.length == 3) {
//
//                    if (!customers.containsKey(parts[2])) {
//                        Customer customer = new Customer(parts[0], parts[1], parts[2]);
//                        customers.put(customer.getPhoneNumber(), customer);
//                    }
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Không thể tải dữ liệu khách hàng: " + e.getMessage());
//        }
//    }

    private void loadCustomers() {
        long startTime = System.currentTimeMillis();

        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader reader = new BufferedReader(isr)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    if (!customers.containsKey(parts[2])) {
                        Customer customer = new Customer(parts[0], parts[1], parts[2]);
                        customers.put(customer.getPhoneNumber(), customer);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Không thể tải dữ liệu khách hàng: " + e.getMessage());
        } finally {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            System.out.println("Thời gian đọc file: " + duration + " ms");
        }
    }



    private void saveCustomers() {
        Set<String> existingPhoneNumbers = new HashSet<>();

   
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    existingPhoneNumbers.add(parts[2]);
                }
            }
        } catch (IOException e) {
            System.out.println("Không thể đọc dữ liệu khách hàng: " + e.getMessage());
        }


        try (FileOutputStream fos = new FileOutputStream(FILE_NAME, true);
             OutputStreamWriter osw = new OutputStreamWriter(fos);
             PrintWriter writer = new PrintWriter(osw)) {

            for (Customer customer : customers.values()) {

                if (!existingPhoneNumbers.contains(customer.getPhoneNumber())) {
                    writer.println(customer.getName() + "," + customer.getEmail() + "," + customer.getPhoneNumber());
                }
            }
        } catch (IOException e) {
            System.out.println("Không thể lưu dữ liệu khách hàng: " + e.getMessage());
        }
    }


}
