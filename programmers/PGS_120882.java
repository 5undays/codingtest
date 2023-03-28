package programmers;

import java.util.Arrays;

public class PGS_120882 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{80, 70}, {90, 50}, {40, 70}, {50, 80}})));
        System.out.println(Arrays.toString(solution(new int[][]{{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}})));
    }

    public static int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            int k = score[i][0] + score[i][1];
            int count = 1;
            for (int j = 0; j < score.length; j++) {
                if (score[j][0] + score[j][1] > k && i != j) {
                    count++;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}
