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
                    scanner.nextLine(); // Đọc bỏ dòng còn lại

                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhập thông tin khách hàng " + (i + 1) + ":");

                        String name = validateName(scanner); // Nhập tên
                        String email = validateEmail(scanner); // Nhập email
                        String phoneNumber;

                        while (true) {
                            phoneNumber = validatePhoneNumber(scanner);

                            if (!customerManager.checkPhoneNumberExists(phoneNumber)) {
                                break;
                            }

                        }

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
                    String phoneToEdit;
                    Customer customerEdit = null; // Khai báo biến ở phạm vi này

                    while (true) {
                        System.out.print("Nhập số điện thoại của khách hàng cần chỉnh sửa: ");
                        phoneToEdit = scanner.nextLine();


                        customerEdit = customerManager.searchCustomerByPhoneNumber(phoneToEdit);
                        if (customerEdit != null) {
                            break;
                        } else {
                            System.out.println("Không tìm thấy khách hàng với số điện thoại này. Vui lòng nhập lại.");
                        }
                    }

                    System.out.println("Bạn muốn sửa thông tin gì? (Để trống nếu không muốn thay đổi)");

                    String newName = validateNames(scanner);
                    String newEmail = validateEmails(scanner);
                    String newPhoneNumber = validatePhoneNumbers(scanner);


                    customerManager.editCustomer(phoneToEdit,
                            newName.isEmpty() ? customerEdit.getName() : newName,
                            newEmail.isEmpty() ? customerEdit.getEmail() : newEmail,
                            newPhoneNumber.isEmpty() ? customerEdit.getPhoneNumber() : newPhoneNumber);
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

    private static String validateName(Scanner scanner) {
        String name;
        while (true) {
            System.out.print("Nhập tên: ");
            name = scanner.nextLine();
            if (!name.isEmpty()) {
                break;
            }
            System.out.println("Tên không được để trống. Vui lòng nhập lại.");
        }
        return name;
    }

    private static String validateEmail(Scanner scanner) {
        String email;
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        while (true) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();
            if (email.matches(emailRegex)) {
                break;
            }
            System.out.println("Email không hợp lệ. Vui lòng nhập lại.");
        }
        return email;
    }

    private static String validatePhoneNumber(Scanner scanner) {
        String phoneNumber;
        while (true) {
            System.out.print("Nhập số điện thoại (10 số): ");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.matches("^[0-9]{10}$")) {
                break;
            }
            System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
        }
        return phoneNumber;
    }

    private static String validateNames(Scanner scanner) {
        System.out.print("Nhập tên (để trống nếu không muốn thay đổi): ");
        String name = scanner.nextLine();
        return name;
    }

    private static String validateEmails(Scanner scanner) {
        String email;
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        while (true) {
            System.out.print("Nhập email (để trống nếu không muốn thay đổi): ");
            email = scanner.nextLine();

            if (email.isEmpty() || email.matches(emailRegex)) {
                return email;
            }
            System.out.println("Email không hợp lệ. Vui lòng nhập lại.");
        }
    }

    private static String validatePhoneNumbers(Scanner scanner) {
        String phoneNumber;
        while (true) {
            System.out.print("Nhập số điện thoại (10 số, để trống nếu không muốn thay đổi): ");
            phoneNumber = scanner.nextLine();

            if (phoneNumber.isEmpty() || phoneNumber.matches("^[0-9]{10}$")) {
                return phoneNumber;
            }
            System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
        }
    }
}
