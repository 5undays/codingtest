package programmers;

import java.util.Arrays;

/**
 * 1로 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181880
 */
public class PGS_181880 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{12, 4, 15, 1, 14}));
    }

    public static int solution(int[] num_list) {
        int answer = 0;
        for (int i = 0; i < num_list.length; i++) {
            while (num_list[i] != 1) {
                if (num_list[i] % 2 == 0) {
                    num_list[i] /= 2;
                } else {
                    num_list[i] -= 1;
                    num_list[i] /= 2;
                }
                answer++;
            }
        }
        return answer;
    }

    private static int solution2(int[] num_list) {
        return Arrays.stream(num_list).map(x -> Integer.toBinaryString(x).length() - 1).sum();
    }
}
