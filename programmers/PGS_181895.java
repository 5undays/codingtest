package programmers;

import java.util.Arrays;

/**
 * 배열 만들기 3
 * https://school.programmers.co.kr/learn/courses/30/lessons/181895
 */
public class PGS_181895 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5}, new int[][]{{1, 3}, {0, 4}})));
        System.out.println(Arrays.toString(solution1(new int[]{1, 2, 3, 4, 5}, new int[][]{{1, 3}, {0, 4}})));
    }

    public static int[] solution(int[] arr, int[][] intervals) {
        int length = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] group = intervals[i];
            length += group[1] - group[0] + 1;
        }

        int[] answer = new int[length];
        int index = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] group = intervals[i];
            for (int j = group[0]; j <= group[1]; j++) {
                answer[index++] = arr[j];
            }
        }
        return answer;
    }

    private static int[] solution1(int[] arr, int[][] intervals) {
        return Arrays.stream(intervals)
                .flatMapToInt(x -> Arrays.stream(Arrays.copyOfRange(arr, x[0], x[1] + 1)))
                .toArray();
    }
}
