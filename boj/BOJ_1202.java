package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 보석 도둑
 * https://www.acmicpc.net/problem/1202
 */
public class BOJ_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 보석 개수
        int k = Integer.parseInt(st.nextToken()); // 가방 개수
        PriorityQueue<Jewelry> pq = new PriorityQueue<>(new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                return o2.price - o1.price;
            }
        });
        ArrayList<Jewelry> jewelries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 무개
            int v = Integer.parseInt(st.nextToken()); // 가격
            jewelries.add(new Jewelry(m, v));
        }
        Collections.sort(jewelries);

        ArrayList<Integer> bag = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            bag.add(Integer.parseInt(br.readLine())); // 가방에 담을 수 있는 최대 무게
        }
        Collections.sort(bag);

        long answer = 0;
        int index = 0;
        for (int i = 0; i < k; i++) {
            for (int j = index; j < n; j++) {
                Jewelry jewel = jewelries.get(j);
                if (jewel.kg <= bag.get(i)) {
                    index++;
                    pq.add(new Jewelry(jewel.kg, jewel.price));
                } else {
                    break;
                }
            }
            if (!pq.isEmpty()) {
                answer += pq.poll().price;
            }
        }
        System.out.println(answer);
    }

    static class Jewelry implements Comparable<Jewelry> {
        int price;
        int kg;

        Jewelry(int kg, int price) {
            this.price = price;
            this.kg = kg;
        }

        @Override
        public int compareTo(Jewelry o) {
            return this.kg - o.kg;
        }
    }
}
