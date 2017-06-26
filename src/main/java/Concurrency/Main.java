package Concurrency;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread threadA = new CounterThread(counter);
        Thread threadB = new CounterThread(counter);
        Thread threadC = new CounterThread(counter);
        Thread threadD = new CounterThread(counter);

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        Thread.sleep(1000L);
        System.out.println("final countAtomic: " + counter.countAtomic.get());
    }
}
