package programmers;

import java.util.HashMap;

/**
 * 폰켓몬
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */
public class PGS_1845 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 3}));
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 4}));
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 2}));
    }

    /**
     * 폰켓몬 종류 번호의 개수
     *
     * @param nums N마리 폰켓몬의 종류 번호가 담긴 배열
     * @return
     */
    public static int solution(int[] nums) {
        int find = nums.length / 2;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int n : nums) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
        return Math.min(hm.size(), find);
    }
}
