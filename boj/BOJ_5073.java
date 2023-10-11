package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_5073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(true) {
            int[] arr = new int[3];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                break;
            }

            Arrays.sort(arr);
            if (arr[2] >= arr[0] + arr[1]) {
                sb.append("Invalid");
            } else if (arr[0] == arr[1] && arr[1] == arr[2]) {
                sb.append("Equilateral");
            } else if (arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]) {
                sb.append("Isosceles");
            } else {
                sb.append("Scalene");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
