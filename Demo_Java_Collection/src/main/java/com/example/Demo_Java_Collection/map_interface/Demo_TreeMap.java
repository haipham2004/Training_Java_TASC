package com.example.Demo_Java_Collection.map_interface;

import java.util.TreeMap;

public class Demo_TreeMap {

    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        // Thêm cặp khóa-giá trị
        treeMap.put("B", 2);
        treeMap.put("A", 1);
        treeMap.put("C", 3);

        // In các phần tử theo thứ tự tự nhiên
        System.out.println("TreeMap: " + treeMap);
    }
}
