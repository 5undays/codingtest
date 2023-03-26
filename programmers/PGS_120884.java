package programmers;

/**
 * 치킨 쿠폰
 * https://school.programmers.co.kr/learn/courses/30/lessons/120884
 */
public class PGS_120884 {
    public static void main(String[] args) {
        System.out.println(solution(100));
        System.out.println(solution(1081));
        System.out.println(solution(1999));
    }

    public static int solution(int c) {
        int answer = 0;
        while (c >= 10) {
            int k = c % 10;
            answer += c / 10;
            c = k + c / 10;
        }

        return answer;
    }
}
