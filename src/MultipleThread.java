public class MultipleThread {

    //shraed object
    public static Object SharedObject = new Object();

    public static void main(String[] args) {



        Runnable objNew1 = () ->{
            System.out.println("Thread 1 is Running using runnable and lambda fun");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());
            System.out.println(SharedObject.hashCode());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread 1 is completed");
        };

        Runnable objNew2 = () ->{
            System.out.println("Thread 2 is Running using runnable and lambda fun");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());

            System.out.println(SharedObject.hashCode());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread 2 is completed");
        };

        Thread objThread1 = new Thread(objNew1,"Runnable Thread 1 ");
        objThread1.start();

        Thread objThread2 = new Thread(objNew2, "Runnable Thread 2");
        objThread2.start();

        System.out.println("Main thread completed");
    }
}
