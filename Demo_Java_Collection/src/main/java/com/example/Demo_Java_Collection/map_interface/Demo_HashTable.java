package com.example.Demo_Java_Collection.map_interface;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Demo_HashTable {

    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        hashtable.put("A", 1);
        hashtable.put("B", 2);
        hashtable.put("C", 3);
        hashtable.put("D",4);
        //Khoá không được phép null;
        hashtable.put(null,22); // sẽ báo lỗi


        for (String key : hashtable.keySet()) {
            Integer value = hashtable.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }

        System.out.println("Get: "+hashtable.get("C"));

        System.out.println("Remove: "+hashtable.remove("C"));

        for (Map.Entry<String, Integer> entry : hashtable.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Key sau: " + key + ", Value sau: " + value);
        }


    }
}
