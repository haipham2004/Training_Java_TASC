package com.example.Demo_JavaCore.oop;
// Đây là class chứa hành vi và thuộc tính
public class DemoA {

    public int a=10;

    private int b=20;

    protected int c=30;

    int d=40;

    public DemoA() {
    }

    public void speak(){
        System.out.println("HuHu");
    }
    // Class Demo B không thể kế thưa phương thức final này
    final void play(){
        System.out.println("football");
    }

    public DemoA(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
}
