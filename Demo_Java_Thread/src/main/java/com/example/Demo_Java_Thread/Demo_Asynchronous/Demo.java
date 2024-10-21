package com.example.Demo_Java_Thread.Demo_Asynchronous;

public class Demo implements Runnable {

    @Override
    public void run() {
        count();
    }

    //Bất đồng bộ
    private void count() {
        int i = 1;

        while (i <= 100) {
            System.out.printf("%d ", i);

            if (i % 10 == 0) {
                System.out.println();
            }
            i++;
            try {
                Thread.sleep(300);
            } catch (InterruptedException interruptedException) {
                 interruptedException.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Demo demo = new Demo();

        Thread thread1 = new Thread(demo);
        Thread thread2 = new Thread(demo);

        thread1.start();
        thread2.start();
    }


}
