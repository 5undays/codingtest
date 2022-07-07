package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * AC
 * https://www.acmicpc.net/problem/5430
 */
public class BOJ_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 갯수
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String p = br.readLine(); // 수행할 함수
            int n = Integer.parseInt(br.readLine()); // 배열에 들어간 개수
            Deque<Integer> d = new LinkedList<>();
            String s = br.readLine();
            String[] data = s.substring(1, s.length() - 1).split(",");

            for (int i = 0; i < n; i++) {
                d.add(Integer.parseInt(data[i]));
            }

            boolean isRight = true;
            boolean exp = false;
            for (int i = 0; i < p.length(); i++) {
                char recomend = p.charAt(i);
                if (recomend == 'R') {
                    isRight = !isRight;
                } else if (recomend == 'D') { // 버리기
                    if (d.peek() == null) {
                        exp = true;
                        break;
                    }
                    if (isRight) {
                        d.removeFirst();
                    } else {
                        d.removeLast();
                    }
                }
            }

            if (d.size() > 0 || !exp) {
                sb.append("[");
                while (!d.isEmpty()) {
                    if (isRight) {
                        sb.append(d.pollFirst());
                    } else {
                        sb.append(d.pollLast());
                    }

                    if (d.size() > 0) {
                        sb.append(",");
                    }
                }
                sb.append("]");
            } else {
                sb.append("error");
            }
            if (t != 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);

    }
}
