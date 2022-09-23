package programmers;

/**
 * n진수 게임
 * https://school.programmers.co.kr/learn/courses/30/lessons/17687
 */
public class PGS_17687 {
    public static void main(String[] args) {
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));
        System.out.println(solution(2, 4, 2, 1));
    }

    /**
     * 튜브가 말해야 하는 숫자 t개를 공백 없이 차례대로 나타낸 문자열
     * 
     * @param n 진법
     * @param t 미리 구할 숫자의 갯수
     * @param m 게임에 참가하는 인원
     * @param p 튜브의 순서
     * @return
     */
    public static String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int num = 0;

        while(sb.length() < m * t) {
            sb.append(Integer.toString(num++, n));
        }

        int index = p - 1;
        while (answer.length() < t) {
            answer.append(sb.charAt(index));
            index += m;
        }

        return answer.toString().toUpperCase();
    }
}
