package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과 M (11)
 * https://www.acmicpc.net/problem/15665
 */
public class BOJ_15665 {
    static int[] num = new int[10];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = sc.nextInt();
        }
        Arrays.sort(temp);
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && temp[i] == temp[i - 1]) { // 중복 숫자 제거
                continue;
            }
            num[k++] = temp[i];
        }
        n = k;
        System.out.println(go(0, n, m));
    }

    static StringBuilder sb = new StringBuilder();
    static int[] a = new int[10];

    static StringBuilder go(int index, int n, int m) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<m; i++) {
                sb.append(num[a[i]]);
                if (i != m-1) sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder ans = new StringBuilder();
        for (int i=0; i<n; i++) {
            //if (c[i]) continue;
            //c[i] = true;
            a[index] = i;
            ans.append(go(index+1, n, m));
            //c[i] = false;
        }
        return ans;
    } 
}
