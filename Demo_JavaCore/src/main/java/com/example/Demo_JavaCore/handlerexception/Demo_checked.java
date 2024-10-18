package com.example.Demo_JavaCore.handlerexception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo_checked {

    // Phương thức kiểm tra tuổi
    public static void checkAge(int age) {
        if (age < 0) {
            // Ngoại lệ từ custom
            throw new Demo_Custom_Exception("Tuổi không thể âm!");
        } else {
            System.out.println("Tuổi hợp lệ: " + age);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Nhập tuổi: ");
        try {
            int age = scanner.nextInt();
            checkAge(age);
        } catch (InputMismatchException e) {
            System.out.println("Vui lòng nhập một số nguyên hợp lệ!");
        } catch (Demo_Custom_Exception e) {
            System.out.println("Ngoại lệ: " + e.getMessage());
        } finally {
            scanner.close(); // Đóng Scanner
        }
    }
}
