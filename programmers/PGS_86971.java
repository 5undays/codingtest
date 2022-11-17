package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 전력망을 둘로 나누기
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 */
public class PGS_86971 {
    public static void main(String[] args) {
        PGS_86971 pgs_86971 = new PGS_86971();
        System.out.println(pgs_86971.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
        System.out.println(pgs_86971.solution(4, new int[][]{{1,2},{2,3},{3,4}}));
        System.out.println(pgs_86971.solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));

    }

    static ArrayList<Integer>[] arr;
    static boolean[] check;
    static int answer = 0;
    int[][] wires;

    /**
     * 두 전력망이 가지고 있는 송전탑 개수의 차이
     *
     * @param n     송전탑의 개수
     * @param wires 전선 정보
     * @return
     */
    public int solution(int n, int[][] wires) {
        answer = n;
        this.wires = wires;
        arr = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            arr[wire[0]].add(wire[1]);
            arr[wire[1]].add(wire[0]);
        }

        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            arr[wire[0]].removeIf(x -> x == wire[1]);
            arr[wire[1]].removeIf(x -> x == wire[0]);
            int depth = bfs(n, wire[0]);
            answer = Math.min(answer, depth);
            arr[wire[0]].add(wire[1]);
            arr[wire[1]].add(wire[0]);
        }
        return answer;
    }

    public int bfs(int n, int i) {
        check = new boolean[n + 1];
        int result = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while (!q.isEmpty()) {
            int w = q.poll();
            check[w] = true;
            for (int x : arr[w]) {
                if (!check[x]) {
                    //check[x] = true;
                    result++;
                    q.add(x);
                }
            }
        }
        return Math.abs(n - 2 * result);
    }
}
