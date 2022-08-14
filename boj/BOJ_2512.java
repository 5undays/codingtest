package boj;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 예산
 * https://www.acmicpc.net/problem/2512
 */
public class BOJ_2512 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 예산 요청 지방 개수
        int[] budgets = new int[n];
        for (int i = 0; i < n; i++) {
            budgets[i] = sc.nextInt();
        }
        int m = sc.nextInt(); // 총 예산
        int answer = solution1(budgets, m);
        System.out.println(answer);
    }

    /**
     * 예산 
     * @param budgets 예산
     * @param M 총 예산
     * @return
     */
    private static int solution1(int[] budgets, int M) {
        int answer = 0;
        int min = 0; // 가장 적은 예산
        int max = IntStream.of(budgets).max().orElse(0); // 가장 큰 예산

        while (min <= max) {
            int mid = (min + max) / 2;
            // 총 예산 중 중간 값과 비교하여 작은 값 들을 저장
            int sum = IntStream.of(budgets).map(b -> Math.min(b, mid)).sum();

            if (sum <= M) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }
        return answer;
    }

}