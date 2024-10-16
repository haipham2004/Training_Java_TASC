package com.example.Demo_JavaCore.primitive_object_data_type;

public class Demo {

    int a = 10;
    Integer b = Integer.valueOf(a);

    Integer c = 20;
    int d = c.intValue();

    int m;

    Integer n;

    public static void main(String[] args) {
        System.out.println("int ->Integer: " + new Demo().b);
        System.out.println("Integer ->int: " + new Demo().d);
        System.out.println("Giá trị khởi tạo kiểu nguyên thuỷ: "+new Demo().m);// mặc đinh là 0
        System.out.println("Giá trị khởi tạo kiểu đối tượng: "+new Demo().n); // mặc định là null
        System.out.println("So sánh nguyên thuỷ: "+(new Demo().b==10));
        System.out.println("So sánh Đối tượng: "+(new Demo().b.equals(10)));

    }
}
