package programmers;

/**
 * 컨트롤 제트
 * https://school.programmers.co.kr/learn/courses/30/lessons/120853
 */
public class PGS_120853 {
    public static void main(String[] args) {
        System.out.println(solution("1 2 Z 3"));
    }

    public static int solution(String s) {
        int answer = 0;
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            String k;
            if (i != arr.length - 1) {
                k = arr[i + 1];
            } else {
                k = arr[i];
            }
            if (!k.equals("Z")) {
                answer += Integer.parseInt(arr[i]);
            } else {
                i += 1;
            }
        }
        return answer;
    }
}
