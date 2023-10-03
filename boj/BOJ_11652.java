package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BOJ_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long k = Long.parseLong(br.readLine());
            hm.put(k, hm.getOrDefault(k, 0) + 1);
        }

        long answer = 0;
        int count = 0;
        Iterator<Map.Entry<Long, Integer>> iter = hm.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Long, Integer> e = iter.next();
            if (count < e.getValue() || (count == e.getValue() && e.getKey() < answer)) {
                answer = e.getKey();
                count = e.getValue();
            }
        }
        System.out.println(answer);
    }
}
