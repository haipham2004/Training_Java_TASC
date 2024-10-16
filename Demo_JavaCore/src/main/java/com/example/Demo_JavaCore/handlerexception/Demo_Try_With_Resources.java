package com.example.Demo_JavaCore.handlerexception;

import java.util.Scanner;

public class Demo_Try_With_Resources {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tử số: ");
        int tuSo = scanner.nextInt();

        System.out.print("Nhập mẫu số: ");
        int mauSo = scanner.nextInt();

        try {
            int result = tuSo / mauSo;
            System.out.println("Kết quả: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: Không thể chia cho 0!");
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }finally {
            scanner.close();
        }
    }
}
