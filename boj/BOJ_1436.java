package boj;

import java.util.Scanner;

/**
 * 영화감독 숌
 * https://www.acmicpc.net/problem/1436
 */
public class BOJ_1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 1) {
            getMovieName(n);
        } else {
            System.out.println(666);
        }
    }

    private static void getMovieName(int n) {
        int movieName = 666;
        int digit = 0;
        int idx = 1;
        while (true) {
            int cycle = 0;
            movieName++;
            digit = movieName;
            // 666 연속 검증    
            while (digit > 0) {
                if (digit % 10 == 6) {
                    cycle++;
                } else if (cycle < 3) {
                    cycle = 0;
                }
                digit = digit / 10;
            }

            // 3자리 연속을 넘으면 영화이름의 IDX개수가 증가
            if (cycle >= 3) {
                idx++;
            }

            // IDX 번째 영화 제목
            if (idx == n) {
                System.out.println(movieName);
                break;
            }
        }

    }
}
