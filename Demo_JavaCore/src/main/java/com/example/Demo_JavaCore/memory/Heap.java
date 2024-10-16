package com.example.Demo_JavaCore.memory;

public class Heap {

    public static void main(String[] args) {
        new Heap().getValue();
    }

    public void getValue() {
        String heapVariable = new String("Heap "); // Biến này được lưu trong heap
        System.out.println("Giá trị của biến heapVariable: " + heapVariable);
    }
}
