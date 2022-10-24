package programmers;

/**
 * 피로도
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
public class PGS_87946 {
    public static void main(String[] args) {
        int answer = solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}});
        System.out.println(answer);
    }

    static boolean[] check;
    static int answer = 0;

    public static int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        for (int i = 0; i < dungeons.length; i++) {
            dfs(dungeons, k,0);
        }
        return answer;
    }

    /**
     * 최대 입장 가능한 던전 개수
     * @param dungeons 던전 배열
     * @param left 남은 피로도
     * @param depth 던전 수
     */
    private static void dfs(int[][] dungeons, int left, int depth) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!check[i] && dungeons[i][1] <= left) {
                check[i] = true;
                dfs(dungeons, left - dungeons[i][1], depth + 1);
                check[i] = false;
            }
        }
        answer = Math.max(depth, answer);
    }
}
