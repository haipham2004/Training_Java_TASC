package com.example.Demo_Java_Collection.list_interface;

import java.util.ArrayList;
import java.util.LinkedList;

public class Demo_LinkedList {

    public static void main(String[] args) {
        //LinkedList lưu được nhiều kiểu dữ liệu
        LinkedList<Object> linkedList = new LinkedList();


        linkedList.addFirst("Hải");
        linkedList.add("Hằng");
        linkedList.add("Khanh");
        linkedList.addLast("3010");

        System.out.println("Phần tử đầu: "+linkedList.getFirst());

        System.out.println("Phần tử cuối: "+linkedList.getLast());


        linkedList.forEach(item -> System.out.println("Danh sách: "+item));


        linkedList.removeFirst();

        linkedList.removeLast();

        linkedList.forEach(item -> System.out.println("Danh sách sau xoá: "+item));

    }
}
