package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 숫자 카드
 * https://www.acmicpc.net/problem/10815
 */
public class BOJ_10815 {
    static int[] arrN;
    static int[] arrM;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arrN = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        arrM = new int[m];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            arrM[i] = Integer.parseInt(st2.nextToken());
        }

        StringBuffer sb = new StringBuffer();
        int[] result = countingSort();
        for (int x : result) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }

    private static int[] countingSort() {
        int[] result = new int[arrM.length];
        boolean[] arr = new boolean[20000001];
        for (int i = 0; i < arrN.length; i++) {
            arr[arrN[i]] = true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                result[i] = 1;
            }
        }

        return result;
    }
}
