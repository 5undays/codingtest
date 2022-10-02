package programmers;

/**
 * 숫자 문자열과 영단어
 * https://school.programmers.co.kr/learn/courses/30/lessons/81301
 */
public class PGS_81301 {
    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
    }

    static final String[] word = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    /**
     * s가 의미하는 원래 숫자
     * 
     * @param s 영단어가 바뀌어 졌거나 바뀌지 않은 단어
     * @return
     */
    public static int solution(String s) {
        for (int i = 0; i < word.length; i++) {
            s = s.replaceAll(word[i], i + "");
        }
        return Integer.parseInt(s);
    }
}
