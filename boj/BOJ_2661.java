package boj;

import java.util.Scanner;

/**
 * 좋은 수열
 * https://www.acmicpc.net/problem/2661
 */
public class BOJ_2661 {
    static int n;
    //static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        backtracking("");
    }

    /**
     * 백트래킹 알고리즘
     * @param temp 수열
     */
    private static void backtracking(String temp) {
        if (n == temp.length()) {
            System.out.println(temp);
            System.exit(0);
        } else {
            for (int i = 1; i <= 3; i++) {
                if (validation(temp + i))
                    backtracking(temp + i);
            }
        }

    }

    /**
     * 좋은 수열 유효성 검사
     * @param text 수열
     * @return 좋은 수열 여부
     */
    private static boolean validation(String text) {
        for (int i = 1; i <= text.length() / 2; i++) {
            if (text.substring(text.length() - i).equals(text.substring(text.length() - 2 * i, text.length() - i))) {
                return false;
            }
        }
        return true;
    }
}
