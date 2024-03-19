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

        HashMap<String, Integer> takeHm = new HashMap<>();
        HashMap<String, Integer> giveHm = new HashMap<>();

        for (int i = 0; i < gifts.length; i++) {
            String[] arr = gifts[i].split(" ");
            String give = arr[0];
            String take = arr[1];

            hm.get(give).put(take, hm.get(give).getOrDefault(take, 0) + 1);

            giveHm.put(give, giveHm.getOrDefault(give, 0) + 1);
            takeHm.put(take, takeHm.getOrDefault(take, 0) + 1);
        }

        HashMap<String, Integer> gift = new HashMap<>();

        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < i; j++) {
                String a = friends[i];
                String b = friends[j];

                int aNumber = hm.get(a).getOrDefault(b, 0);
                int bNumber = hm.get(b).getOrDefault(a, 0);

                if (aNumber > bNumber) {
                    gift.put(a, gift.getOrDefault(a, 0) + 1);
                } else if (aNumber < bNumber) {
                    gift.put(b, gift.getOrDefault(b, 0) + 1);
                } else {
                    int aGift = giveHm.getOrDefault(a, 0) - takeHm.getOrDefault(a, 0);
                    int bGift = giveHm.getOrDefault(b, 0) - takeHm.getOrDefault(b, 0);
                    if (aGift < bGift) {
                        gift.put(b, gift.getOrDefault(b, 0) + 1);
                    } else if (aGift > bGift) {
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
