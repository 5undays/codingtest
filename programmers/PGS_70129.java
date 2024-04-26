package programmers;

import java.util.Arrays;

public class PGS_70129 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
    }

    public static int[] solution(String s) {
        int[] answer = {0, 0};

        while (!s.equals("1")) {
            answer[0]++;
            /*for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    answer[1]++;
                }
            }*/

            String temp = s.replace("0", "");
            answer[1] += s.length() - temp.length();
            s = temp;

            s = Integer.toBinaryString(s.length());
        }
        return answer;
    }
}
