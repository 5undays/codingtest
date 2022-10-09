package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 보석 쇼핑
 * https://school.programmers.co.kr/learn/courses/30/lessons/67258
 */
public class PGS_67258 {
    public static void main(String[] args) {
        int[] a1 = solution(new String[] { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" });
        int[] a2 = solution(new String[] { "AA", "AB", "AC", "AA", "AC" });
        int[] a3 = solution(new String[] { "XYZ", "XYZ", "XYZ" });
        int[] a4 = solution(new String[] { "ZZZ", "YYY", "NNNN", "YYY", "BBB" });
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(a3));
        System.out.println(Arrays.toString(a4));
    }

    /**
     * 가장 짧은 구간의 시작 진열대 번호와 끝 진열대 번호를 차례대로 배열
     * 
     * @param gems 진열대 번호 순서대로 보석들의 이름이 저장된 배열
     * @return
     */
    public static int[] solution(String[] gems) {
        int start = 0, count = 0, interval = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        set.addAll(Arrays.asList(gems));

        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            q.add(gems[i]);

            while (map.get(q.peek()) > 1) {
                map.put(q.peek(), map.get(q.poll()) - 1);
                count++;
            }

            if (map.size() == set.size() && interval > i - count) {
                interval = i - count;
                start = count + 1;
            }
        }

        return new int[] { start, start + interval };
    }

}
