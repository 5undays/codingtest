package programmers;

import java.util.HashMap;

/**
 * 가장 많이 받은 선물
 * https://school.programmers.co.kr/learn/courses/30/lessons/258712
 */
public class PGS_258712 {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"muzi", "ryan", "frodo", "neo"}
                , new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));

    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, HashMap<String, Integer>> hm = new HashMap<>();
        for (String s : friends) {
            hm.put(s, new HashMap<>());
        }

        HashMap<String, Integer> givenHm = new HashMap<>();
        HashMap<String, Integer> giverHm = new HashMap<>();

        for (int i = 0; i < gifts.length; i++) {
            String[] arr = gifts[i].split(" ");
            String giver = arr[0];
            String given = arr[1];

            hm.get(giver).put(given, hm.get(giver).getOrDefault(given, 0) + 1);

            giverHm.put(giver, giverHm.getOrDefault(giver, 0) + 1);
            givenHm.put(given, givenHm.getOrDefault(given, 0) + 1);
        }

        HashMap<String, Integer> gift = new HashMap<>();

        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < i; j++) {
                String a = friends[i];
                String b = friends[j];

                int give = hm.get(a).getOrDefault(b, 0);
                int take = hm.get(b).getOrDefault(a, 0);

                if (give > take) {
                    gift.put(a, gift.getOrDefault(a, 0) + 1);
                } else if (give < take) {
                    gift.put(b, gift.getOrDefault(b, 0) + 1);
                } else {
                    int t = giverHm.getOrDefault(a, 0) - givenHm.getOrDefault(a, 0);
                    int k = giverHm.getOrDefault(b, 0) - givenHm.getOrDefault(b, 0);
                    if (t < k) {
                        gift.put(b, gift.getOrDefault(b, 0) + 1);
                    } else if (t > k) {
                        gift.put(a, gift.getOrDefault(a, 0) + 1);
                    }
                }
            }
        }

        for (int k : gift.values()) {
            answer = Math.max(answer, k);
        }

        return answer;
    }
}
