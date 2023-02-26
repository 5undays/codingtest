package programmers;

/**
 * 공 던지기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120843
 */
public class PGS_120843 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 4}, 2));
    }

    public static int solution(int[] numbers, int k) {
        int answer = 0;
        while (--k > 0) {
            answer += 2;
        }
        return numbers[answer % numbers.length];
    }
}
