package ThreadPool;

import java.util.concurrent.*;

public class ThreadPoolExample {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomRejectHandler());


        for (int i = 1; i <= 8; i++) {

            int finalI = i;
            executor.submit(()->{
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Task " + finalI + " processed by -- " + Thread.currentThread().getName());
            });

        }

        executor.shutdown();


    }
}

class CustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread thn = new Thread(r);
        thn.setPriority(Thread.NORM_PRIORITY);
        thn.setDaemon(false);
        return thn;
    }
}

class CustomRejectHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task is rejected");
    }
}
