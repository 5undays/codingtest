package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                int k = s.charAt(i) + 13;
                if ((k > 'Z' && Character.isUpperCase(s.charAt(i)))
                        || (k > 'z' && Character.isLowerCase(s.charAt(i)))) {
                    k -= 26;
                }
                sb.append((char) k);
            } else {
                sb.append(s.charAt(i));
            }
        }

        System.out.println(sb);
    }
}
