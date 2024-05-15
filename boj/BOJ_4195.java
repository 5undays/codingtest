package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_4195 {
    static HashMap<String, Integer> nodes;
    static int[] parent;
    static int[] network;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int f = Integer.parseInt(br.readLine());
            nodes = new HashMap<>();
            parent = new int[f * 2];
            network = new int[f * 2];
            int index = 0;

            for (int j = 0 ; j < f * 2; j++) {
                parent[j] = j;
                network[j] = 1;
            }

            for (int j = 0; j < f; j++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!nodes.containsKey(a)) {
                    nodes.put(a, index++);
                }
                if (!nodes.containsKey(b)) {
                    nodes.put(b, index++);
                }

                sb.append(union(nodes.get(a), nodes.get(b))).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
            network[a] += network[b];
            parent[a] = b;
            network[b] += network[a];
        }

        return network[a];
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

}