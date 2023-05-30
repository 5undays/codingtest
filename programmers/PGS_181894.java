package programmers;

import java.util.Arrays;

/**
 * 2의 영역
 * https://school.programmers.co.kr/learn/courses/30/lessons/181894
 */
public class PGS_181894 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new int[]{1, 2, 1, 4, 5, 2, 9})));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 1})));
//        System.out.println(Arrays.toString(solution(new int[]{1, 1, 1})));
//        System.out.println(Arrays.toString(solution(new int[]{1, 2, 1, 4, 5, 2, 9})));
    }

    public static int[] solution(int[] arr) {
        int min = 10, max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }

        if (min <= max) {
            int[] answer = new int[max - min + 1];
            int index = 0;
            for (int i = min; i <= max; i++) {
                answer[index++] = arr[i];
            }
            return answer;
        } else {
            return new int[]{-1};
        }

    }
}
