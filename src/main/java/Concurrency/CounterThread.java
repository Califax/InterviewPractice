package Concurrency;

public class CounterThread extends Thread {
    private final Counter counter;

    public CounterThread(Counter counter){
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
//            System.out.println(this + " " + counter.count);
        }
    }
}
