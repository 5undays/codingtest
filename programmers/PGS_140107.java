package programmers;

/**
 * 점 찍기
 * https://school.programmers.co.kr/learn/courses/30/lessons/140107
 */
public class PGS_140107 {
    public static void main(String[] args) {
        System.out.println(solution(2, 4));
        System.out.println(solution(1, 5));
    }

    /**
     * 점이 총 몇 개 찍히는지
     *
     * @param k 정수
     * @param d 원점과의 거리를 나타내는 정수
     * @return
     */
    public static long solution(int k, int d) {
        long answer = 0;
        for (int a = 0; a <= d; a += k) {
            answer += (long) Math.sqrt(Math.pow(d,2) - Math.pow(a, 2)) / k + 1;
        }
        return answer;
    }
}
