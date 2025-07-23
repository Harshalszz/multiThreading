



public class SleepExample {
    public void attack() {
        System.out.println("Enemy is preparing to attack...");
        try {
            Thread.sleep(3000); // Pause for 3 seconds
        } catch (InterruptedException e) {
            System.out.println("Enemy's attack preparation was interrupted!");
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
        System.out.println("Enemy attacks!");
    }
    public static void main(String[] args) {
        SleepExample goblin = new SleepExample();
        new Thread(goblin::attack).start(); // Start enemy attack in a new thread
        System.out.println("Player is ready for the attack.");
        // Player might do something else here while enemy prepares
    }

}
