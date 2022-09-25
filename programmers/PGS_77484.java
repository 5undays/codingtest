package programmers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 로또의 최고 순위와 최저 순위
 * https://school.programmers.co.kr/learn/courses/30/lessons/77484
 */
public class PGS_77484 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] { 44, 1, 0, 0, 31, 25 }, new int[] { 31, 10, 45, 1, 6, 19 }));
        System.out.println(solution(new int[] { 0, 0, 0, 0, 0, 0 }, new int[] { 38, 19, 20, 40, 15, 25 }));
        System.out.println(solution(new int[] { 45, 4, 35, 20, 3, 9 }, new int[] { 20, 9, 3, 45, 4, 35 }));
        System.out.println(solution(new int[] { 97, 96, 99, 98, 95, 94 }, new int[] { 31, 10, 45, 1, 6, 19 }));
    }

    /**
     * 
     * @param lottos
     * @param win_nums
     * @return
     */
    public static ArrayList<Integer> solution(int[] lottos, int[] win_nums) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int maxCnt = 0;
        int minCnt = 0;
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                maxCnt++;
                continue;
            } else {
                for (int j = 0; j < 6; j++) {
                    if (lottos[i] == win_nums[j]) {
                        minCnt++;
                        maxCnt++;
                        break;
                    }
                }
            }
        }

        answer.add(7 - maxCnt == 7 ? 6 : 7 - maxCnt);
        answer.add(7 - minCnt == 7 ? 6 : 7 - minCnt);
        return answer;
    }
}
