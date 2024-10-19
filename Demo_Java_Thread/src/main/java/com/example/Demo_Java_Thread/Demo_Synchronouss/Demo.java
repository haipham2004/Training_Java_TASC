package com.example.Demo_Java_Thread.Demo_Synchronouss;

public class Demo {

    public static String hoatDong1(){
        return "Đánh răng";
    }

    public static String hoatDong2(){
        return "Mặc quần áo";
    }

    public static String hoatDong3(){
        return "Đợi xe bus";
    }

    public static String hoatDong4(){
        return "Lên xe bus";
    }

    public static String hoatDong5(){
        return "Tới cty TASC";
    }

    public static void main(String[] args) {
        System.out.println("Xử lí từng hàng động, kết thúc hoạt động này mới chuyển sang hoạt động khác");
        System.out.println("Hoạt động: " + hoatDong1());
        System.out.println("Hoạt động: " + hoatDong2());
        System.out.println("Hoạt động: " + hoatDong3());
        System.out.println("Hoạt động: " + hoatDong4());
        System.out.println("Hoạt động: " + hoatDong5());
        System.out.println("Kết thúc chương trình");
    }
}
