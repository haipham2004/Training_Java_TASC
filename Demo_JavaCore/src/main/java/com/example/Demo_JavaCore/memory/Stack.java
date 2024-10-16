package com.example.Demo_JavaCore.memory;

public class Stack {

    public static void main(String[] args) {
        new Stack().getValue();
    }

    public void getValue() {
        int localVariable = 5; // Biến cục bộ này được lưu trong stack
        System.out.println("Giá trị của biến localVariable: " + localVariable);
    }
}
