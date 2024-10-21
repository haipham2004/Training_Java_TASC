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
    }
}
