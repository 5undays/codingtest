package programmers;

/**
 * 문자열 밀기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120921
 */
public class PGS_120921 {
    public static void main(String[] args) {
        System.out.println(solution("hello","ohell"));
        System.out.println(solution("apple", "elppa"));
        System.out.println(solution("atat", "tata"));
        System.out.println(solution("abc", "abc"));
        System.out.println(solution("abca", "aabc"));
    }

    public static int solution(String A, String B) {
        int answer = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.equals(B)) {
                return answer;
            } else {
                String c = A.substring(A.length() - 1);
                A = c + A.substring(0, A.length() - 1);
                answer++;
            }
        }
        return -1;
    }
}
