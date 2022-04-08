package boj;

import java.util.Scanner;

// https://www.acmicpc.net/problem/3085
public class BOJ_3085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int board_size = sc.nextInt();
        char[][] board = new char[board_size][board_size];
        for (int i = 0; i < board_size ;i++) {
            for (int j = 0; j < board_size; j++) {
                board[i] = sc.next().toCharArray();
            }
        }

        for (int i = 0 ; i < board_size; i++) {
            for (int j = i ; j < board_size; j ++) {
                if (i + 1 < board_size) {

                }

                if (j + 1 < board_size) {
                    
                }
            }
        }
    }


}
