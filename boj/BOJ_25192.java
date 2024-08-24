package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();
        int answer = 0;
        while (n -- > 0) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                answer += hs.size();
                hs = new HashSet<>();
            } else {
                hs.add(s);
            }
        }
        answer += hs.size();
        System.out.println(answer);
    }
}
