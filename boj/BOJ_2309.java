package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 일곱난쟁이
 * https://www.acmicpc.net/problem/2309
 */
public class BOJ_2309 {

    static final int MAX_HEIGHT = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] mans = new int[9];
        int total_height = 0;
        for (int i = 0; i < 9; i++) {
            mans[i] = sc.nextInt();
            total_height += mans[i];
        }

        int find_height = total_height - MAX_HEIGHT;

        Arrays.sort(mans);

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (mans[i] + mans[j] == find_height) {
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j)
                            continue;
                        System.out.println(mans[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}
