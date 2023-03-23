package boj;

import java.util.Scanner;

/**
 * 크로아티아 알파벳
 * https://www.acmicpc.net/problem/2941
 */
public class BOJ_2941 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int answer = s.length();

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char before = s.charAt(i - 1);
            if (c == '=') {
                if (before == 'c') answer--;
                if (before == 's') answer--;
                if (before == 'z') {
                    answer--;
                    if (i - 2 >= 0) {
                        if (s.charAt(i - 2) == 'd') answer--;
                    }
                }
            }
            if (c == '-') {
                if (before == 'c') answer--;
                if (before == 'd') answer--;
            }
            if (c == 'j') {
                if (before == 'l') answer--;
                if (before == 'n') answer--;
            }
        }

        System.out.println(answer);
    }
//
//    static String[] alphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//
//        for (int i = 0; i < alphabet.length; i++) {
//            s = s.replace(alphabet[i], "a");
//        }
//
//        System.out.println(s.length());
//    }
}
