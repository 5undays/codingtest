package boj;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 단어 공부
 * https://www.acmicpc.net/problem/1157
 */
public class BOJ_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toUpperCase();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c).intValue() + 1);
            } else {
                hm.put(c, 1);
            }
        }

        Character answer = '?';
        int answer2 = 0;
        for (Character key: hm.keySet()) {
            int x = hm.get(key);
            if (x > answer2) {
                answer2 = x;
                answer = key;
            } else if (x == answer2) {
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}
