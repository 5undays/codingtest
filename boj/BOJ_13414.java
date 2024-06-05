package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 수강신청
 * https://www.acmicpc.net/problem/13414
 */
public class BOJ_13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); // 과목의 수강 가능 인원
        int l = Integer.parseInt(st.nextToken()); // 학생들이 버튼을 클릭한 순서를 기록한 대기목록의 길이

        LinkedHashSet<String> arr = new LinkedHashSet<>();

        for (int i = 0; i < l; i++) {
            String s = br.readLine();
            arr.remove(s);
            arr.add(s);
        }

        StringBuilder sb = new StringBuilder();

        Iterator iter = arr.iterator();

        while (iter.hasNext() && k-- > 0) {
            sb.append(iter.next()).append("\n");
        }

        System.out.println(sb);
    }
}
