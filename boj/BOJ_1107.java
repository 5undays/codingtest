package boj;

import java.util.Scanner;

/**
 * 리모컨
 * https://www.acmicpc.net/problem/1107
 */
public class BOJ_1107 {

    static boolean[] broken = new boolean[10]; // 고장난 번호 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 이동하고자 하는 번호
        int M = sc.nextInt(); // 고장난 번호의 개수
        for (int i = 0; i < M; i++) {
            broken[sc.nextInt()] = true;
        }
        // 이동하고자 하는 번호로 가기위해 버튼을 눌러야 하는 횟수 ( 기본 100 번 채널 부터 시작 )
        int answer = Math.abs(N - 100);

        for (int i = 0; i < 1000000; i++) {
            int count = possible(i);
            // 고장난 버튼이 없는 경우 +- 를 몇번 눌러야 하는지
            if (count > 0) {
                int press = Math.abs(i - N);

                // 가장 작은 횟수로 작동할 수 있는 경우를 업데이트 해줌
                if (answer > count + press) {
                    answer = count + press;
                }
            }
        }

        System.out.println(answer);

    }

    /**
     * 고장난 버튼이 있는지 확인
     * 
     * @param current 현재 번호
     * @return 버튼 눌러야 하는 횟수
     */
    private static int possible(int current) {
        if (current == 0) {
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }

        int cnt = 0;
        while (current > 0) {
            if (broken[current % 10])
                return 0;
            cnt++;
            current /= 10;
        }
        return cnt;
    }
}
