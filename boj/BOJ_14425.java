package boj;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 문자열 집합
 * https://www.acmicpc.net/problem/14425
 */
public class BOJ_14425 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<String, Integer> hm = new HashMap<>();
        while (n-- > 0) {
            hm.put(sc.next(), 1);
        }
        int answer = 0;
        while (m-- > 0) {
            String s = sc.next();
            if (hm.containsKey(s)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
