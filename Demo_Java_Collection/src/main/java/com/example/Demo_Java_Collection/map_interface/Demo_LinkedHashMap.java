package com.example.Demo_Java_Collection.map_interface;

import java.util.LinkedHashMap;

public class Demo_LinkedHashMap {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // Thêm cặp khóa-giá trị
        linkedHashMap.put("A", 1);
        linkedHashMap.put("B", 2);
        linkedHashMap.put("C", 3);

        // In các phần tử
        System.out.println("LinkedHashMap: " + linkedHashMap);
    }
}
