package programmers;

/**
 * 구슬을 나누는 경우의 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/120840
 */
public class PGS_120840 {
    public static void main(String[] args) {
        System.out.println(solution(3, 2));
    }

    public static long solution(int balls, int share) {
        long answer = 1L;
        int cnt = 1;

        for (int i = share + 1; i <= balls; i++){
            answer *= i;
            answer /= cnt++;
        }

        return answer;
    }
}
