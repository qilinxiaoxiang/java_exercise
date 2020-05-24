package lambda;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalTest {
    public void testFunctional() {
        Function<String, String> function = x -> x + x;
        Stream<String> stream = Stream.of("a", "b", "c");
        List<String> collect = stream.map(Function.identity()).map(function).collect(Collectors.toList());
        Predicate<String> predicate = str -> str.startsWith("S");
        List<String> list = Stream.generate(String::new).limit(10).peek(System.out::println).collect(Collectors.toList());
        System.out.println(list.size());
    }
}
