package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 언어 정렬
 * https://www.acmicpc.net/problem/1181
 */
public class BOJ_1181 {
    static ArrayList<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, (o1, o2) -> o1.length() > o2.length() ? 1 : -1);

        StringBuffer sb = new StringBuffer();
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    private static void length() {
        for (int i = 1; i < list.size(); i++) {
            String len = list.get(i);
            String diff = list.get(i - 1);
            if (len.length() < diff.length()) {
                list.add(i - 1, len);
                list.add(i, diff);
            }
        }
    }
}
