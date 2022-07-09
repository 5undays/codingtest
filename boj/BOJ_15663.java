package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * N과 M (9)
 * https://www.acmicpc.net/problem/15663
 */
public class BOJ_15663 {
    static int[] data = new int[10];
    static int[] a = new int[10];
    static ArrayList<Result> d = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data, 0, n);
        go(0, n, m);
        Collections.sort(d);
        for (int i = 0; i < d.size(); i++) {
            if (i == 0 || !d.get(i).equals(d.get(i - 1))) {
                for (int j = 0; j < m; j++) {
                    sb.append(d.get(i).get(j));
                    if (i != m - 1) {
                        sb.append(" ");
                    }
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void go(int index, int n, int m) {
        if (index == m) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                temp.add(data[a[i]]);
            }
            d.add(new Result(temp));
            return;
        }

        if (index < n) {
            for (int i = 0; i < n; i++) {
                a[index] = i;
                go(index + 1, n, m);
            }
        }
    }
}

class Result implements Comparable<Result> {
    Integer[] a;

    Result(ArrayList<Integer> a) {
        this.a = a.toArray(new Integer[a.size()]);
    }

    int get(int index) {
        return (int) this.a[index];
    }

    public boolean equals(Object obj) {
        if (obj instanceof Result) {
            Result that = (Result) obj;
            int n = this.a.length;
            for (int i = 0; i < n; i++) {
                if (this.a[i] != that.a[i]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Result that) {
        int n = this.a.length;
        for (int i = 0; i < n; i++) {
            if (this.a[i] == that.a[i])
                continue;
            if (this.a[i] < that.a[i])
                return -1;
            if (this.a[i] > that.a[i])
                return 1;
        }
        return 0;
    }

}