package com.example.Demo_Java_Collection.map_interface;

import java.util.HashMap;

public class Demo_HashMap {

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);

        // Cập nhật giá trị cho khóa "A"
        hashMap.put("A", 4);

        // In các phần tử
        System.out.println("HashMap: " + hashMap);
    }
}
