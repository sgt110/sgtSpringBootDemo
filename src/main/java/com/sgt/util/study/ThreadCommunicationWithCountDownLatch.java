package com.sgt.util.study;

import java.util.concurrent.CountDownLatch;

public class ThreadCommunicationWithCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Worker worker = new Worker(countDownLatch);
        worker.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread: " + worker.getResult());
    }

}

class Worker extends Thread {

    private CountDownLatch countDownLatch;
    private int result;

    public Worker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        result = doWork();
        countDownLatch.countDown();
    }

    public int getResult() {
        return result;
    }

    private int doWork() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        return sum;
    }

}
