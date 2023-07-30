package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 접미사 배열
 * https://school.programmers.co.kr/learn/courses/30/lessons/181909
 */
public class PGS_181909 {
    public static void main(String[] args) {
        PGS_181909 pgs_181909 = new PGS_181909();
        System.out.println(Arrays.toString(pgs_181909.solution2("banana")));
    }

    public String[] solution(String my_string) {
        String[] answer = new String[my_string.length()];
        for (int i = my_string.length() - 1; i >= 0; i--) {
            answer[i] = my_string.substring(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    public String[] solution2(String my_string) {
        return IntStream.range(0, my_string.length())
                .mapToObj(my_string::substring)
                .sorted()
                .toArray(String[]::new);
    }
}
