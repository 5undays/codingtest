package programmers;

import java.util.Arrays;

/**
 * OX퀴즈
 * https://school.programmers.co.kr/learn/courses/30/lessons/120907
 */
public class PGS_120907 {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(solution(new String[]{"3 - 4 = -3", "5 + 6 = 11"})));
        System.out.println(Arrays.toString(solution(new String[]{"-3 + -4 = -3", "5 + 6 = 11"})));
        //System.out.println(Arrays.toString(solution(new String[]{"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"})));
    }

//    public static String[] solution(String[] quiz) {
//        for (int i = 0; i < quiz.length; i++) {
//            String[] text = quiz[i].split(" ");
//            int result = Integer.parseInt(text[0]) + (Integer.parseInt(text[2]) * (text[1].equals("+") ? 1 : -1));
//            quiz[i] = result == Integer.parseInt(text[4]) ? "O" : "X";
//        }
//        return quiz;
//    }

    public static String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i = 0; i < quiz.length; i++) {
            String s = quiz[i].replace("- -", "+")
                    .replace("- +", "-")
                    .replace("+ -", "-")
                    .replace(" ", "");
            String[] arr = s.split("=");
            String op = arr[0].replace(" ", "");
            int result = Integer.parseInt(arr[1]);
            int result1 = 0;
            if (op.contains("+")) {
                String[] operation = op.split("\\+");
                result1 = Integer.parseInt(operation[0]) + Integer.parseInt(operation[1]);
            } else {
                String[] operation = op.split("-");
                if (op.charAt(0) == '-') {
                    result1 = -Integer.parseInt(operation[1]) - Integer.parseInt(operation[2]);
                } else {
                    result1 = Integer.parseInt(operation[0]) - Integer.parseInt(operation[1]);
                }
            }

            if (result == result1) {
                answer[i] = "O";
            } else {
                answer[i] = "X";
            }
        }
        return answer;
    }
}
