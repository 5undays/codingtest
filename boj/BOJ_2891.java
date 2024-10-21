package boj;

import java.util.*;
import java.io.*;

class BOJ_2891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            arr[Integer.parseInt(st.nextToken())] = -1;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
			int k = Integer.parseInt(st.nextToken());
			if (arr[k] == -1) {
				arr[k] = 0;
			} else {
				arr[k] = 1;
			}
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i] == -1) {
                if (arr[i - 1] == 1) {
                    arr[i - 1] = 0;
                    arr[i] = 0;
                } else if (arr[i + 1] == 1) {
                    arr[i + 1] = 0;
                    arr[i] = 0;
                }
            }
        }
        
        for (int i = 0; i <= n; i++) {
            if (arr[i] == -1) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}