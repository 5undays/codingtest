package programmers;

/**
 * 유한소수 판별하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120878
 */
public class PGS_120878 {
    public static void main(String[] args) {
        System.out.println(solution(7, 20));
//        System.out.println(solution(11, 22));
//        System.out.println(solution(12, 21));
//        System.out.println(solution(25, 30));
    }

    public static int solution(int a, int b) {
        int gcd = gcd(a, b);
        b /= gcd;

        while (b % 2 == 0) {
            b /= 2;
        }
        while (b % 5 == 0) {
            b /= 5;
        }
        return b == 1 ? 1 : 2;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
