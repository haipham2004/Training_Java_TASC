package com.example.Demo_Java_Thread.Thread;
//Sử dụng Thread
public class MultiThreadB extends Thread{

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
        MultiThreadB multiThreadB =new MultiThreadB();

        Thread thread1 = new Thread(multiThreadB);
        Thread thread2 = new Thread(multiThreadB);

        thread1.start();
        thread2.start();
    }
}
