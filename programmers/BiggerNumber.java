package programmers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://programmers.co.kr/learn/courses/30/lessons/42746
public class BiggerNumber {

    public static void main(String args[]) {
        BiggerNumber biggerNumber = new BiggerNumber();
        System.out.println(biggerNumber.solution(new int[] { 6, 10, 2 }));
        System.out.println(biggerNumber.solution(new int[] { 3, 30, 34, 5, 9 }));
    }

    public String solution2(int[] numbers) {
        // IntStream.of(numbers).mapToObj(n -> String.valueOf(n));
        String answer = IntStream.of(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
                .collect(Collectors.joining());

        String[] arr = new String[numbers.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numbers[i] + "";
        }

        Arrays.sort(arr, (a1, a2) -> (a2 + a1).compareTo(a1 + a2));

        for (String data : arr) {
            answer += data;
        }
        return answer;
    }

    // TODO : 배열 의 값들을 이어 붙여서 가장 큰 수를 만드는 방법
    public String solution(int[] numbers) {
        String answer = "";
        // 숫자를 컬렉션 리스트에 자료형 string 으로 입력한다
        List<String> arr = new ArrayList<>();
        for (int number : numbers) {
            arr.add(number + "");
        }

        // 컬렉션 정렬을 내림차순으로 정렬한다
        Collections.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // 0으로 시작하는 경우에 예외처리를 해준다 (전부 0인 데이터가 들어올경우)
        if (arr.get(0).startsWith("O"))
            return "0";

        // 정렬 된 숫자를 합쳐준다
        for (String data : arr) {
            answer += data;
        }
        return answer;
    }
}