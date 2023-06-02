package programmers;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 의상
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
public class PGS_42578 {
    public static void main(String[] args) {

    }

    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            hm.put(type, hm.getOrDefault(type, 0) + 1);
        }

        Iterator<Integer> iter = hm.values().iterator();

        while (iter.hasNext()) {
            answer *= iter.next().intValue() + 1;
        }

        return answer - 1;
    }
}
