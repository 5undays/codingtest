package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 디스크 컨트롤러
 * https://school.programmers.co.kr/learn/courses/30/lessons/42627
 */
public class PGS_42627 {
    public static void main(String[] args) {

    }

    public int solution(int[][] jobs) {
        int total = 0;
        int current = 0;
        int idx = 0;
        int requestCnt = 0;
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        while (requestCnt < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= current) {
                pq.add(jobs[idx++]);
            }

            if (pq.isEmpty()) {
                current = jobs[idx][0];
            } else {
                int[] temp = pq.poll();
                total += temp[1] + current - temp[0];
                current += temp[1];
                requestCnt++;
            }
        }
        return (int) Math.floor(total / jobs.length);
    }
}
