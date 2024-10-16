package com.example.Demo_JavaCore.handlerexception;

public class Demo_Throw_Throws {

    public static void checkAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Tuổi phải lớn hơn hoặc bằng 18");
        } else {
            System.out.println("Tuổi hợp lệ.");
        }
    }


    public static void main(String[] args) throws Exception {
        try {
           checkAge(15);
        } catch (Exception e) {
            System.out.println("Ngoại lệ: " + e.getMessage());
        }

        try {
           checkAge(20);
        } catch (Exception e) {
            System.out.println("Ngoại lệ: " + e.getMessage());
        }
    }
}
