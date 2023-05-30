package com.sgt.util.study;

public class ParentThread extends Thread {

    private int count;

    public static void main(String[] args) {
        ParentThread parentThread = new ParentThread();
        parentThread.start();
    }

    public synchronized void incrementCount() {
        count++;
        notify();
    }

    public synchronized void waitForCount() throws InterruptedException {
        while (count < 10) {
            wait();
        }
    }

    public void run() {
        ChildThread childThread = new ChildThread(this);
        childThread.start();

        try {
            waitForCount();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Parent Thread: " + count);
    }

    public int getCount() {
        return count;
    }
}

class ChildThread extends Thread {

    private ParentThread parentThread;

    public ChildThread(ParentThread parentThread) {
        this.parentThread = parentThread;
    }

    public void run() {
        while (parentThread.getCount() < 10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            parentThread.incrementCount();
        }
    }
}

