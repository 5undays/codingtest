package programmers;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class PGS_120890 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 10, 28}, 20)); // 28
        System.out.println(solution(new int[]{10, 11, 12}, 13)); // 12
        System.out.println(solution(new int[]{1, 3, 5, 7, 9, 11, 13, 15}, 2)); // 1
        System.out.println(solution(new int[]{15, 11, 13}, 14)); // 13
        System.out.println(solution(new int[]{9, 11, 12}, 10)); // 9
        System.out.println(solution(new int[]{9, 11, 12}, 11)); // 9

    }

    public static int solution(int[] array, int n) {
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            answer = Math.abs(array[i] - n) >= Math.abs(array[answer] - n) ? array[answer] < array[i] ? answer : i : i;
        }
        return array[answer];
    }
}
