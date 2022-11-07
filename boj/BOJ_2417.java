package boj;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 정수 제곱근
 * https://www.acmicpc.net/problem/2417
 */
public class BOJ_2417 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger(sc.next());
        //System.out.println(n.sqrt());
        System.out.println(binaraySearch(n));
    }

    private static BigInteger binaraySearch(BigInteger n) {
        BigInteger min = BigInteger.ZERO;
        BigInteger max = n;
        BigInteger mid;
        BigInteger result = n;
        while (min.compareTo(max) <= 0) {
            mid = min.add(max).divide(BigInteger.TWO);
            if (mid.pow(2).compareTo(n) >= 0) {
                result = mid;
                max = mid.subtract(BigInteger.ONE);
            } else {
                min = mid.add(BigInteger.ONE);
            }
        }
        return result;
    }
}
