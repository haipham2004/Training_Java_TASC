package com.example.Demo_JavaCore.oop;

public abstract class DemoC {
    // Có thể chứa biến thành viên
    public int x=20;

    private int y=30;

    protected int  z=40;

    public DemoC() {
    }

    public DemoC(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    abstract void makeSound();

    public void speak(){
        System.out.println("Tu hú");
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
