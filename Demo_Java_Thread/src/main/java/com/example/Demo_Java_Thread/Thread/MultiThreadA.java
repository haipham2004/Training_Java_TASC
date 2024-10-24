package com.example.Demo_Java_Thread.Thread;

// Sử dụng Runnable
public class MultiThreadA implements Runnable{
    @Override
    public void run() {
         demo();
    }

    private void demo(){
        for(int i=0;i<10;i++){
            System.out.println("Xin chào Hải Phạm YKA: "+i);
            try {
               Thread.sleep(300);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MultiThreadA multiThreadA =new MultiThreadA();

        Thread thread1 = new Thread(multiThreadA);
        Thread thread2 = new Thread(multiThreadA);

        thread1.start();
        thread2.start();


        try {
            // Chờ cho đến khi cả hai thread chạy xong
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Kiểm tra trạng thái thread
        if (!thread1.isAlive() && !thread2.isAlive()) {
            System.out.println("Tất cả các thread đã hoàn thành");
        }

    }
}
