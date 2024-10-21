package com.example.Demo_Java_Collection.map_interface;

import java.util.Map;
import java.util.TreeMap;

public class Demo_TreeMap {

    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        // Thêm cặp khóa-giá trị
        treeMap.put("B", 2);
        treeMap.put("A", 1);
        treeMap.put("C", 3);
        treeMap.put("D",null); // có thể chứa value null

        //Thêm phần tử trùng khoá -> Cập nhật giá trị cho khóa "A"
        treeMap.put("A", 4);
        //Khoá không được null
        treeMap.put(null,100);// sẽ báo lỗi

        // In các phần tử theo thứ tự tự nhiên: Nó săó xêp theo thứ tự chỉ định
        // In các phần tử
        for (String key : treeMap.keySet()) {
            Integer value = treeMap.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }

        System.out.println("Get: "+treeMap.get("C"));

        System.out.println("Remove: "+treeMap.remove("C"));

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Key sau: " + key + ", Value sau: " + value);
        }

    }
}
