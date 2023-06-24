package boj;

import java.util.Scanner;

/**
 * 8진수 2진수
 * https://www.acmicpc.net/problem/1212
 */
public class BOJ_1212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '0':
                    sb.append("000");
                    break;
                case '1':
                    sb.append("001");
                    break;
                case '2':
                    sb.append("010");
                    break;
                case '3':
                    sb.append("011");
                    break;
                case '4':
                    sb.append("100");
                    break;
                case '5':
                    sb.append("101");
                    break;
                case '6':
                    sb.append("110");
                    break;
                case '7':
                    sb.append("111");
                    break;
            }
        }

        String answer = "0";
        for (int i = 0; i < sb.toString().length(); i++) {
            if (sb.toString().charAt(i) == '1') {
                answer = sb.substring(i);
                break;
            }
        }
        System.out.println(answer);
    }
}
