package programmers;

/**
 * 피자 나눠 먹기 (2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/120815
 */
public class PGS_120815 {
    public static void main(String[] args) {
        System.out.println(solution(6));
        System.out.println(solution(10));
        System.out.println(solution(4));
    }

    public static int solution(int n) {
        int answer = 0;
        for (int i = 6; i < 606; i += 6) {
            if (i % n == 0) {
                answer = i / 6;
                break;
            }
        }
        return answer;
    }
}
