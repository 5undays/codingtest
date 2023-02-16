package programmers;

/**
 * 중복된 문자 제거
 * https://school.programmers.co.kr/learn/courses/30/lessons/120888
 */
public class PGS_120888 {
    public static void main(String[] args) {
        //System.out.println(solution("people"));
        System.out.println(solution("We are the world"));
    }

    public static String solution(String my_string) {
        String answer = "";
        boolean[] arr = new boolean[123];
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (!arr[c]) {
                answer += String.valueOf(c);
                arr[c] = true;
            }
        }
        return answer;
    }
}
