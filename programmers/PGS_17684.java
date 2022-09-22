package programmers;

import java.util.ArrayList;

/**
 * [3차] 압축
 * https://school.programmers.co.kr/learn/courses/30/lessons/17684
 */
public class PGS_17684 {
    public static void main(String[] args) {
        solution("TOBEORNOTTOBEORTOBEORNOT");
    }

    public static ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 1; i < 27; i++) {
            arr.add((char) (i + 64) + "");
        }

        for (int i = 0; i < msg.length(); i++) {
            int j = i + 1;
            while (true) {
                if (j >= msg.length()) {
                    answer.add(arr.indexOf(msg.substring(i, j)) + 1);
                    i += j - i - 1;
                    break;
                }
                String s = msg.substring(i, ++j);
                if (arr.indexOf(s) < 0) {
                    answer.add(arr.indexOf(msg.substring(i, --j)) + 1);
                    i += j - i - 1;
                    arr.add(s);
                    break;
                }
            }
        }

        return answer;
    }
}
