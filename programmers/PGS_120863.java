package programmers;

/**
 * 다항식 더하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120863
 */
public class PGS_120863 {

    public String solution(String polynomial) {
        String answer = "";
        int front = 0;
        int back = 0;
        polynomial = polynomial.replace(" " , "");
        String[] s = polynomial.split("\\+");
        for (int i = 0; i < s.length; i++) {
            String a = s[i];
            if (a.contains("x")) {
                if (a.length() != 1) {
                    int k = Integer.parseInt(a.substring(0, a.length() - 1));
                    front += k;
                } else {
                    front++;
                }
            } else {
                back += Integer.parseInt(a);
            }
        }

        if (front == 1) {
            answer += "x";
        } else if (front != 0) {
            answer += front + "x";
        }
        if (back != 0) {
            if (front == 0) {
                answer += back;
            } else {
                answer += " + " + back;
            }
        }
        return answer;
    }
}
