package programmers;

import java.util.Arrays;

/**
 * x만큼 간격이 있는 n개의 숫자
 * https://school.programmers.co.kr/learn/courses/30/lessons/12954
 */
public class PGS_12954 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 5)));
        System.out.println(Arrays.toString(solution(4, 3)));
        System.out.println(Arrays.toString(solution(-4, 2)));
    }

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        int index = 0;
        long value = x;
        while (index < n) {
            answer[index++] = value;
            value += x;
        }
        return answer;
    }
}
