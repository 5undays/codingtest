package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 배열 합치기
 * https://www.acmicpc.net/problem/11728
 */
public class BOJ_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);
        ArrayList<Integer> arr = new ArrayList<>();
        int ap = 0, bp = 0;
        while (ap < n && bp < m) {
            if (a[ap] > b[bp]) {
                arr.add(b[bp++]);
            } else {
                arr.add(a[ap++]);
            }
        }

        while (ap < n) {
            arr.add(a[ap++]);
        }

        while (bp < m) {
            arr.add(b[bp++]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
