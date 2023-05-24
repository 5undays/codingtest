package programmers;

import java.util.Arrays;

/**
 * 문자열 잘라서 정렬하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181866
 */
public class PGS_181866 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("axbxcxdx")));
        System.out.println(Arrays.toString(solution("dxccxbbbxaaaa")));
    }

    public static String[] solution(String myString) {
        return Arrays.stream(myString.split("x")).filter(x -> !x.equals("")).sorted().toArray(String[]::new);
    }
}
