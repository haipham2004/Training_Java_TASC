package main;

import model.Customer;
import service.CustomerService;

import java.util.Scanner;

public class CustomerMain {


    public static void main(String[] args) {
        CustomerService customerManager = new CustomerService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===Chương trình quản lí khách hàng===");
            System.out.println("1. Xem thông tin danh sách khách hàng");
            System.out.println("2. Lưu thông tin khách hàng");
            System.out.println("3. Tìm kiếm thông tin khách hàng theo số điện thoại");
            System.out.println("4. Chỉnh sửa thông tin khách hàng");
            System.out.println("5. Xóa thông tin khách hàng");
            System.out.println("6. Thoát");
            System.out.println("======");
            System.out.println("Chọn chức năng:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    customerManager.viewCustomers();
                    break;
                case 2:
                    System.out.println("Nhập số lượng khách hàng:");
                    int n = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhập thông tin khách hàng " + (i + 1) + ":");
                        System.out.print("Tên: ");
                        String name = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Số điện thoại: ");
                        String phoneNumber = scanner.nextLine();
                        Customer customer = new Customer(name, email, phoneNumber);
                        customerManager.addCustomer(customer);
                    }
                    break;
                case 3:
                    System.out.print("Nhập số điện thoại: ");
                    String phoneNumber = scanner.nextLine();
                    Customer customer = customerManager.searchCustomerByPhoneNumber(phoneNumber);
                    if (customer != null) {
                        System.out.println(customer);
                    } else {
                        System.out.println("Không tìm thấy khách hàng.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập số điện thoại của khách hàng cần chỉnh sửa: ");
                    String phoneToEdit = scanner.nextLine();

                    System.out.println("Bạn muốn sửa thông tin gì? (Để trống nếu không muốn thay đổi)");

                    System.out.print("Nhập tên mới (để trống name nếu không thay đổi): ");
                    String newName = scanner.nextLine();

                    System.out.print("Nhập email mới (để trống email nếu không thay đổi): ");
                    String newEmail = scanner.nextLine();

                    System.out.print("Nhập số điện thoại mới (để trống số điện thoại nếu không thay đổi): ");
                    String newPhoneNumber = scanner.nextLine();

                    customerManager.editCustomer(phoneToEdit, newName, newEmail, newPhoneNumber);
                    break;

                case 5:
                    System.out.print("Nhập số điện thoại của khách hàng cần xóa: ");
                    String phoneToDelete = scanner.nextLine();
                    customerManager.deleteCustomer(phoneToDelete);
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
