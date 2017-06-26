package Concurrency;

public class CounterThreadRunnable implements Runnable {

    Counter counter;

    CounterThreadRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.add(i);
            try {
                Thread.sleep(100l);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
