package Concurrency;

import java.util.concurrent.*;

public class ExecService {
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    void runThreads() throws ExecutionException, InterruptedException {
        Counter counter = new Counter();
        Thread threadA = new CounterThread(counter);
        Thread threadB = new CounterThread(counter);
        Thread threadC = new CounterThread(counter);
        Thread threadD = new Thread(new CounterThreadRunnable(counter));

        executorService.submit(threadA);
        executorService.submit(threadB);
        executorService.submit(threadC);
        executorService.submit(threadD);
        Future<String> submit = executorService.submit(() -> "Future String");


        executorService.shutdown();
        System.out.println("submit.get() = " + submit.get());

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecService execService = new ExecService();
        execService.runThreads();
    }
}
