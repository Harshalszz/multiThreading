package StreamAPI;

import java.util.ArrayList;
import java.util.List;

public class StreamExample {

    public static void main(String[] args) {

        List<Integer> salarys = new ArrayList<>();
        salarys.add(3000);
        salarys.add(7000);
        salarys.add(2000);
        salarys.add(6000);
        salarys.add(1000);
        salarys.add(7000);
        salarys.add(8000);
        salarys.add(9000);

        //first start the stream
        // use the intermidate opreration
        //and then use the terminate operation
        long output = salarys.stream()
                .filter((Integer sal) -> sal>3000)
                .count();

        long output2 = salarys.stream()
                        .distinct().count();
                                

        System.out.println(output);

        System.out.println("outupiut 2" + output2);
    }
}
