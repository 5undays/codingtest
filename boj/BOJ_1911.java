package boj;

import java.util.*;
import java.io.*;

class HelloWorld {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int l = Integer.parseInt(st.nextToken()); 
        int[][] arr = new int[n][2];
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i][1]);
		}
		
		int[] map = new int[max];
		
		for (int i = 0; i < n; i++) {
			int start = arr[i][0];
			int end = arr[i][1];
			
			for (int j = start + 1; j < end; j++) {
				map[j] = 1;
			}
		}
		
		int answer = 0;
		
		for (int i = 0; i < max; i++) {
			if (map[i] == 1) {
				answer++;
				for (int j = 0; j < map[i] + l; j++) {
					if (map[i] + l < max) {
						map[j] = 0;
					}
				}
			}
		}
		
        System.out.println(answer);
    }
}