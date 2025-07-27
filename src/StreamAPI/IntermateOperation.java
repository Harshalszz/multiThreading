package StreamAPI;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermateOperation {

    public static void main(String[] args) {

        Stream<String> newStream = Stream.of("hello", "asdasd", "df","tyty","dsfdfsdf");
        System.out.println(newStream);
        Stream<String> fitteredStream = newStream.filter((String str) -> str.length()>3);
        System.out.println(fitteredStream);
        List<String> finalStream = fitteredStream.toList();
        // we cannot use the filterSTream again as it was closed above.
        // jvm will trhow the exception
        //Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        //List<String> finalStream2 = fitteredStream.collect(Collectors.toList());
        System.out.println(finalStream);
        //System.out.println(finalStream2);
    }
}
