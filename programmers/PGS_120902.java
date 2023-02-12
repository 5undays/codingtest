package programmers;

/**
 * 문자열 계산하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120902
 */
public class PGS_120902 {
    public static void main(String[] args) {
        System.out.println(solution("3 + 4"));
    }

    public static int solution(String my_string) {
        int answer = 0;
        String[] s = my_string.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("+")) {
                answer += Integer.parseInt(s[i + 1]);
                i++;
            } else if (s[i].equals("-")) {
                answer -= Integer.parseInt(s[i + 1]);
                i++;
            } else {
                answer += Integer.parseInt(s[i]);
            }
        }
        return answer;
    }
}
