package com.example.Demo_JavaCore.handlerexception;

import java.util.Scanner;

public class Demo_unchecked {

    public static void checkAge(int age)  {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Tuổi không hợp lệ. Vui lòng nhập tuổi từ 0 đến 120.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tuổi của bạn: ");

        try {
            int age = scanner.nextInt();
            checkAge(age);
            System.out.println("Tuổi hợp lệ: " + age);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }


}
