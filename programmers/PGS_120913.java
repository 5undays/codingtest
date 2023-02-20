package programmers;

import java.util.Arrays;

/**
 * 잘라서 배열로 저장하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120913
 */
public class PGS_120913 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("abc1Addfggg4556b", 6)));
    }

    public static String[] solution(String my_str, int n) {
        String[] answer = my_str.split("(?<=\\G.{" + n + "})");
        return answer;
    }
}
