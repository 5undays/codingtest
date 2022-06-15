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
            if (cmd.equals("push")) { // 큐에 자료 넣는 연산
                int data = Integer.parseInt(line[1]);
                if (q.isEmpty()) {
                    head = data;
                }
                tail = data;
                q.add(data);
            } else if (cmd.equals("back")) { // 큐의 가장 뒤에 있는 자료를 보는 연산
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(tail);
                }
            } else if (cmd.equals("size")) { // 큐에 저장되어있는 자료의 개수를 알아보는 연산
                System.out.println(q.size());
            } else if (cmd.equals("empty")) { // 큐가 비어있는지 아닌지를 알아보는 연산
                if (q.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (cmd.equals("pop")) { // 큐에서 자료를 빼는 연산
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
            } else if (cmd.equals("front")) { // 큐의 가장 앞에 있는 자료를 보는 연산
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peek());
                }
            }
        }
    }
}
