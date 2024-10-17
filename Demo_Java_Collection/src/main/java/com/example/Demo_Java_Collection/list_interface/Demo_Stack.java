package com.example.Demo_Java_Collection.list_interface;

import java.util.Stack;

public class Demo_Stack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack sau khi thêm phần tử: " + stack);

        System.out.println("Phần tử ở đỉnh Stack: " + stack.peek());

        System.out.println("Phần tử bị xóa: " + stack.pop());
        System.out.println("Stack sau khi xóa phần tử: " + stack);


        if (stack.isEmpty()) {
            System.out.println("Stack hiện đang rỗng.");
        } else {
            System.out.println("Stack không rỗng.");
        }


        System.out.println("Các phần tử trong Stack:");
        for (Integer element : stack) {
            System.out.println(element);
        }
    }
    }

