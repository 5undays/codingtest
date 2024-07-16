package boj;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 소음
 * https://www.acmicpc.net/problem/2935
 */
public class BOJ_2935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        String oper = sc.next();
        BigInteger b = sc.nextBigInteger();
        if (oper.equals("*")) {
            System.out.println(a.multiply(b));
        } else if (oper.equals("+")) {
            System.out.println(a.add(b));
        }
    }
}
