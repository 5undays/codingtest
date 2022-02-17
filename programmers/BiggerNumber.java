package programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42746
public class BiggerNumber {

    public static void main(String args[]) {
        BiggerNumber biggerNumber = new BiggerNumber();
        System.out.println(biggerNumber.solution(new int[] { 6, 10, 2 }));
        System.out.println(biggerNumber.solution(new int[] { 3, 30, 34, 5, 9 }));
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