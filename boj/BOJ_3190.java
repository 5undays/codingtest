package boj;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 뱀
 * https://www.acmicpc.net/problem/3190
 */
public class BOJ_3190 {
    static int[] dx = {1, 0, -1, 0};// 동, 북, 서,남
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int x = 0, y = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 보드 크기
        int k = sc.nextInt(); // 사과
        int direction = 1;
        map = new int[n][n];

        for (int i = 0; i < k; i++) {
            int j = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            map[j][v] = 1;
        }
        int l = sc.nextInt(); // 변환 횟수
        Deque<Dummy> v = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            int j = sc.nextInt();
            String d = sc.next();
            v.add(new Dummy(j, d));
        }

        Deque<int[]> dq = new LinkedList<>();
        dq.add(new int[]{x, y});
        map[0][0] = 2;
        int count = 0;

        while (true) {
            count++;

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 범위를 벗어나거나 자기자신과 부딫힌 경우 종료
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == 2) {
                break;

                // 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다.
            } else if (map[nx][ny] == 0) {
                map[nx][ny] = 2;
                int[] tail = dq.pollLast();
                map[tail[0]][tail[1]] = 0;
                dq.addFirst(new int[]{nx, ny});

                // 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
            } else if (map[nx][ny] == 1) {
                map[nx][ny] = 2;
                dq.addFirst(new int[]{nx, ny});
            }

            // 방향 바꾸기
            if (!v.isEmpty()) {
                if (count == v.peekFirst().seconds) {
                    Dummy d = v.pollFirst();
                    if (d.direction.equals("D")) {
                        direction = (direction + 3) % 4;
                    } else {
                        direction = (direction + 1) % 4;
                    }
                }
            }

            x = nx;
            y = ny;
        }
        System.out.println(count);
    }

    static class Dummy {
        int seconds;
        String direction;

        Dummy(int seconds, String direction) {
            this.seconds = seconds;
            this.direction = direction;
        }
    }
}
