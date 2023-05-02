package boj;

import java.util.Scanner;

/**
 * 회문
 * https://www.acmicpc.net/problem/17609
 */
public class BOJ_17609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            sb.append(valid_palindrome(0, s.length() - 1, s, 0)).append("\n");
        }
        System.out.println(sb);
    }

    /**
     * 펠린드롬 판별
     *
     * @param s     판별 문자열
     * @param count 삭제한 횟수
     * @return
     */
    private static int valid_palindrome(int start, int end, String s, int count) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                if (count == 0) {
                    if (valid_palindrome(start + 1, end, s, 1) == 0
                            || valid_palindrome(start, end - 1, s, 1) == 0) {
                        return 1;
                    }
                    return 2;
                } else {
                    return 2;
                }
            } else {
                start++;
                end--;
            }
        }

        return 0;
    }
}
