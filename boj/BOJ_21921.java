package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0, sum = 0, count = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (i == x - 1) {
                max = sum;
                count = 1;
            } else if (i > x - 1) {
                sum -= arr[i - x];

                if (max < sum) {
                    max = sum;
                    count = 1;
                } else if (max == sum) {
                    count += 1;
                }
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max + "\n" + count);
        }
    }
}
