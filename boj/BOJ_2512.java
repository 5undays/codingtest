package boj;

import java.util.Arrays;

/**
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

        Arrays.sort(budgets);

        int left = 0;
        int right = budgets[budgets.length-1];

        while (left <= right) {
            answer = (left + right) / 2;
            if (condition(budgets, answer, M)) {
                left = answer + 1;
            } else {
                right = answer - 1;
            }
        }
        return right;
    }

    private boolean condition(int[] budgets, int answer, int M) {
        int totalBudget = 0;
        for (int i = 0; i < budgets.length ; i++) {
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

}