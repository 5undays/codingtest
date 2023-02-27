package programmers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 소인수분해
 * https://school.programmers.co.kr/learn/courses/30/lessons/120852
 */
public class PGS_120852 {
    public static void main(String[] args) {
        //System.out.println(solution(12));
        System.out.println(solution(17));
        System.out.println(solution(420));
    }

    public static ArrayList<Integer> solution(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int index = 2;
        while (n >= index) {
            if (n % index == 0 && isPrime(index)) {
                arr.add(index);
                n /= index;
            }
            index++;
        }
        Collections.sort(arr);
        return arr;
    }

    private static boolean isPrime(int k) {
        for (int i = 2; i <= Math.sqrt(k); i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }

}
