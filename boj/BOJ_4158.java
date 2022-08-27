package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * CD
 * https://www.acmicpc.net/problem/4158
 */
public class BOJ_4158 {
    static int[] arrN;
    static int[] arrM;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken()); // 상근이가 가진 CD
            int m = Integer.parseInt(st.nextToken()); // 선영이가 가진 CD
            if (n == 0 && m == 0) {
                break;
            } else {
                arrN = new int[n];
                arrM = new int[m];
                for (int i = 0; i < n; i++) {
                    arrN[i] = Integer.parseInt(br.readLine());
                }
                for (int i =0 ;i < m; i++) {
                    arrM[i] = Integer.parseInt(br.readLine());
                }   

                for (int i = 0; i < n; i++) {
                    if(binarySearch(arrN[i])) {
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static boolean binarySearch(int x) {
        int left = 0;
        int right = arrM.length- 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = arrM[mid];
            if (x > midValue) {
                left = mid + 1;
            } else if (x < midValue) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
