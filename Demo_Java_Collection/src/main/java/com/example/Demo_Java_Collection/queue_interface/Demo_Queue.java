package com.example.Demo_Java_Collection.queue_interface;

import java.util.LinkedList;
import java.util.Queue;

public class Demo_Queue {

    public static void main(String[] args) {

        Queue<Object> queue = new LinkedList<>();

        // Thêm phần tử vào hàng đợi
        queue.offer("Hải");
        queue.add("Hằng");
        queue.add("Khanh");
        queue.add(30102004);

        // In các phần tử trong hàng đợi
        System.out.println("Hàng đợi sau khi thêm phần tử: " + queue);

        // Lấy phần tử đầu tiên mà không xóa

        System.out.println("Phần tử đầu tiên trong hàng đợi: " + queue.peek());

        // Xóa phần tử đầu tiên

        System.out.println("Đã xóa phần tử: " + queue.poll());
        System.out.println("Hàng đợi sau khi xóa: " + queue);

        // Kiểm tra kích thước của hàng đợi
        System.out.println("Kích thước : " + queue.size());

        // Kiểm tra xem hàng đợi có rỗng không
        boolean isEmpty = queue.isEmpty();
        System.out.println("Có rỗng không " + isEmpty);
    }

}
