package programmers;

import java.util.Arrays;

/**
 * 배열 회전시키기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120844
 */
public class PGS_120844 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3}, "right")));
        System.out.println(Arrays.toString(solution(new int[]{4, 455, 6, 4, -1, 45, 6}, "left")));
    }

    public static int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        if (direction.equals("right")) {
            answer[0] = numbers[numbers.length - 1];
            for (int i = 1; i < numbers.length; i++) {
                answer[i] = numbers[i - 1];
            }
        } else {
            for (int i = 0; i < numbers.length - 1; i++) {
                answer[i] = numbers[i + 1];
            }
            answer[numbers.length - 1] = numbers[0];
        }
        return answer;
    }
}
