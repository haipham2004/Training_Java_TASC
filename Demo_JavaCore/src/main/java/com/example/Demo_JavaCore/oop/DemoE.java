package com.example.Demo_JavaCore.oop;
// Kế thừa abstract class Demo C và implements interface D: có cùng tên phươnng thức, cùng kiểu trả về
public class DemoE extends DemoC implements DemoD  {
    @Override
    void makeSound() {
        System.out.println("haha");
    }

    public static void main(String[] args) {
        System.out.println("Result: ");
        new DemoE().makeSound();
    }
}
