package boj;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_2161 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> arr = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (arr.size() > 1) {
            sb.append(arr.removeFirst()).append(" ");
            int k = arr.removeFirst();
            arr.addLast(k);
        }

        sb.append(arr.removeLast());
        System.out.println(sb);
    }
}
