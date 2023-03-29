package programmers;

/**
 * 저주의 숫자 3
 * https://school.programmers.co.kr/learn/courses/30/lessons/120871
 */
public class PGS_120871 {
    public static void main(String[] args) {
        System.out.println(solution(15));
        System.out.println(solution(40));
    }

    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer++;
            if (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                i--;
            }
        }
        return answer;
    }
}
