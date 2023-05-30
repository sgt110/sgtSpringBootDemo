package com.sgt.util.study;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadCommunicationWithCyclicBarrier {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        Worker2 worker1 = new Worker2(cyclicBarrier, 1);
        Worker2 worker2 = new Worker2(cyclicBarrier, 2);
        worker1.start();
        worker2.start();
    }

}

class Worker2 extends Thread {

    private CyclicBarrier cyclicBarrier;
    private int workerId;

    public Worker2(CyclicBarrier cyclicBarrier, int workerId) {
        this.cyclicBarrier = cyclicBarrier;
        this.workerId = workerId;
    }

    public void run() {
        System.out.println("Worker " + workerId + " started working...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Worker " + workerId + " finished working...");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Worker " + workerId + " continued...");
    }

}
