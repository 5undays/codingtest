package programmers;

/**
 * 합성수 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120846
 */
public class PGS_120846 {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int answer = 0;
        for (int i = 4; i <= n;i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count > 2) {
                answer++;
            }
        }
        return answer;
    }
}
