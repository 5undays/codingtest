package boj;

        import java.util.Scanner;

/**
 * 아!
 * https://www.acmicpc.net/problem/4999
 */
public class BOJ_4999 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String s1 = sc.next();
        if (s1.length() > s.length()) {
            System.out.println("no");
        } else {
            System.out.println("go");
        }
    }
}
