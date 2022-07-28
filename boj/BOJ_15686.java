package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 치킨배달
 * https://www.acmicpc.net/problem/15686
 */
public class BOJ_15686 {
    static int[][] map;
    static ArrayList<Map> chicken;
    static ArrayList<Map> person;
    static int n, m;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nm = br.readLine();
        StringTokenizer st2 = new StringTokenizer(nm, " ");
        n = Integer.parseInt(st2.nextToken());
        m = Integer.parseInt(st2.nextToken());
        chicken = new ArrayList<>();
        person = new ArrayList<>();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) { // 집
                    person.add(new Map(i, j));
                } else if (map[i][j] == 2) { // 치킨집
                    chicken.add(new Map(i, j));
                }
            }
        }
        visited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(answer);
    }

    /**
     * 백트레킹
     * 
     * @param start 시작점
     * @param count 치킨 매장
     */
    public static void dfs(int start, int count) {
        if (count == m) {
            int length = 0;
            for (int i = 0; i < person.size(); i++) {
                int temp = Integer.MAX_VALUE; // 범위 넘는 경우 방지
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        int distance = Math.abs(person.get(i).x - chicken.get(j).x)
                                + Math.abs(person.get(i).y - chicken.get(j).y);
                        temp = Math.min(temp, distance);
                    }
                }
                length += temp;
            }
            answer = Math.min(answer, length);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            visited[i] = true;
            dfs(i + 1, count + 1);
            visited[i] = false;
        }
    }
}

class Map {
    int x;
    int y;

    Map(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
