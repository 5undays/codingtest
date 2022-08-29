package boj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 최댓값
 * https://www.acmicpc.net/problem/2562
 */
public class BOJ_2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Num> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(new Num(i + 1, sc.nextInt()));
        }

        int max = 0, index = 0;
        for (int i = 0; i < 9; i++) {
            if (max < list.get(i).value) {
                max = list.get(i).value;
                index = list.get(i).index;
            }
        }
        System.out.println(max + "\n" + index);
        sc.close();
    }
}

class Num {
    int index;
    int value;

    Num(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
