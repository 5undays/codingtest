package boj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/3085
public class BOJ_3085 {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int board_size = sc.nextInt();
        char[][] board = new char[board_size][board_size];
        for (int i = 0; i < board_size; i++) {
            board[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < board_size; i++) {
            for (int j = i; j < board_size; j++) {
                if (i + 1 < board_size) { // 오른쪽
                    // 위치 변경
                    char temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;
                    int temps = check(board);

                    if (temps > answer)
                        answer = temps;

                    // 재 배치
                    temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;
                }

                if (j + 1 < board_size) { // 아래
                    // 위치 변경
                    char temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;
                    int temps = check(board);
                    if (temps > answer)
                        answer = temps;
                    // 재 배치
                    temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;
                }
            }
        }

        System.out.println(answer);
    }

    public static int check(char[][] board) {
        int answer = 1;
        for (int i = 0; i < board.length; i++) {
            int cnt = 1;
            for (int j = 1; j < board.length; j++) {
                if (board[i][j] == board[i][j - 1]) { // 위
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (answer < cnt) {
                    answer = cnt;
                }
            }
            cnt = 1;
            for (int j = 1; j < board.length; j++) {
                if (board[j][i] == board[j - 1][i]) { // 왼쪽
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (answer < cnt) {
                    answer = cnt;
                }
            }
        }

        return answer;
    }

}
