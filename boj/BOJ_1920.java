package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1920 {
    static int n;
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            if (binarySearch(sc.nextInt()) >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static int binarySearch(int x) {
        int start = 0, end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = list.get(mid);
            if (midValue > x) {
                end = mid - 1;
            } else if (midValue < x) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
