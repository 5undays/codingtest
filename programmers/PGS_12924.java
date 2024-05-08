package programmers;

public class PGS_12924 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1 && n % i == 0) {
                answer++;
            }
        }
        return answer;
    }

}
