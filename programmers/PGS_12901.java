package programmers;

import java.util.Calendar;
import java.util.Date;

/**
 * 2016년
 * https://school.programmers.co.kr/learn/courses/30/lessons/12901
 */
public class PGS_12901 {
    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }

    /**
     * 2016년 a월 b일
     *
     * @param a 월
     * @param b 일
     * @return 요일
     */
    public static String solution(int a, int b) {
        Calendar cal = Calendar.getInstance();
        cal.set(2016, a - 1, b);
        String answer = cal.getTime().toString().toUpperCase().split(" ")[0];
        return answer;
    }
}
