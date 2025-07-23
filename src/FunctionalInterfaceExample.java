import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // Using Predicate to check if a number is even
        Predicate<Integer> isEven = number -> number % 2 == 0; // Lambda expression implements test(Integer)
        System.out.println("Is 4 even? " + isEven.test(4)); // Output: true
        System.out.println("Is 7 even? " + isEven.test(7)); // Output: false
// Example with filtering a list
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Anna");
        names.add("Charlie");
        Predicate<String> startsWithA = name -> name.startsWith("A");
        System.out.println("Names starting with 'A':");
        names.stream()
                .filter(startsWithA) // Using the Predicate
                .forEach(System.out::println);
        // Output:
        // Alice
        // Anna
    }
}
