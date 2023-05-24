package programmers;

/**
 * l로 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181834
 */
public class PGS_181834 {
    public static void main(String[] args) {

    }

    public String solution(String myString) {
        StringBuilder answer = new StringBuilder(myString);
        for (int i =0 ; i < myString.length(); i++) {
            if (answer.toString().charAt(i) < 'l') {
                answer.setCharAt(i, 'l');
            }
        }
        return answer.toString();
    }
}
