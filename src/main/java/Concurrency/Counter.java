package Concurrency;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Counter {

    long count = 0L;
    AtomicLong countAtomic = new AtomicLong(0L);

    // If it wasn't synchronized it isn't thread safe becaude count is a local instance variable that may be updated
    // simultaneously resulting in the wrong output. Code like this is called a critical section.
    public synchronized void add(long value) {
        this.count += value;
        System.out.println("Thread: " + Thread.currentThread().getName() + " count: " + count);
    }

    public void addAtomic(long value) {
//        boolean valueChanged = false;
        countAtomic.addAndGet(value); // remove this use the retry logic to be sure it works
//        while (!valueChanged) {
//            long currVal = countAtomic.get();
//            long nextVal = currVal + value;
//            if (countAtomic.compareAndSet(currVal, nextVal)) {
//                valueChanged = true;
//            }
//        }
        System.out.println("Thread: " + Thread.currentThread().getName() + " countAtomic: " + countAtomic);
    }
}
