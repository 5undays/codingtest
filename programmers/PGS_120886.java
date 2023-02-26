package programmers;

/**
 * A로 B 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120886)
 */
public class PGS_120886 {
    public static void main(String[] args) {
        System.out.println(solution("olleh", "hello"));
        System.out.println(solution("allpe", "apple"));
    }

    public static int solution(String before, String after) {
        int answer = 1;
        StringBuilder sb = new StringBuilder(after);
        for (int i = 0; i < before.length(); i++) {
            char c = before.charAt(i);
            if (sb.indexOf(String.valueOf(c)) > -1) {
                sb.setCharAt(sb.indexOf(String.valueOf(c)), ' ');
            } else {
                return 0;
            }
        }
        return answer;
    }
}
