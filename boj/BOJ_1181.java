package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 단어 정렬
 * https://www.acmicpc.net/problem/1181
 */
public class BOJ_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o1.length() - o2.length();
            }
        });

        System.out.println(list.get(0));
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < n; i++) {
            if (!list.get(i).equals(list.get(i - 1))) {
                System.out.println(list.get(i));
            }
        }
    }
}
