package example;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) throws IOException {
        String[] arr = new String[] { "a", "b", "c" };
        Stream<String> stream = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
        
        List<String> list = Arrays.asList(arr);
        Stream<String> steam2 = list.stream();
        Stream<String> parallelStream = list.parallelStream(); // 병렬 처리 스트림

        Stream<String> builderStream = Stream.<String>builder().add("a").add("b").add("c").build();

        Stream<String> generatedStream = Stream.generate(()-> "gen").limit(5);

        Stream<Integer> iteratedStream = Stream.iterate(30, n->n+2).limit(5);

        IntStream intStream = IntStream.range(1, 5);
        LongStream longStream = LongStream.rangeClosed(1, 5);

        Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed();
    
        DoubleStream doubles = new Random().doubles(3);
        
        IntStream charsStream = "Stream".chars();
        Stream<String> stringStream = Pattern.compile(", ").splitAsStream("Eric, Elena, Java");
        Stream<String> lineStream = Files.lines(Paths.get("file.txt"), Charset.forName("UTF-8"));

        Collection<String> productList;
        Stream<Product> parallelStream2 = productList.parallelStream(); // 병렬 스트림 생성
        boolean isParallel = parallelStream.isParallel(); // 병렬 여부 확인

        boolean isMany = parallelStream.map(product -> product.getAmount() * 10).anyMatch();
        Stream<String> stream1 = Stream.of("java", "Scala", "Groovy");
        Stream<String> stream2 = Stream.of("Python", "Go", "Swift");
        Stream<String> concat = Stream.concat(stream1, stream2);

        List<String> names = Arrays.asList("Eric", "Elena", "Steve");
        Stream<String> stream3 = names.stream().filter(name -> name.contains("e"));

        Stream<String> stream4 = names.stream().map(String::toUpperCase);

        //Stream<Integer> stream5 = productList.stream().
    }
}
