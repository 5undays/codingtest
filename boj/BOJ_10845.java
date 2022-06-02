package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_10845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tail = 0, head = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            String cmd = line[0];
            if (cmd.equals("push")) {
                int data = Integer.parseInt(line[1]);
                if (q.isEmpty()) {
                    head = data;
                }
                tail = data;
                q.add(data);
            } else if (cmd.equals("back")) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(tail);
                }
            } else if (cmd.equals("size")) {
                System.out.println(q.size());
            } else if (cmd.equals("empty")) {
                if (q.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (cmd.equals("pop")) {
                if (q.isEmpty()) {
                    head = 0;
                    System.out.println(-1);
                } else {
                    int remove = q.remove();
                    System.out.println(remove);
                    if (!q.isEmpty()) {
                        head = q.peek();
                    } else {
                        head = 0;
                    }
                }
            } else if (cmd.equals("front")) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peek());
                }
            }
        }
    }
}
