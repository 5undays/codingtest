package example;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) throws IOException {
        // 배열 스트림
        String[] arr = new String[] { "a", "b", "c" };
        Stream<String> stream = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

        // 컬랙션 스트림
        List<String> list = Arrays.asList(arr);
        Stream<String> steam2 = list.stream();
        Stream<String> parallelStream = list.parallelStream(); // 병렬 처리 스트림

        // 스트림 빌더
        Stream<String> builderStream = Stream.<String>builder().add("a").add("b").add("c").build();

        Stream<String> generatedStream = Stream.generate(() -> "gen").limit(5);

        Stream<Integer> iteratedStream = Stream.iterate(30, n -> n + 2).limit(5);

        IntStream intStream = IntStream.range(1, 5);
        LongStream longStream = LongStream.rangeClosed(1, 5);

        Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed();

        DoubleStream doubles = new Random().doubles(3);

        // 문자열 스트림
        IntStream charsStream = "Stream".chars();
        Stream<String> stringStream = Pattern.compile(", ").splitAsStream("Eric, Elena, Java");

        // 파일 스트림
        Stream<String> lineStream = Files.lines(Paths.get("file.txt"), Charset.forName("UTF-8"));

        // 병렬 스트림
        // Stream<Product> parallelStream2 = productList.parallelStream(); // 병렬 스트림 생성
        boolean isParallel = parallelStream.isParallel(); // 병렬 여부 확인
        Arrays.stream(arr).parallel(); // 배열을 이용하여 병렬 스트림 생성
        intStream.parallel(); // 배열이 아닌 경우 병렬 스트림 생성
        intStream.parallel().isParallel(); // 병렬 스트림 생성 확인

        // 스트림 연결
        Stream<String> stream1 = Stream.of("java", "Scala", "Groovy");
        Stream<String> stream2 = Stream.of("Python", "Go", "Swift");
        Stream<String> concat = Stream.concat(stream1, stream2);

        List<String> names = Arrays.asList("Eric", "Elena", "Steve");

        // filtering
        Stream<String> stream3 = names.stream().filter(name -> name.contains("e"));

        // mapping
        Stream<String> stream4 = names.stream().map(String::toUpperCase);

        // flattening
        List<List<String>> list2 = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
        List<String> flattening = list2.stream().flatMap(Collection::stream).collect(Collectors.toList());

        // Sorting
        IntStream.of(14, 11, 20, 39, 23).sorted().boxed().collect(Collectors.toList());

        List<String> lang = Arrays.asList("Java", "Scala", "Groovy", "Go", "Swift");

        lang.stream().sorted().collect(Collectors.toList());
        lang.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        lang.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        lang.stream().sorted((s1, s2) -> s2.length() - s1.length()).collect(Collectors.toList());

        // Iterating
        int sum = IntStream.of(1, 3, 5, 7, 9).peek(System.out::println).sum();

        // Calculating
        long count = IntStream.of(1, 3, 5, 7, 9).count();
        long sum2 = LongStream.of(1, 3, 5, 7, 9).sum();
        OptionalInt min = IntStream.of(1, 3, 5, 7, 9).min();
        OptionalInt max = IntStream.of(1, 3, 5, 7, 9).max();
        DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5).average().ifPresent(System.out::println);

        // Reduction
        OptionalInt reduced = IntStream.range(1, 4)
                .reduce((a, b) -> {
                    return Integer.sum(a, b);
                }); // 6
        int reducedTwoParams = IntStream.range(1, 4)
                .reduce(10, Integer::sum); // 16

        int reduceParams = Stream.of(1, 2, 3).reduce(10, Integer::sum, (a, b) -> {
            System.out.println("combiner was called");
            return a + b;
        });

        List<Product> productList = Arrays.asList(new Product(23, "potatoes"), new Product(14, "orange"),
                new Product(13, "lemon"), new Product(23, "bread"), new Product(13, "sugar"));

        List<String> collectorCollection = productList.stream().map(Product::getName).collect(Collectors.toList());
        String listToString = productList.stream().map(Product::getName).collect(Collectors.joining());

        String listTOString2 = productList.stream().map(Product::getName).collect(Collectors.joining(",", "<", ">"));

        Double averageAmount = productList.stream().collect(Collectors.averagingInt(Product::getAmout)); // 17.2

        Integer summingAmount = productList.stream().collect(Collectors.summingInt(Product::getAmout)); // 86

        IntSummaryStatistics statistics = productList.stream().collect(Collectors.summarizingInt(Product::getAmout));
        
        Map<Integer, List<Product>> collectorMapLists = productList.stream().collect(Collectors.groupingBy(Product::getAmout));

        //Collectors.partitioningBy()
        Map<Boolean, List<Product>> mapPartitioned = productList.stream().collect(Collectors.partitioningBy(el -> el.getAmout() > 15));

        Set<Product> unmodifiableSet = productList.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));

        Collector<Product, ?, LinkedList<Product>> toLinkedList = Collector
        .of(LinkedList::new, LinkedList::add, (first, second) -> {
            first.addAll(second);
            return first;
        });
        LinkedList<Product> linkedListPersons = productList.stream().collect(tol)
    
        List<String> names = Arrays.asList("Eric", "Elena", "Java");

        // match
        boolean anyMatch = names.stream().anyMatch(name -> name.contains("a")); // true
        boolean allMatch = names.stream().allMatch(name -> name.length() > 3); // true
        boolean noneMatch = names.stream().noneMatch(name -> name.endsWith("s")); // true

        // Iterate
        names.stream().forEach(System.out::println);

        // findFirst
        List<String> aa = names.stream().filter(al -> {
            System.out.println("filter() was callled");
            return al.contains("a");
        })
        .map(el -> {
            System.out.println("map() was called");
            return el.toUpperCase();
        })
        .findAny();

        List<String> collect = names.stream().skip(2).map(el -> {
            aa();
            return el.substring(0,3);
        })
        .skip(2)
        .collect(Collectors.toList());

        System.out.println(collect);

        Stream<String> stream5 = Stream.of("Eric", "Elena", "Java").filter(name -> name.contains("a"));

        Optional<String> firstElement = stream.findFirst();
        Optional<String> anyElement = stream.findAny();

        List<String> nullList = null;

        //nullList.stream().filter(str -> str.contains("a")).map(String::length).forEach(System.out::println); // NullPointException


    }

}
