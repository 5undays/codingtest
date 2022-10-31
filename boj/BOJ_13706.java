package boj;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 제곱근
 * https://www.acmicpc.net/problem/13706
 */
public class BOJ_13706 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger(sc.next());
        //System.out.println(n.sqrt());
        System.out.println(binarySearch(n));
    }

    private static BigInteger binarySearch(BigInteger n) {
        BigInteger left = BigInteger.ONE;
        BigInteger right = n;
        BigInteger mid = null;
        while (true) {
            mid = left.add(right).divide(BigInteger.TWO);
            int result = mid.multiply(mid).compareTo(n);
            if (result == 0) {
                break;
            } else if (result == 1){
                right = mid.subtract(BigInteger.ONE);
            } else {
                left = mid.add(BigInteger.ONE);
            }
        }
        return mid;
    }
}
