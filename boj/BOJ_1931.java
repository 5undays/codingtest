package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 회의실 배정
 * https://www.acmicpc.net/problem/1931
 */
public class BOJ_1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Meeting> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Meeting(sc.nextInt(), sc.nextInt()));
        }
        sc.close();

        Collections.sort(arr);
        int count = 0;
        int prev_end = 0;
        for (int i = 0; i < n; i++) {
            if (arr.get(i).start >= prev_end) {
                prev_end = arr.get(i).end;
                count++;
            }
        }

        System.out.println(count);
    }

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
}
