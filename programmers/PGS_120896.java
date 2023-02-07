package programmers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 한 번만 등장한 문자
 * https://school.programmers.co.kr/learn/courses/30/lessons/120896
 */
public class PGS_120896 {
    public static void main(String[] args) {
        System.out.println(solution("abcabcadc"));
    }

    public static String solution(String s) {
        String answer = "";
        Map<Character, Integer> hm = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = hm.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());

        for (Map.Entry e : list) {
            if ((int) e.getValue() == 1) {
                answer += e.getKey();
            }
        }
        return answer;
    }
}
