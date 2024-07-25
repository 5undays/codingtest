package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (n -- > 0) {
            st = new StringTokenizer(br.readLine());
            char[] a = st.nextToken().toCharArray();
            char[] b = st.nextToken().toCharArray();

            Arrays.sort(a);
            Arrays.sort(b);

            boolean flag = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                sb.append("Impossible");
            } else {
                sb.append("Possible");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
