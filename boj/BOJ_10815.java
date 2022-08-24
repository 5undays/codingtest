package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 숫자 카드
 * https://www.acmicpc.net/problem/10815
 */
public class BOJ_10815 {
    static int[] arrN;
    static int[] arrM;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arrN = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrN);
        StringBuffer sb = new StringBuffer();
        int m = Integer.parseInt(br.readLine());
        arrM = new int[m];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st2.nextToken());
            if (binarySearch(num)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static boolean binarySearch(int num) {
        int leftIdx = 0;
        int rightIdx = arrN.length - 1;
        while (leftIdx <= rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;
            int mid = arrN[midIdx];
            if (mid > num) {
                rightIdx = midIdx - 1;
            } else if (mid < num) {
                leftIdx = midIdx + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
