package com.example.Demo_JavaCore.handlerexception;

import java.util.Scanner;

public class Demo_Try_catch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tuổi của bạn: ");

        try {
            int age = scanner.nextInt();
            System.out.println("Số bạn đã nhập là: " + age);
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}
