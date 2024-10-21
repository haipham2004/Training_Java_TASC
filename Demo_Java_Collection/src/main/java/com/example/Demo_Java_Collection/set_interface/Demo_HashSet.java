package com.example.Demo_Java_Collection.set_interface;

import java.util.HashSet;

public class Demo_HashSet {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hải");
        hashSet.add("Hằng");
        hashSet.add("Khanh");
        hashSet.add("Hải"); // Không thêm vì đã tồn tại
        hashSet.add(null); // Có thể chèn giá trị null
        System.out.println("HashSet: " + hashSet); // Thứ tự không được sắp xếp đúng
    }
}
