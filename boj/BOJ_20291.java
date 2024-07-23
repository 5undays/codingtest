package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 파일 정리
 * https://www.acmicpc.net/problem/20291
 */
public class BOJ_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();

        while (n-- > 0) {
            String[] file = br.readLine().split("\\.");
            hm.put(file[1], hm.getOrDefault(file[1], 0) + 1);
        }

        List<String> arr2 = new ArrayList<>(hm.keySet());
        Collections.sort(arr2);

        StringBuilder sb = new StringBuilder();
        for (String s: arr2) {
            sb.append(s + " " +hm.get(s) + "\n");
        }
        System.out.println(sb);
    }
}
