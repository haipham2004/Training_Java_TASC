package com.example.Demo_Java_Collection.list_interface;

import com.example.Demo_Java_Collection.array.Array;

import java.util.ArrayList;

public class Demo_ArrayList {

    public static void main(String[] args) {
        //ArrayList lưu được nhiều kiểu dữ liệu
        ArrayList<Object> arrayList=new ArrayList<>();
        arrayList.add("Hải");
        arrayList.add("Hằng");
        arrayList.add("Khanh");
        arrayList.add(3010);

        arrayList.add(0,2502);// Chen vào vị trí đầu tiên

        arrayList.set(1,7777 );// Sửa vị trí thứ 2 của mảng

        System.out.println("Truy cập phần tử: "+ arrayList.get(2));

        arrayList.forEach(obj -> System.out.println("Danh sách mảng là: "+obj));

        arrayList.remove(3);//Xoá phần tử

        System.out.println("Array sau khi xoá: "+arrayList);

    }

}
