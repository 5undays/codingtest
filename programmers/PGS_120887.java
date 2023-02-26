package programmers;

/**
 * k의 개수
 * https://school.programmers.co.kr/learn/courses/30/lessons/120887
 */
public class PGS_120887 {
    public static void main(String[] args) {
        System.out.println(solution2(1, 13, 1));
        System.out.println(solution2(10, 50, 5));
        System.out.println(solution2(3, 10, 2));
    }

    public static int solution(int i, int j, int k) {
        int answer = 0;
        for (; i <= j; i++) {
            String s = String.valueOf(i);
            for (int t = 0; t < s.length(); t++) {
                if (Integer.parseInt(s.charAt(t) + "") == k) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static int solution2(int i, int j, int k) {
        String str = "";
        for (; i <= j; i++) {
            str += String.valueOf(i);
        }
        return str.replace(k + "", "").length();
    }
}
