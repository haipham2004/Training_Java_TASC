package com.example.Demo_JavaCore.handlerexception;

import java.util.Scanner;

public class Demo_Try_catch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tuổi của bạn: ");

        try {
            System.out.print("Nhập tuổi của bạn: ");
            int age = scanner.nextInt();

            if (age < 1 || age > 100) {
                throw new IllegalArgumentException("Tuổi phải nằm trong khoảng từ 1 đến 100.");
            }

            System.out.println("Số bạn đã nhập là: " + age);
        } catch (IllegalArgumentException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
