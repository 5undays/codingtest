package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 스페셜 저지
 * https://www.acmicpc.net/problem/16940
 */
public class BOJ_16940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] map = new ArrayList[n]; // 연결 리스트 생성
        int[] b = new int[n];
        int[] order = new int[n]; // 방문 순서
        boolean[] check = new boolean[n]; // 체크

        // 각 인덱스 별 연결된 리스트 생성
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        // 연결 된 배열
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int w = sc.nextInt() - 1;
            map[u].add(w);
            map[w].add(u);
        }

        // BFS 방문 순서
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt() - 1;
            order[b[i]] = i;
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(map[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    // TODO Auto-generated method stub
                    if (order[o1] < order[o2]) {
                        return -1;
                    } else if (order[o1] == order[o2]) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        check[0] = true;
        ArrayList<Integer> bfs_order = new ArrayList<>();
        while (!q.isEmpty()) {
            int i = q.remove();
            bfs_order.add(i);
            for (int x : map[i]) {
                if (!check[x]) {
                    check[x] = true;
                    q.add(x);
                }
            }
        }

        boolean answer = true;

        for (int i = 0; i < n; i++) {
            if (bfs_order.get(i) != b[i]) {
                answer = false;
                break;
            }
        }

        System.out.println(answer);
    }

}
