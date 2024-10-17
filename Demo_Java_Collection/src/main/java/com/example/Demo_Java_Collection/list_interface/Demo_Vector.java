package com.example.Demo_Java_Collection.list_interface;

import java.util.Vector;

public class Demo_Vector {

    public static void main(String[] args) {
        // Khởi tạo Vector
        Vector<String> vector = new Vector<>();


        vector.addElement("Hải");
        vector.addElement("Hằng");
        vector.addElement("Khanh");
        vector.addElement("Mai");


        System.out.println("Kích thước Vector: " + vector.size());
        System.out.println("Dung lượng Vector: " + vector.capacity());


        System.out.println("Các phần tử trong Vector:");
        for (String name : vector) {
            System.out.println(name);
        }

        // Sửa đổi một phần tử
        vector.set(2, "Ngọc"); // Sửa phần tử thứ 3 (vị trí 2)

        // Xóa một phần tử
        vector.remove("Hằng"); // Xóa phần tử "Hằng"

        vector.forEach(item -> System.out.println("Mảng sau khi sửa: "+item));
    }
}
