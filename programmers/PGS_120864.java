package programmers;

/**
 * 숨어있는 숫자의 덧셈 (2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/120864
 */
public class PGS_120864 {
    public static void main(String[] args) {
        System.out.println(solution("aAb1B2cC34oOp"));
        System.out.println(solution("1a2b3c4d123Z"));
    }

    public static int solution(String my_string) {
        int answer = 0;
        int temp = 0;
        my_string += "A";
        for (int i = 0; i < my_string.length(); i++) {
            if (Character.isDigit(my_string.charAt(i))) {
                temp = temp * 10 + Integer.parseInt(my_string.charAt(i) + "");
            } else {
                answer += temp;
                temp = 0;
            }
        }
        return answer;
    }
}
