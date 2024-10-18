package com.example.Demo_Java_Collection.set_interface;

import java.util.LinkedHashSet;

public class Demo_LinkedHashSet {

    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("Hải");
        linkedHashSet.add("Hằng");
        linkedHashSet.add("Khanh");
        linkedHashSet.add("Hải"); // Không thêm vì đã tồn tại
        System.out.println("LinkedHashSet: " + linkedHashSet); // Thứ tự không được sắp xếp đúng theo thứ tự thênm vào
    }
}
