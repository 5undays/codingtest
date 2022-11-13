package boj;

import java.util.Scanner;
import java.util.Stack;

/**
 * 우유 축제
 * https://www.acmicpc.net/problem/14720
 */
public class BOJ_14720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        while (n-- > 0) {
            int x = sc.nextInt();
            if (s.isEmpty() && x == 0) { // 1. 맨 처음에는 딸기우유를 한 팩 마신다.
                s.push(x);
                answer++;
            }
            if (!s.isEmpty()) {
                if (s.peek() == 0 && x == 1) { // 2.딸기우유를 한 팩 마신 후에는 초코우유를 한 팩 마신다.
                    s.push(x);
                    answer++;
                }
                if (s.peek() == 1 && x == 2) { // 3.초코우유를 한 팩 마신 후에는 바나나우유를 한 팩 마신다.
                    s.push(x);
                    answer++;
                }
                if (s.peek() == 2 && x == 0) { // 4.바나나우유를 한 팩 마신 후에는 딸기우유를 한 팩 마신다.
                    s.push(x);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
