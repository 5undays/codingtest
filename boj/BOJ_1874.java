package boj;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874 {
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        valid(arr);
        System.out.println(sb);
    }

    public static void valid(int[] arr) {
        Stack<Integer> s = new Stack();
        int i = 0;
        for (int x : arr) {
            if (i < x) { // 배열보다 스택에 쌓일 값이 작을때
                while (x > i) { // 스택에 쌓인 값이 쌓여질 값보다 커질때까지
                    s.push(++i);
                    sb.append("+\n");
                }
            } else { 
                if (s.peek() != x) { // 배열보다 스택에 쌓일 값이 같지 않을때 
                    System.out.println("NO");
                    break;
                }
            }
            s.pop(); 
            sb.append("-\n");
        }
    }
}
