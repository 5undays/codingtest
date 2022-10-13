package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 게임 맵 최단거리
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
public class PGS_1844 {
    public static void main(String[] args) {
        int answer = solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 } });
        // int answer = solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 },
        //         { 0, 0, 0, 0, 1 } });
        System.out.println(answer);
    }

    /**
     * 매개변수로 주어질 때, 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값
     * 
     * @param maps 게임 맵의 상태
     * @return
     */
    public static int solution(int[][] maps) {
        int answer = -1;
        boolean[][] check = new boolean[maps.length][maps[0].length];
        Queue<Map> q = new LinkedList<>();
        q.add(new Map(0, 0, 0));

        while (!q.isEmpty()) {
            Map m = q.poll();
            if (m.x >= 0 && m.x < maps.length && m.y >= 0 && m.y < maps[0].length) {
                if (m.x == maps.length - 1 && m.y == maps[0].length - 1) {
                    answer = m.count + 1;
                    break;
                }
                if (!check[m.x][m.y] && maps[m.x][m.y] == 1) {
                    check[m.x][m.y] = true;
                    m.count++;
                    q.add(new Map(m.x - 1, m.y, m.count));
                    q.add(new Map(m.x, m.y - 1, m.count));
                    q.add(new Map(m.x + 1, m.y, m.count));
                    q.add(new Map(m.x, m.y + 1, m.count));
                }
            }
        }
        return answer;
    }

    static class Map {
        int x;
        int y;
        int count;

        Map(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
