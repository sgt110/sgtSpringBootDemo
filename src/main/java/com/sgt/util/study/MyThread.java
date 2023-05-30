package com.sgt.util.study;

import java.util.ArrayList;
import java.util.List;

public class MyThread extends Thread {
    private List<Integer> list;

    public MyThread(List<Integer> list) {
        this.list = list;
    }

    public void run() {
        synchronized(list) {
            try {
                while(list.size() == 0) {
                    list.wait();
                }
                int num = list.remove(0);
                System.out.println("Consumed: " + num);
                list.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Thread producerThread = new Thread(() -> {
            synchronized(list) {
                for(int i = 1; i <= 10; i++) {
                    list.add(i);
                    System.out.println("Produced: " + i);
                    list.notify();
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread consumerThread = new MyThread(list);
        producerThread.start();
        consumerThread.start();
    }
}

