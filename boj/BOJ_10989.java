package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 수 정렬하기 3
 * https://www.acmicpc.net/problem/10989
 */
public class BOJ_10989 {
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        // Collections.sort(list);
        countingSort();

        for (int x : list) {
            sb.append(x).append("\n");
        }
        System.out.println(sb);
    }

    private static void countingSort() {
        int[] arr = new int[10001];
        for (int x : list) {
            arr[x]++;
        }

        int reset = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                list.add(reset++, i);
                arr[i]--;
            }
        }
    }
}
