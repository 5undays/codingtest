package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 메뉴 리뉴얼
 * https://school.programmers.co.kr/learn/courses/30/lessons/72411
 */
public class PGS_72411 {
    public static void main(String[] args) {
        // System.out.println(
        // solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" }, new
        // int[] { 2, 3, 4 }));
        System.out.println(
                solution(new String[] { "XYZ", "XWY", "WXA" }, new int[] { 2, 3, 4 }));
    }

    static HashMap<String, Integer> h = new HashMap<>();
    static ArrayList<String> answer = new ArrayList<>();

    /**
     * 새로 추가하게 될 코스요리의 메뉴 구성을 문자열
     * 
     * @param orders 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열
     * @param course 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열
     * @return
     */
    public static ArrayList<String> solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        for (int c : course) {
            for (String order : orders) {   
                combination("", order, c);
            }

            if (!h.isEmpty()) {
                List<Integer> cList = new ArrayList<>(h.values());
                int max = Collections.max(cList);
                if (max > 1) {
                    for (String menu : h.keySet()) {
                        if (h.get(menu) == max) {
                            answer.add(menu);
                        }
                    }
                }
                h.clear();
            }
        }

        Collections.sort(answer);
        return answer;
    }

    /**
     * 메뉴 조합
     * @param menu 메뉴 이름
     * @param order 다음 주문
     * @param c 메뉴 개수
     */
    private static void combination(String menu, String order, int c) {
        if (c == 0) {
            h.put(menu, h.getOrDefault(menu, 0) + 1);
            return;
        }

        for (int i = 0; i < order.length(); i++) {
            combination(menu + order.charAt(i), order.substring(i + 1), c - 1);
        }
    }
}
