package boj;

import java.util.Scanner;

public class BOJ_28702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        for (int i = 3; i > 0; i--) {
            String s = sc.next();
            if (!"FizzBuzz".equals(s) && !"Buzz".equals(s) && !"Fizz".equals(s)) {
                answer = Integer.parseInt(s) + i;
            }
        }

        if (answer % 3 == 0 && answer % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (answer % 3 == 0) {
            System.out.println("Fizz");
        } else if (answer % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(answer);
        }
    }
}
