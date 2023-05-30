package com.sgt.service.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.*;

public class Result {


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int everyNum = 7;
        int[] a = new int[67];
        for (int i =1;i<68;i++){
            a[i-1] = i;
        }
        int threadNum = (a.length % everyNum == 0) ? (a.length / everyNum) : (a.length / everyNum + 1);
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        BlockingQueue<Future<List<Integer>>> queue = new LinkedBlockingQueue<>();
        for (int i = 0; i < threadNum; i++) {
            int left = i * everyNum;
            int right = (i + 1) * everyNum-1;
            if (right >= a.length) {
                right = a.length - 1;
            }
            Future<List<Integer>> future = executorService.submit(getJishu(left, right, a));
            queue.add(future);
        }
        List<Integer> result = new ArrayList<>();
        int queueNum = queue.size();
        for (int i = 0; i < queueNum; i++) {
            List<Integer> subResult = queue.take().get();
            result.addAll(subResult);
        }
        System.out.println(result);
        executorService.shutdown();
    }

    private static Callable<List<Integer>> getJishu(int left, int right, int[] a) {
        Callable<List<Integer>> callable = new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                List<Integer> subResultList = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    int num = a[i];
                    if (num % 2 != 0) {
                        subResultList.add(num);
                    }
                }
                return subResultList;
            }
        };
        return callable;
    }


}
