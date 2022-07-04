package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 좌표 정렬하기
 * https://www.acmicpc.net/problem/11650
 */
public class BOJ_11650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Dimension> xy = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Dimension d = new Dimension(sc.nextInt(), sc.nextInt());
            xy.add(d);
        }

        Collections.sort(xy, new Comparator<Dimension>() {

            @Override
            public int compare(Dimension o1, Dimension o2) {
                // TODO Auto-generated method stub
                if (o1.x == o2.x) {
                    return o1.y - o2.y;
                } else {
                    return o1.x - o2.x;
                }
            }

        });
        StringBuilder sb = new StringBuilder();
        for (Dimension d : xy) {
            sb.append(d.x).append(" ").append(d.y).append("\n");
        }
        System.out.println(sb);
    }
}

class Dimension {
    int x;
    int y;

    Dimension(int x, int y) {
        this.x = x;
        this.y = y;
    }

}