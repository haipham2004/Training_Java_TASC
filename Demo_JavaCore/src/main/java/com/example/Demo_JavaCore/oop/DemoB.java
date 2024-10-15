package com.example.Demo_JavaCore.oop;

public class DemoB  extends DemoA{

    int k=100;


    public DemoB(int a, int b, int c, int d, int k) {
        super(a, b, c, d);// Super để gọi con constructor của lớp cha
        this.k = k; //This: Tham chiếu đến biến thành viên
    }

    public static void main(String[] args) {

        //Đây là instance của Class DemoA
        DemoA demoA=new DemoA();

        System.out.println("Biến public: "+new DemoA().a);
        //Truy cập qua getter
        System.out.println("Biến private: "+new DemoA().getB());

        System.out.println("Biến protectd: "+new DemoA().c);

        System.out.println("Biến default: "+new DemoA().d);
    }

    @Override
    public void speak() {
        super.speak(); // super truy câp tới phương thức của lớp cha
    }
}
