package programmers;

/**
 * 모스부호 (1)
 * https://school.programmers.co.kr/learn/courses/30/lessons/120838
 */
public class PGS_120838 {
    static String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."};

    public static void main(String[] args) {
        System.out.println(solution(".... . .-.. .-.. ---"));
    }

    public static String solution(String letter) {
        String answer = "";
        String[] arr = letter.split(" ");
        for (String s : arr) {
            for (int i = 0; i < morse.length; i++) {
                if (morse[i].equals(s)) {
                    answer += (char) (97 + i) + "";
                }
            }
        }
        return answer;
    }

}
