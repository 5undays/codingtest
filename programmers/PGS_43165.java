package programmers;

/**
 * 타겟 넘버
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class PGS_43165 {
    public static void main(String[] args) {
        //solution(new int[] { 1, 1, 1, 1, 1 }, 3);
        int answer = solution(new int[] {4, 1, 2, 1}, 4);
        System.out.println(answer);
    }

    static int answer = 0;

    /**
     * 타겟 넘버를 만드는 방법의 수
     * 
     * @param numbers 사용할 수 있는 숫자가 담긴 배열
     * @param target  타겟 넘버
     * @return
     */
    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }

    private static void dfs(int[] numbers, int depth, int target, int sum) {
        if (numbers.length == depth) {
            if (target == sum) {
                answer++;
            }
            return;
        }

        dfs(numbers, depth + 1, target, sum + numbers[depth]);
        dfs(numbers, depth + 1, target, sum - numbers[depth]);

    }
}
