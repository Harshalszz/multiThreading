// this is a traditional way or legacy way
//class MyThread extends Thread{
//
//
//    public void run() {
//        System.out.println("Thread 1 is running");
//    }
//}

public class CreateThread {

    public static void main(String[] args) {
        System.out.println("Multi threading");

//        MyThread objThread = new MyThread();
//        objThread.start();
//
//        System.out.println(objThread.getState());

        //it is recommended to use functional programming using lambda expression
        // this is also not an efficient  way to do this
        Thread objThread2 = new Thread(() ->{
            System.out.println("Thread 2 is running");
        });

        objThread2.start();

        // Use runnable interface for this creating the thread
        //here we are using new keyword

        Runnable objRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 3 is running ");
            }
        };

        Thread objThread3 = new Thread(objRunnable,"Thread 3 Running");
        objThread3.start();


        // As Runnbale is a functioal interface it has only one methon that is run()
        // So we can use lambda funtion for this

        Runnable objNew = () ->{
            System.out.println("Thread 4 is Running using runnable and lambda fun");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread 4 is completed");
        };

        Thread objThread4 = new Thread(objNew,"Thread 4 Running");
        //objThread4.setDaemon(true); // main thread will not wait for the thread completionation.
        objThread4.start();

        System.out.println("Main thread completed");

    }
}
