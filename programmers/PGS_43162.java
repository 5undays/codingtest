package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 네트워크
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */
public class PGS_43162 {
    public static void main(String[] args) {
        //int answer = solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        //System.out.println(answer);
        int answer2 = solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
        System.out.println(answer2);
    }

    static boolean[] check;
    /**
     * 네트워크의 개수
     *
     * @param n         컴퓨터의 개수
     * @param computers 연결에 대한 정보가 담긴 2차원 배열
     * @return
     */
    public static int solution(int n, int[][] computers) {
        check = new boolean[n];
        int answer = 0;
        answer = bfs(computers);

        for (int i = 0 ; i < computers.length; i++) {
            if (!check[i]) {
                answer++;
                dfs(computers, i);
            }
        }
        return answer;
    }

    /**
     *  DFS
     * @param computers 연결에 대한 정보가 담긴 2차원 배열
     * @param depth 다음에 연결될 컴퓨터 배열
     */
    private static void dfs(int[][] computers, int depth) {
        for (int i = 0; i < computers.length; i++) {
            if (computers[depth][i] == 1 && !check[i]) {
                check[depth] = true;
                dfs(computers, i);
            }
        }
    }

    /**
     * BFS
     * @param computers 연결에 대한 정보가 담긴 2차원 배열
     * @return
     */
    private static int bfs(int[][] computers) {
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < computers.length; i++) {
            if (check[i]) continue;
            q.add(computers[i]);
            check[i] = true;
            while (!q.isEmpty()) {
                int[] computer = q.poll();
                for (int j = 0; j < computer.length; j++) {
                    if (!check[j] && computer[j] == 1) {
                        check[j] = true;
                        q.add(computers[j]);
                    }
                }
            }
            result++;
        }
        return result;
    }
}
