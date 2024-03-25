package programmers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 추억점수
 * https://school.programmers.co.kr/learn/courses/30/lessons/176963
 */
public class PGS_176963 {
    public static void main(String[] args) {
        /*System.out.println(Arrays.toString(solution(new String[] {"may", "kein", "kain", "radi"}
                , new int[] {5, 10, 1, 3}
                , new String[][] {{"may", "kein", "kain", "radi"}
                        ,{"may", "kein", "brin", "deny"}
                        , {"kon", "kain", "may", "coni"}})));*/
    }

    public static ArrayList<Integer> solution(String[] name, int[] yearning, String[][] photo) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            hm.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                sum += hm.getOrDefault(photo[i][j], 0);
            }
            answer.add(sum);
        }

        return answer;
    }
}
