package boj;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 엄청난 부자2
 * https://www.acmicpc.net/problem/1271
 */
public class BOJ_1271 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        BigInteger m = sc.nextBigInteger();
        BigInteger[] arr = n.divideAndRemainder(m);
        System.out.println(arr[0]+"\n"+arr[1]);
    }
}
