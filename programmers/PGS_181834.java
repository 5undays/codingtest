package programmers;

import java.util.stream.Collectors;

/**
 * l로 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181834
 */
public class PGS_181834 {
    public static void main(String[] args) {

    }

    public String solution(String myString) {
        StringBuilder answer = new StringBuilder(myString);
        for (int i = 0; i < myString.length(); i++) {
            if (answer.toString().charAt(i) < 'l') {
                answer.setCharAt(i, 'l');
            }
        }
        return answer.toString();
    }

    public String solution1(String myString) {
        return myString.chars()
                .mapToObj(i -> Character.toString(Integer.max(i, 'l')))
                .collect(Collectors.joining());
    }
}
