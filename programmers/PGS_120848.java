package programmers;

/**
 * 팩토리얼
 * https://school.programmers.co.kr/learn/courses/30/lessons/120848
 */
public class PGS_120848 {
    public static void main(String[] args) {
        System.out.println(solution(3628800));
        System.out.println(solution(7));
    }

    public static int solution(int n) {
        return dfs(1, n, 1) - 2;
    }

    private static int dfs(int depth, int limit, int result) {
        if (limit < result) {
            return depth;
        }
        return dfs(depth + 1 , limit, result * depth);
    }
}
