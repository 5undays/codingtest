package boj;

import java.util.*;

/**
 * N과 M (9)
 * https://www.acmicpc.net/problem/15663
 */
public class BOJ_15663 {
    static int[] data;
    static int[] arr;
    static int n,m;
    static boolean[] visited;
    static HashSet<String> hs = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        data = new int[n];
        visited = new boolean[1000];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        arr = new int[m];
        Arrays.sort(data);
        go(0);
        StringBuilder sb = new StringBuilder();
        Iterator iter = hs.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next()).append("\n");
        }

        System.out.println(sb);
    }

    private static void go(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int x : arr) {
                sb.append(x).append(" ");
            }
            hs.add(String.valueOf(sb));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = data[i];
                go(depth + 1);
                visited[i] = false;
            }
        }
    }
}
