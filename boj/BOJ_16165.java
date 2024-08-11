package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 걸그룹 마스터 준석이
 * https://www.acmicpc.net/problem/16165
 */
public class BOJ_16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        HashMap<String, String[]> arr = new HashMap<>();
        HashMap<String, String> arr2 = new HashMap<>();
        while (n-- > 0) {
            String group = br.readLine();
            int number = Integer.parseInt(br.readLine());
            String[] member = new String[number];
            for (int i = 0; i < number; i++) {
                member[i] = br.readLine();
                arr2.put(member[i], group);
            }
            Arrays.sort(member);
            arr.put(group, member);
        }

        while (m -- > 0) {
            String name = br.readLine();
            int number = Integer.parseInt(br.readLine());
            if (number == 1) {
                sb.append(arr2.get(name)).append("\n");
            } else {
                String[] group = arr.get(name);
                for (int i = 0; i < group.length; i++) {
                    sb.append(group[i]).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
