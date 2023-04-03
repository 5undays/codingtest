package programmers;

import java.util.Arrays;

/**
 * 연속된 수의 합
 * https://school.programmers.co.kr/learn/courses/30/lessons/120923
 */
public class PGS_120923 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 0)));
//        System.out.println(Arrays.toString(solution(5, 15)));
//        System.out.println(Arrays.toString(solution(4, 14)));
    }
    public static int[] solution(int num, int total) {
        int max = total;
        int min = total - num + 1;
        while (true) {
            int sum = 0;
            for (int i = min; i <= max; i++) {
                sum += i;
            }
            if (sum == total) {
                break;
            } else {
                max--;
                min--;
            }
        }

        int[] answer = new int[num];
        for (int i = 0; i < num; i++) {
            answer[i] = min++;
        }
        return answer;
    }
}
