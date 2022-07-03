package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 보물
 * https://www.acmicpc.net/problem/1026
 */
public class BOJ_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            b.add(Integer.parseInt(st2.nextToken()));
        }

        Collections.sort(a);
        Collections.sort(b, Comparator.reverseOrder());

        int answer = 0;

        for (int i = 0; i < n; i++) {
            //System.out.println(a.get(i) + ", " + b.get(i));
            int t = (int) a.get(i) * (int) b.get(i);
            answer += t;
        }

        System.out.println(answer);
    }
}
