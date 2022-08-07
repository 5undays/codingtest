package boj;

import java.util.Scanner;
import java.util.Stack;

/**
 * 스택 수열
 * https://www.acmicpc.net/problem/1874
 */
public class BOJ_1874 {
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int i = 0;
        
        Stack<Integer> s = new Stack();
        for (int x : arr) {
            if (i < x) { // 배열보다 스택에 쌓일 값이 작을때
                while (x > i) { // 스택에 쌓인 값이 쌓여질 값보다 커질때까지
                    s.push(++i);
                    sb.append("+\n");
                }
            } else {
                if (s.peek() != x) { // 배열보다 스택에 쌓일 값이 같지 않을때
                    System.out.println("NO");
                    System.exit(0);
                }
            }
            s.pop();
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}
