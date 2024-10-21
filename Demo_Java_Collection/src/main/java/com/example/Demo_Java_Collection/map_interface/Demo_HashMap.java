package com.example.Demo_Java_Collection.map_interface;

import java.util.HashMap;
import java.util.Map;

public class Demo_HashMap {

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);
        hashMap.put("D",null); // có thể chứa value null

        //Thêm phần tử trùng khoá -> Cập nhật giá trị cho khóa "A"
        hashMap.put("A", 4);
        // Có thể có môt khoá null
        hashMap.put(null,10);

        // In các phần tử
        for (String key : hashMap.keySet()) {
            Integer value = hashMap.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }

        System.out.println("Get: "+hashMap.get("C"));

        System.out.println("Remove: "+hashMap.remove("C"));

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Key sau: " + key + ", Value sau: " + value);
        }

    }
}
