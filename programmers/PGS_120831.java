package programmers;

/**
 * 짝수의 합
 * https://school.programmers.co.kr/learn/courses/30/lessons/120831
 */
public class PGS_120831 {
    public static void main(String[] args) {
        System.out.println(solution(10));
        //System.out.println(solution(4));
    }

    public static int solution(int n) {
        int answer = dfs(n);
        return answer;
    }

    private static int dfs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 2 == 0) {
            return n + dfs(n - 1);
        } else {
            return dfs(n - 1);
        }
    }
}
