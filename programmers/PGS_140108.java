package programmers;

import java.util.ArrayList;

/**
 * 문자열 나누기
 * https://school.programmers.co.kr/learn/courses/30/lessons/140108
 */
public class PGS_140108 {
    public static void main(String[] args) {
        System.out.println(solution("banana"));
        System.out.println(solution("abracadabra"));
        System.out.println(solution("aaabbaccccabba"));
    }

    public static int solution(String s) {
        char first = s.charAt(0);
        int count = 0;
        int diff = 0;
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count == diff) {
                answer++;
                first = s.charAt(i);
            }
            if (first == s.charAt(i)) {
                count++;
            } else {
                diff++;
            }
        }
        return answer;
    }
}
