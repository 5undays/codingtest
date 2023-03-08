package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 용돈 관리
 * https://www.acmicpc.net/problem/6236
 */
public class BOJ_6236 {
    static int n;
    static int m;
    static int min = 1;
    static int max = 0;
    static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        money = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
            max += money[i];
        }

        while (min <= max) {
            int mid = (min + max) / 2;
            if (isValid(mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min);
    }

    private static boolean isValid(int k) {
        int spend = k;
        int count = 1;
        for (int i = 0; i < n; i++) {
            // 사용할 금액보다 인출 금액이 적으면 반려
            if (k < money[i]) {
                return false;
            }
            // 사용할 금액보다 남은 금액이 적으면 인출
            if (spend < money[i]) {
                spend = k;
                count++;
            }
            spend -= money[i];
        }
        return m >= count;
    }
}
