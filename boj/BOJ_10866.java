package boj;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_10866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> d = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] line = sc.next().split(" ");
            String cmd = line[0].toString();
            if (cmd.equals("push_front")) {
                int data = Integer.parseInt(line[1]);
                d.addFirst(data);
            } else if (cmd.equals("push_back")) {
                int data = Integer.parseInt(line[1]);
                d.addLast(data);
            } else if (cmd.equals("pop_front")) {
                if (d.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(d.pollFirst());
                }
            } else if (cmd.equals("size")) {
                System.out.println(d.size());
            } else if (cmd.equals("empty")) {
                if (d.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (cmd.equals("front")) {
                if (d.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(d.peekFirst());
                }
            } else if (cmd.equals("back")) {
                if (d.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(d.peekLast());
                }
            }
        }
    }
}
