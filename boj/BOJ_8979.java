package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Olympic> arr = new ArrayList<>();
        int same = 0;
        for (int i =0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            arr.add(new Olympic(key, gold, silver, bronze));
        }

        Collections.sort(arr);

        int answer = 1;
        if (arr.get(0).country == k) {
            System.out.println(answer);
            System.exit(-1);
        }

        for (int i = 1; i < n; i++) {
            Olympic prev = arr.get(i - 1);
            Olympic o = arr.get(i);
            if (prev.gold != o.gold || prev.silver != o.silver || prev.bronze != o.bronze) {
                answer++;
                answer += same;
                same = 0;
            }else{
                same++;
            }
            if (k == o.country) {
                break;
            }
        }

        System.out.println(answer);
    }

     static class Olympic implements Comparable<Olympic> {
        int country;
        int gold;
        int silver;
        int bronze;

        public Olympic(int country, int gold, int silver, int bronze) {
            this.country = country;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }


         @Override
         public int compareTo(Olympic o) {
             if (o.gold == this.gold) {
                 if (o.silver == this.silver) {
                     return o.bronze > this.bronze ? 1: -1;
                 }
                 else {
                     return o.silver > this.silver ? 1 : -1;
                 }
             }
             else {
                 return o.gold > this.gold ? 1 : -1;
             }

         }
     }
}
