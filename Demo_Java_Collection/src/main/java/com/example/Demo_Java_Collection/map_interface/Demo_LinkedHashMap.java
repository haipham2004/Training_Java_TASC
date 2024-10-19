package com.example.Demo_Java_Collection.map_interface;

import java.util.LinkedHashMap;

public class Demo_LinkedHashMap {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // Thêm cặp khóa-giá trị
        linkedHashMap.put("A", 1);
        linkedHashMap.put("B", 2);
        linkedHashMap.put("C", 3);
        linkedHashMap.put("D",null); // có thể chứa value null

        //Thêm phần tử trùng khoá -> Cập nhật giá trị cho khóa "A"
        linkedHashMap.put("A", 4);

        // In các phần tử: Nó giống HashMap nhưng sẽ duy trì thứ tự thêm vào
        System.out.println("LinkedHashMap: " + linkedHashMap);
    }
}
