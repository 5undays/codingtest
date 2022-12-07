package boj;

import java.util.*;

/**
 * 후보 추천하기
 * https://www.acmicpc.net/problem/1713
 */
public class BOJ_1713 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 사진틀
        int chuchun = sc.nextInt(); // 추천 횟수
        ArrayList<Pictrue> result = new ArrayList<>();
        for (int i = 0; i < chuchun; i++) {
            int num = sc.nextInt();
            boolean flag = true;
            for (int j = 0; j < result.size(); j++) {
                if (result.get(j).num == num) {
                    result.get(j).chuchun = result.get(j).chuchun + 1; // 이미 값이 있는 경우
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (result.size() >= n) {
                    Collections.sort(result);
                    result.remove(0);
                }
                result.add(new Pictrue(i, num, 1));
            }
        }

        Collections.sort(result, new Comparator<Pictrue>() {
            @Override
            public int compare(Pictrue o1, Pictrue o2) {
                return o1.num - o2.num;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Pictrue p : result) {
            sb.append(p.num).append(" ");
        }
        System.out.println(sb);
    }

    static class Pictrue implements Comparable<Pictrue> {
        int idx;
        int num;
        int chuchun;

        Pictrue(int idx, int num, int chuchun) {
            this.idx = idx;
            this.num = num;
            this.chuchun = chuchun;
        }

        @Override
        public int compareTo(Pictrue o) {
            if (this.chuchun == o.chuchun) {
                return this.idx - o.idx;
            }
            return this.chuchun - o.chuchun;
        }
    }
}
