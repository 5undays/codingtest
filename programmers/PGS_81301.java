package programmers;

/**
 * 숫자 문자열과 영단어
 * https://school.programmers.co.kr/learn/courses/30/lessons/81301
 */
public class PGS_81301 {
    public static void main(String[] args) {

    }

    static final String[] word = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < word.length; i++) {
            s = s.replace(word[i], i + "");
        }
        return answer;
    }
}
