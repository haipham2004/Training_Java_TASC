package com.example.Demo_Java_Collection.array;

public class Array {
    int[] arr; // Khai báo mảng số nguyên
    String[] strArr; // Khai báo mảng chuỗi

    static int[] arrs = new int[5]; // Khởi tạo mảng có 5 phần tử

    static String[] name = {"Hai", "Hằng", "Khanh"}; // Khởi tạo mảng với giá trị

    public static void main(String[] args) {

        System.out.println("Giá trị của mảng là: "+name[1]); //Truy cập nhanh thông qua chỉ số
//        System.out.println("Giá trị của mảng  là: "+name[3]); //Truy cập nhanh thông qua chỉ số vượt quá độ dài sẽ lỗi

        arrs[0]=10;
        arrs[1]=20;
        arrs[2]=30;
        arrs[3]=40;
//        arrs[4]="ahihi";// Chỉ lưu trữ được 1 loại dữ liệu
//        arrs[5]=60;  // mảng vượt quá kích thước cố định là 5 phần từ nên sẽ lỗi

        for (int x:arrs){
            System.out.println("Giá trị mảng arra: "+x);
        }

    }
}
