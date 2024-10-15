package com.example.Demo_JavaCore.string;

public class Demo {

    public static void main(String[] args) {
        // Tạo biến string;
        String h1="Phạm Ngọc Hải";

        String h2=new String("Hải Phạm");

        char[] chars = {'H', 'a', 'i', 'y', 'k','a'};
        String h3 = new String(chars);

        String h4=new String("Hải Phạm");
        //So sánh
        System.out.println("Result (==): "+(h1==h2));

        System.out.println("Result (equals): "+(h2.equals(h4)));

        System.out.println("Result (compareTo): "+(h2.compareTo(h4)));
    }
}
