package programmers;

/**
 * 삼각형의 완성조건 (2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/120868
 */
public class PGS_120868 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2}));
        System.out.println(solution(new int[]{3, 6}));
        System.out.println(solution(new int[]{11, 7}));
    }

    /**
     * 나머지 한 변이 될 수 있는 정수의 개수
     *
     * @param sides 삼각형의 두 변의 길이가 담긴 배열
     * @return
     */
    public static int solution(int[] sides) {
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);

        return (max - (max - min)) + ((max + min) - max) - 1;
    }
}
