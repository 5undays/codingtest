package boj;

import java.util.Scanner;

// 테트로미노
//https://www.acmicpc.net/problem/14500
public class BOJ_14500 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 가로
        int M  = sc.nextInt(); // 세로
        int[][] numbers = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = i; i <M; j++) {
                numbers[i][j] = sc.nextInt();
            }
        }

        int answer = 0;

        for (int i = 0; i < N;i ++) {
            for (int j = 0 ; j < M; j++) {
                if (i+3 < N ) {
                    int temp = numbers[i][j] + numbers[i][j+1] + numbers[i][j+2]+ numbers[i][j+3];
                    if (answer < temp) answer = temp;
                }
                if (j+3 < M) {
                    int temp = numbers[i][j] + numbers[i+1][j] + numbers[i+2][j] + numbers[i+3][j];
                    if (answer < temp) answer = temp;
                }

                if (i+1 < N && j+1 < M) {
                    int temp = numbers[i][j] + numbers[i+1][j] + numbers[i][j+1] + numbers[i+1][1+i];
                    if (answer < temp) answer = temp;
                }

                if (i+1 < N && j+2 < M) {
                    int temp = numbers[i][j] + numbers[i+1][j] + numbers[i+1][j+1] + numbers[i+1][j+2];
                    if (answer < temp) answer = temp;
                }

                if (i+2 < N && j+1 < M) {
                    int temp = numbers[i][j] + numbers[i][j+1];
                }

            }
        }
        System.out.println();       
    }
}
