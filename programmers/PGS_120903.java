package programmers;

/**
 * 배열의 유사도
 * https://school.programmers.co.kr/learn/courses/30/lessons/120903
 */
public class PGS_120903 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"a", "b", "c"}, new String[] {"com", "b", "d", "p", "c"}));
    }

    public static int solution(String[] s1, String[] s2) {
        int answer = 0;
        for (int i = 0; i< s1.length; i++) {
            for (int j = 0 ; j < s2.length; j++) {
                if (s1[i].equals(s2[j])) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
