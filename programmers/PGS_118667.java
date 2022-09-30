package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 두 큐 합 같게 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667
 */
public class PGS_118667 {
    public static void main(String[] args) {
        // solution(new int[] { 3, 2, 7, 2 }, new int[] { 4, 6, 5, 1 });
        // solution(new int[] { 1, 2, 1, 2 }, new int[] { 1, 10, 1, 2 });
        // solution(new int[] { 1, 1 }, new int[] { 1, 5 });
        System.out.println(solution(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 10 }, new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
    }

    /**
     * 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수
     * 
     * @param queue1
     * @param queue2
     * @return
     */
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        while (sum1 != sum2) {
            answer++;

            if (sum1 > sum2) {
                int value = q1.poll();
                sum1 -= value;
                sum2 += value;
                q2.offer(value);
            } else {
                int value = q2.poll();
                sum1 += value;
                sum2 -= value;
                q1.offer(value);
            }

            if (answer > queue1.length * 4)
                return -1;
        }
        return answer;
    }
}
