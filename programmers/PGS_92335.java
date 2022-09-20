package programmers;


/**
 * k진수에서 소수 개수 구하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */
public class PGS_92335 {
    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        // System.out.println(solution(110011, 10));
    }

    /**
     * 조건에 맞는 소수
     * 
     * @param n 양의 정수
     * @param k
     * @return
     */
    public static int solution(int n, int k) {
        String[] numbers = Integer.toString(n, k).split("0");
        int answer = 0;
        for (String x : numbers) {
            if (x.equals("1") || x.equals("")) {
                continue;
            }
            boolean isPrime = isPrime(Long.parseLong(x));
            if (isPrime) {
                answer++;
            }
        }
        return answer;
    }

    public static boolean isPrime(long n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
