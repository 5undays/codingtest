package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 약수 구하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120897
 */
public class PGS_120897 {
    public static void main(String[] args) {
    }

    public Integer[] solution(int n) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            if (i % n == 0) {
                s.add(i);
            }
        }
        Integer[] arr = s.toArray(new Integer[s.size()]);
        Arrays.sort(arr);
        return arr;
    }
}
