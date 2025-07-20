class SharedResource {
    // Visibility problem
    //One way is to slove this we use volatile keyword
    private  boolean flag = false;

    // Another way is to use syncronized keyword  with the gettter setter function
    public synchronized boolean isFlag() {
        return flag;
    }

    public synchronized void setFlag(boolean flag) {
        this.flag = flag;
    }
}

public class Volatile_Keyword {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        new Thread(()->{
            System.out.println("Thread 1 stared");
            try {
                System.out.println("Thread 1 logic started");
                Thread.sleep(500);
                System.out.println("Thread 1 logic eneded");
                //hread 1 has updated the flag
                //but thread 2 has not is not stred the logic
                sharedResource.setFlag(true);
                System.out.println("Flag set to true by Thread 1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(()->{
            System.out.println("Thread 2 started");
            while (!sharedResource.isFlag()){
               // System.out.println("Thread 2 logic started");
            }

            System.out.println("Thread 2 logic ended");
        }).start();
    }
}
