package com.example.Demo_JavaCore.handlerexception;

import java.util.Scanner;

public class Demo_checked {

    // Phương thức kiểm tra tuổi
    public static void checkAge(int age) throws Exception {
        if (age < 0) {
            throw new Exception("Tuổi không thể âm!");
        } else {
            System.out.println("Tuổi hợp lệ: " + age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tuổi: ");
        int age = scanner.nextInt();

        try {
             checkAge(age);
        } catch (Exception e) {
            System.out.println("Ngoại lệ: " + e.getMessage());
        }
    }
}
