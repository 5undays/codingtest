package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 배
 * https://www.acmicpc.net/problem/1092
 */
public class BOJ_1092 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> ships = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ships.add(sc.nextInt());
        }
        int m = sc.nextInt();
        ArrayList<Integer> boxes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            boxes.add(sc.nextInt());
        }

        Collections.sort(boxes, Collections.reverseOrder());
        Collections.sort(ships, Collections.reverseOrder());

        int answer = 0;
        if (ships.get(0) < boxes.get(0)) {
            answer = -1;
        } else {
            while (!boxes.isEmpty()) {
                int index = 0;
                for (int i = 0; i < n; ) {
                    if (index == boxes.size()) break;
                    if (boxes.get(index) <= ships.get(i)) {
                        boxes.remove(index);
                        i++;
                    } else {
                        index++;
                    }
                }
                answer++;
            }
        }
        System.out.println(answer);

    }
}
