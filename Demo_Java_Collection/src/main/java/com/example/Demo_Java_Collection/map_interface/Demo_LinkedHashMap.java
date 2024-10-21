package com.example.Demo_Java_Collection.map_interface;

import java.util.LinkedHashMap;
import java.util.Map;

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

        //Có thể chứa 1 khoá null
        linkedHashMap.put(null,100);

        // In các phần tử: Nó giống HashMap nhưng sẽ duy trì thứ tự thêm vào
        for (String key : linkedHashMap.keySet()) {
            Integer value = linkedHashMap.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }

        System.out.println("Get: "+linkedHashMap.get("C"));

        System.out.println("Remove: "+linkedHashMap.remove("C"));

        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Key sau: " + key + ", Value sau: " + value);
        }

    }
}
