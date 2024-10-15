package com.example.Demo_JavaCore.static_final;

public class Demo {
    final int x=100;

    static int y=200;

    void display() {
        System.out.println("Giá trị của final: " + x);
        System.out.println("Giá trị của static: " + y);
    }

    public static void main(String[] args) {
        new Demo().display();

//        new Demo().x=50; Lỗi biên dịch
        //Biến static y không cần khởi tạo đối tượng, gọi trực tiếp bằng tên lớp
        Demo.y=150;

        new Demo().display();
    }
}
