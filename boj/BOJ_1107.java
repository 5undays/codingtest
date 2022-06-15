package boj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1107
// 리모컨
public class BOJ_1107 {

    static boolean[] broken = new boolean[10]; // 고장난 번호 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 이동하고자 하는 번호
        int M = sc.nextInt(); // 고장난 번호의 개수
        for (int i = 0; i < M; i++) {
            int number = sc.nextInt(); // 고장난 번호
            broken[number] = true;
        }
        int answer = N - 100;
        if (answer < 0)
            answer = -answer;

        for (int i = 0; i < 1000000; i++) {
            int current = i;
            int length = possible(current);
            // 고장난 버튼이 없는 경우 +- 를 몇번 눌러야 하는지 
            if (length > 0) {
                int press = current - N;
                if (press < 0) {
                    press = -press;
                }
                if (answer > length + press) {
                    answer = length + press;
                    System.out.println(answer);
                }
            }
        }

        System.out.println(answer);

    }

    /**
     * 
     * @param current
     * @return
     */
    private static int possible(int current) {
        if (current == 0) {
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }

        int length = 0;
        while (current > 0) {
            if (broken[current % 10])
                return 0;
            length++;
            current /= 10;
        }
        return length;
    }
}
