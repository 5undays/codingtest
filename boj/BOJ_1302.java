package boj;

import java.util.*;
import java.util.Map;

/**
 * 베스트셀러
 * https://www.acmicpc.net/problem/1302
 */
public class BOJ_1302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> hm = new HashMap<>();

        int count = 0;
        while (n-- > 0) {
            String s = sc.next();
            hm.put(s, hm.getOrDefault(s, 0) + 1);
            count = Math.max(count, hm.getOrDefault(s, 0));
        }

        ArrayList<String> arr = new ArrayList<>();
        for (Map.Entry<String, Integer> e : hm.entrySet()) {
            if (count == e.getValue()) arr.add(e.getKey());
        }
        Collections.sort(arr);
        System.out.println(arr.get(0));
    }
}
