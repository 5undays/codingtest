package boj;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 숫자판 점프
 * https://www.acmicpc.net/problem/2210
 */
public class BOJ_2210 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] numbers = new int[5][5];
    static HashSet<String> result = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0 ; i< 5 ;i ++) {
            for (int j = 0; j < 5; j++) {
                numbers[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 5; i ++) {
            for (int j = 0; j < 5; j++) {
                dfs(i,j,0, "");
            }
        }

        System.out.println(result.size());
    }

    private static void dfs(int x, int y, int depth, String n) {
        if(depth==6){
            result.add(n);
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                dfs(nx,ny, depth + 1, n + numbers[nx][ny]);
            }
        }
    }
}
