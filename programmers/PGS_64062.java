package programmers;

import java.util.Scanner;

/**
 * 징검다리 건너기
 * https://school.programmers.co.kr/learn/courses/30/lessons/64062
 */
public class PGS_64062 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }

    /**
     * 최대 몇 명까지 징검다리를 건널 수 있는지 return
     * @param stones 디딤돌에 적힌 숫자가 순서대로 담긴 배열
     * @param k 한 번에 건너뛸 수 있는 디딤돌의 최대 칸수
     * @return
     */
    public static int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;
        while (left <= right) {
            int cnt = 0;
            int mid = (left + right) / 2;
            // mid 값이 k가 될 경우 불가능한 카운트 수
            for (int stone: stones) {
                if (stone - mid <= 0) {
                    cnt += 1;
                } else {
                    cnt = 0;
                }
                if (cnt >= k) {
                    break;
                }
            }
            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
