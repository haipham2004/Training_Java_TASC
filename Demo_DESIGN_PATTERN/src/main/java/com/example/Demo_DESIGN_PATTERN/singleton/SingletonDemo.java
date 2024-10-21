package com.example.Demo_DESIGN_PATTERN.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        // Lấy thể hiện của Singleton
        Singleton singleton1 = Singleton.getInstance();
        singleton1.wellcome();


        // Kiểm tra xem các thể hiện
        Singleton singleton2 = Singleton.getInstance();
        singleton2.wellcome();
        System.out.println(singleton1 == singleton2); // Kết quả: true vì
//        singleton1 nhận giá trị của thể hiện mới được tạo ra trong lần gọi đầu tiên.
//        singleton2 nhận giá trị của thể hiện đã tồn tại trong lần gọi thứ hai.
    }
}
