package service;

import model.Customers;

import java.util.ArrayList;
import java.util.List;

public class CustomersService {
    private List<Customers> customersList=new ArrayList<>();

    private List<Customers> customersListSearch=new ArrayList<>();

    public CustomersService() {
        customersList.add(new Customers("KH01","Pham Ngọc Hải","bophamnb2004@gmail.com","0334294889"));
        customersList.add(new Customers("KH02","Nguyễn Thị Thuý Hằng","bophamnb2004@gmail.com","0337737196"));
        customersList.add(new Customers("KH03","Nguyễn Tuấn Khanh","khanhnt35@gmail.com","0334294889"));
    }

   public void viewCustomers(){
        for(Customers customers:customersList){
            System.out.println("Customers: "+customers);
        }
    }

    public void addCustomer(Customers customers){
        customersList.add(customers);
        viewCustomers();
    }

    public List<Customers> searchCustomer(String phoneNumber){
        for (Customers customers:customersList){
            if(customers.getPhoneNumber().equals(phoneNumber)){
               customersListSearch.add(customers);
            }
        }
        if (customersListSearch.isEmpty()) {
            System.out.println("Không tìm thấy khách hàng với số điện thoại: " + phoneNumber);
        } else {
            for (Customers customers:customersListSearch){
                System.out.println("Đã tìm thấy khách hàng: "+customers);
            }

        }
        return customersListSearch;

    }

    public Customers editCustomer(Customers updatedCustomer, String key) {
        for (Customers customer : customersList) {
            if (customer.getMaKH().equals(key)) {
                customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
                customer.setEmail(updatedCustomer.getEmail());
                customer.setName(updatedCustomer.getName());
                return customer;
            }
        }

        return null;
    }

    public boolean checkExists(String key) {

        for (Customers customer : customersList) {
            if (customer.getMaKH().equals(key)) {
                return true;
            }
        }
        System.out.println("Không tìm thấy KH có mã: "+key);
        return false;
    }

    public void deleteCustomer(String maKH){
        for (Customers customer : customersList) {
            if (customer.getMaKH().equals(maKH)) {
                customersList.remove(customer);
            }
        }
    }

}
