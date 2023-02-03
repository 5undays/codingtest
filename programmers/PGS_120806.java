package programmers;

/**
 * 두 수의 나눗셈
 * https://school.programmers.co.kr/learn/courses/30/lessons/120806
 */
public class PGS_120806 {
    public static void main(String[] args) {
        System.out.println(solution(3, 2));
    }

    public static int solution(int num1, int num2) {
        return (int) ((double) num1 / num2 * 1000);
    }
}
