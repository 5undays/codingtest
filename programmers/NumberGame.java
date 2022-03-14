package programmers;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12987
 */
public class NumberGame {
    public static void main(String args[]) {
        NumberGame numberGame = new NumberGame();
        System.out.println(numberGame.solution(new int[] { 5, 1, 3, 7 }, new int[] { 2, 2, 6, 8 }));
        System.out.println(numberGame.solution(new int[] { 2, 2, 2, 2 }, new int[] { 1, 1, 1, 1 }));

        // 내가 만든 예시
        System.out.println(numberGame.solution(new int[] { 1, 2, 3, 4 }, new int[] { 1, 1, 2, 3 }));
    }

    private int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = A.length - 1;
        for (int i = idx; i >= 0; i--) {
            if (A[i] < B[idx]) {
                answer++;
                idx--;
            }
        }
        return answer;
    }

    private int solution1(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int idxA = A.length - 1, idxB = idxA;
        while (idxA >= 0) {
            if (A[idxA] < B[idxB]) {
                answer++;
                idxB--;
            }
            idxA--;
            System.out.println("idxB :" + idxB);
        }
        return answer;
    }

    // new int[] { 1, 2, 3, 4 }, new int[] { 1, 1, 2, 3 } 예외처리 필요
    private int solution2(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            if (A[i] < B[i]) {
                answer++;
            }
        }
        return answer;
    }
}
