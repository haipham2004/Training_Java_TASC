package main;

import model.Customers;
import service.CustomersService;

import java.util.Scanner;

public class CustomersMain {

    public static void main(String[] args) {
        CustomersService customersService=new CustomersService();

        Scanner scanner=new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n1. Xem danh sách khách hàng");
            System.out.println("2. Thêm thông tin khách hàng");
            System.out.println("3. Tìm kiếm khách hàng theo số điện thoại");
            System.out.println("4. Chỉnh sửa thông tin khách hàng");
            System.out.println("5. Xóa thông tin khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear the newline

            switch (choice) {
                case 1:
                    customersService.viewCustomers();
                    break;
                case 2:
                    System.out.println("Nhập số lượng Khách Hàng cần thêm: ");
                    int soLuong= scanner.nextInt();
                    scanner.nextLine();
                    for(int i=0;i<soLuong;i++){
                        System.out.println("Nhập maKH: ");
                        String maKH= scanner.nextLine();
                        System.out.println("Nhập name: ");
                        String name= scanner.nextLine();
                        System.out.println("Nhập email:  ");
                        String email= scanner.nextLine();
                        System.out.println("Nhập phoneNumber:  ");
                        String phoneNumber= scanner.nextLine();
                        Customers customers=new Customers(maKH,name,email,phoneNumber);
                        customersService.addCustomer(customers);
                    }

                    break;
                case 3:
                    System.out.println("Nhập phoneNumber cần tìm:  ");
                    String phoneNumberSearch= scanner.nextLine();
                    customersService.searchCustomer(phoneNumberSearch);
                    break;
                case 4:
                    System.out.println("Nhập maKH bạn muốn chỉnh sửa thông tin: ");
                    String maKH= scanner.nextLine();
                    if(customersService.checkExists(maKH)){
                        System.out.println("Nhập name: ");
                        String name= scanner.nextLine();
                        System.out.println("Nhập email:  ");
                        String email= scanner.nextLine();
                        System.out.println("Nhập phoneNumber:  ");
                        String phoneNumber= scanner.nextLine();
                        Customers customers=new Customers(maKH,name,email,phoneNumber);
                        customersService.editCustomer(customers,maKH);

                    }
                    customersService.viewCustomers();
                    break;
                case 5:
                    System.out.println("Nhập maKH bạn muốn xoá: ");
                    String maKHXoa= scanner.nextLine();
                    if(customersService.checkExists(maKHXoa)){
                        customersService.deleteCustomer(maKHXoa);
                        customersService.viewCustomers();
                    }
                    break;
                case 0:
//                    customerService.saveCustomersToFile();
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 0);


    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{10}");
    }


}
