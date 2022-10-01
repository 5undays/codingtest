package programmers;

import java.util.Arrays;

/**
 * 파일명 정렬
 * https://school.programmers.co.kr/learn/courses/30/lessons/17686
 */
public class PGS_17686 {
    public static void main(String[] args) {
        System.out.println(
                solution(new String[] { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" }));
        System.out.println(solution(
                new String[] { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat" }));
    }

    public static String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String head1 = o1.split("[0-9]")[0].toLowerCase();
            String head2 = o2.split("[0-9]")[0].toLowerCase();
            if (head1.compareTo(head2) == 0) {
                int number1 = getNumber(o1.substring(head1.length()));
                int number2 = getNumber(o2.substring(head2.length()));
                return number1 - number2;
            } else {
                return head1.compareTo(head2);
            }
        });

        return files;
    }

    private static int getNumber(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                result.append(c);
            } else {
                return Integer.parseInt(result.toString());
            }
        }
        return Integer.parseInt(result.toString());
    }
}
