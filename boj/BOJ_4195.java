package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_4195 {
    static int[] parent;
    static HashMap<String, String> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            int f = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            for (int j = 0; j < f; j++) {
                st = new StringTokenizer(br.readLine());
                String friend = st.nextToken();
                String friend2 = st.nextToken();
                map.put(friend, friend2);
                map.put(friend2, friend);

            }
        }
    }

    /**
     * 부모 노드 찾기
     * @param x
     * @return
     */
    /*static String find(String x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    *//**
     * 부모 노드를 병합
     * @param a
     * @param b
     *//*
    static void union(int a, int b) {
        x = find(a);
        y = find(b);
        if (x != y) {
            parent[y] = x;
        }
    }*/
}
