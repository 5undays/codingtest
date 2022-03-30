package boj;

import java.util.stream.IntStream;

/**
 * 예산
 * 해당 문제는 https://www.acmicpc.net/problem/2512 문제이지만
 * 프로그래머스 스터디 에서 실행된 코드이기 때문에 양식이 백준과는 다름
 */
public class BOJ_2512 {

    public static void main(String args[]) {
        BOJ_2512 answer = new BOJ_2512();
        System.out.println(answer.solution(new int[] { 120, 110, 140, 150 }, 485));
        System.out.println(answer.solution(new int[] { 70, 80, 30, 40, 100 }, 450));
    }

    public int solution(int[] budgets, int M) {
        int answer = 0;
        int left = 0;
        int right = budgets[budgets.length - 1];

        while (left <= right) {
            answer = (left + right) / 2;
            if (condition(budgets, answer, M)) {
                left = answer + 1;
            } else {
                right = answer - 1;
            }
        }
        return answer;
    }

    // 정해진 예산에 맞는지 확인
    private boolean condition(int[] budgets, int answer, int M) {
        int totalBudget = 0;
        for (int i = 0; i < budgets.length; i++) {
            if (budgets[i] >= answer) {
                totalBudget += answer;
            } else {
                totalBudget += budgets[i];
            }
        }

        if (totalBudget > M) {
            return false;
        }
        return true;
    }

    // 다른 풀이
    private int solution1(int[] budgets, int M) {
        int answer = 0;
        int min = 0;
        // int max = 0;
        // for (int budget : budgets) {
        // if (budget > max) {
        // max = budget;
        // }
        // }
        int max = IntStream.of(budgets).max().orElse(0);

        while (min <= max) {
            final int mid = (min + max) / 2;
            // int sum = 0;
            // for (int budget : budgets) {
            // if (budget > max) {
            // sum += mid;
            // } else {
            // sum += budget;
            // }
            // }
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