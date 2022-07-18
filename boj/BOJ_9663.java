package boj;

import java.util.Scanner;

public class BOJ_9663 {
    static int answer = 0;
    static int[] arr;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        nQueen(0);
        System.out.println(answer);
    }

    /**
     * 퀸 백트레킹
     * @param column 현재 행
     */
    public static void nQueen(int column) {
        if (column == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[column] = i;
            if (possibility(column)) {
                nQueen(column + 1);
            }
        }

    }

    /**
     * 사용 가능 열 유효성 검사
     * @param column 현재 행
     * @return 사용 가능 여부
     */
    private static boolean possibility(int column) {
        for (int i = 0; i < column; i++) {
            // 1. 열이 같은 경우
            // 2. 행과 열의 차이가 같은 경우
            if (arr[column] == arr[i] || Math.abs(column - i) == Math.abs(arr[column] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
