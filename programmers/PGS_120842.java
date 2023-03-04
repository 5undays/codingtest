package programmers;

import java.util.Arrays;

/**
 * 2차원으로 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120842
 */
public class PGS_120842 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2)));
    }

    public static int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        for (int i = 0; i < num_list.length; i++) {
            answer[i / n][i % n] = num_list[i];
        }
        return answer;
    }
}
