package com.example.Demo_Java_Collection.queue_interface;

import java.util.ArrayDeque;
import java.util.Deque;

public class Demo_Dequeue {

    public static void main(String[] args) {

        Deque<Object> deque = new ArrayDeque<>();

        // Thêm phần tử vào đầu và cuối Deque
        deque.offerFirst("Hải");
        deque.add(3010);
        deque.addLast("Hằng");


        // In các phần tử trong Deque
        System.out.println("Deque sau khi thêm phần tử: " + deque);

        // Lấy phần tử đầu tiên mà không xóa
        System.out.println("Phần tử đầu tiên trong Deque: " + deque.peekFirst());

        // Lấy phần tử cuối cùng mà không xóa

        System.out.println("Phần tử cuối cùng trong Deque: " + deque.peekLast());

        // Xóa phần tử đầu tiên

        System.out.println("Đã xóa phần tử đầu tiên: " + deque.pollFirst());
        System.out.println("Deque sau khi xóa phần tử đầu tiên: " + deque);

        // Xóa phần tử cuối cùng
        System.out.println("Đã xóa phần tử cuối cùng: " + deque.pollLast());
        System.out.println("Deque sau khi xóa phần tử cuối cùng: " + deque);

        // Kiểm tra kích thước của Deque
        System.out.println("Kích thước Deque: " + deque.size());

        // Kiểm tra xem Deque có rỗng không
        boolean isEmpty = deque.isEmpty();
        System.out.println("Deque có rỗng không? " + isEmpty);
    }
}
