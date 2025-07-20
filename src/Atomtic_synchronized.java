import java.util.concurrent.atomic.AtomicInteger;

class SharedInteger {
    //race condition will occur
    //we can use atomic Integer keyword

    //private int counter;

    private AtomicInteger counter = new AtomicInteger(0);

    public int getCounter() {
        return counter.get();
    }

//    public void increment() {
//        counter++;
//    }
    public void increment(){
        counter.incrementAndGet();
    }
}

public class Atomtic_synchronized {

    public static void main(String[] args) {

        SharedInteger sharedInteger = new SharedInteger();

        Thread t1 = new Thread(()->{
            System.out.println("Thread 1 stared");
            for (int i = 0; i < 50000; i++) {
                sharedInteger.increment();

            }
            System.out.println("Thread 1 completed");
        });

        Thread t2 = new Thread(()->{
            System.out.println("Thread 2 started");
            for (int i = 0; i < 50000; i++) {
                sharedInteger.increment();

            }
            System.out.println("Thread 2 completed");
        });

        t1.start();
        t2.start();

        try {
            t1.join();  // Wait for thread 1 to finish
            t2.join();  // Wait for thread 2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter: " + sharedInteger.getCounter());
    }
}
