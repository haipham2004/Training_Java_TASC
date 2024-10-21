package com.example.Demo_DESIGN_PATTERN.singleton;

public class Singleton {

    // Tạo biến thể hiện
    private static Singleton instance;


    private Singleton() { }

   // Tạo phương thức trả về sự hiện diẹn của class
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }


    public void wellcome() {
        System.out.println("Xin chào: Hải Phạm YKA");
    }
}
