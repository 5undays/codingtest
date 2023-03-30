package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 특이한 정렬
 * https://school.programmers.co.kr/learn/courses/30/lessons/120880
 */
public class PGS_120880 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5, 6}, 4)));
        System.out.println(Arrays.toString(solution(new int[]{10000, 20, 36, 47, 40, 6, 10, 7000}, 30)));
    }

    public static int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        ArrayList<NumArr> arr = new ArrayList<>();
        for (int i = 0; i < numlist.length; i++) {
            arr.add(new NumArr(n, numlist[i]));
        }
        Collections.sort(arr);

        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).number;
        }
        return answer;
    }

    private static class NumArr implements Comparable<NumArr> {
        int common;
        int number;

        NumArr(int common, int number) {
            this.common = common;
            this.number = number;
        }

        @Override
        public int compareTo(NumArr o) {
            int t = Math.abs(this.number - this.common);
            int tt = Math.abs(o.number - o.common);
            if (t == tt) {
                return o.number - this.number;
            } else {
                return t - tt;
            }
        }
    }
}
