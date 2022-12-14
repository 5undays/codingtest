package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두 배열의 합
 * https://www.acmicpc.net/problem/2143
 */
public class BOJ_2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            a[i] += a[i - 1];
        }

        for (int i = 1; i < m; i++) {
            b[i] += b[i - 1];
        }

        int aSize = n * (n + 1) / 2;
        int bSize = m * (m + 1) / 2;
        long[] aSum = new long[aSize];
        long[] bSum = new long[bSize];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = a[j];
                if (i > 0) sum -= a[i - 1];
                aSum[idx++] = sum;
            }
        }

        idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int sum = b[j];
                if (i > 0) sum -= b[i - 1];
                bSum[idx++] = sum;
            }
        }

        Arrays.sort(aSum);
        Arrays.sort(bSum);

        long answer = 0;
        int left = 0;
        int right = bSize - 1;
        while (left < aSize && right > -1) {
            long currentA = aSum[left], currentB = bSum[right];
            long sum = currentA + currentB;
            if (sum == t) {
                long ac = 0, bc = 0;
                while (left < aSize && currentA == aSum[left]) {
                    left++; ac++;
                }
                while (right > -1 && currentB == bSum[right]) {
                    right--; bc++;
                }
                answer += ac * bc;
            } else if (sum > t) {
                right--;
            } else if (sum < t) {
                left++;
            }
        }
        System.out.println(answer);
    }
}
