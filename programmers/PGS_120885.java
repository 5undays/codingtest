package programmers;

/**
 * 이진수 더하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120885
 */
public class PGS_120885 {
    public static void main(String[] args) {
        System.out.println(solution("10", "11"));
        System.out.println(solution("1001", "1111"));
    }
    public static String solution(String bin1, String bin2) {
        int newbin1 = Integer.parseInt(bin1, 2);
        int newbin2 = Integer.parseInt(bin2, 2);
        int k = newbin1 + newbin2;
        return Integer.toBinaryString(k);
    }
}
