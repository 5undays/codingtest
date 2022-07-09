package boj;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 프린터 큐
 * https://www.acmicpc.net/problem/1966
 */
public class BOJ_1966 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        for (int i = 0; i < cnt; i++) {
            int count = 0;
            int n = sc.nextInt(); // 문서의 개수
            int m = sc.nextInt(); // 궁금한 인덱스

            LinkedList<Print> q = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                q.add(new Print(j, sc.nextInt()));
            }

            while (!q.isEmpty()) {
                Print p = q.poll();
                boolean isMax = true;

                for (int v = 0; v < q.size(); v++) {
                    if (p.important < q.get(v).important) {
                        q.offer(p);
                        for (int w = 0; w < v; w++) {
                            q.offer(q.poll());
                        }
                        isMax = false;
                        break;
                    }
                }

                if (!isMax)
                    continue;

                count++;

                if (p.num == m) {
                    break;
                }
            }
            System.out.println(count);
        }
    }

    static class Print {
        int num;
        int important;

        Print(int num, int important) {
            this.num = num;
            this.important = important;
        }
    }
}
