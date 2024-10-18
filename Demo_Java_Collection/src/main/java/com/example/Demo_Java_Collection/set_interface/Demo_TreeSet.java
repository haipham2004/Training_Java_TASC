package com.example.Demo_Java_Collection.set_interface;

import java.util.TreeSet;

public class Demo_TreeSet {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Hải");
        treeSet.add("Hằng");
        treeSet.add("Anh");
        treeSet.add("Hải"); // Không thêm vì đã tồn tại
        System.out.println("TreeSet: " + treeSet); // sắp xếp theo chữ cái
    }
}
