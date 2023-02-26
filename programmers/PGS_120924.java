package programmers;

/**
 * 다음에 올 숫자
 * https://school.programmers.co.kr/learn/courses/30/lessons/120924
 */
public class PGS_120924 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 4}));
    }

    public static int solution(int[] common) {
        if (common[2] - common[1] == common[1] - common[0]) {
            return common[common.length - 1] * (common[1] / common[0]);
        } else {
            return common[common.length - 1] + (common[1] - common[0]);
        }
    }
}
