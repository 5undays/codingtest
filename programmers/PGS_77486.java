package programmers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 다단계 칫솔 판매
 * https://school.programmers.co.kr/learn/courses/30/lessons/77486
 */
public class PGS_77486 {
    public static void main(String[] args) {
        // solution(new String[] { "john", "mary", "edward", "sam", "emily", "jaimie",
        // "tod", "young" },
        // new String[] { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"
        // },
        // new String[] { "young", "john", "tod", "emily", "mary" }, new int[] { 12, 4,
        // 2, 5, 10 });

        // solution(new String[] { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" },
        //         new String[] { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" },
        //         new String[] { "sam", "emily", "jaimie", "edward" }, new int[] { 2, 3, 5, 4 });

        solution(new String[] { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" },
                new String[] { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" },
                new String[] { "sam", "sam",  }, new int[] { 2, 3});
    }

    /**
     * 판매원에게 배분된 이익금의 총합
     * 
     * @param enroll   판매원의 이름을 담은 배열
     * @param referral 판매원을 다단계 조직에 참여시킨 다른 판매원의 이름을 담은 배열
     * @param seller   판매량 집계 데이터의 판매원 이름을 나열한 배열
     * @param amount   판매량 집계 데이터의 판매 수량을 나열한 배열
     * @return
     */
    public static ArrayList<Integer> solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>();
        HashMap<String, Integer> record = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            hm.put(enroll[i], referral[i]);
            record.put(enroll[i], 0);
        }

        for (int i = 0; i < seller.length; i++) {
            int money = amount[i] * 100;
            String person = seller[i];
            while (money > 0) {
                int myMoney = (int) Math.ceil(money * 0.9);
                record.put(person, record.get(person) + myMoney);
                person = hm.get(person);
                if (person.equals("-")) {
                    break;
                }
                money = money - myMoney;
            }
        }

        for (int i = 0; i < enroll.length; i++) {
            answer.add(record.get(enroll[i]));
        }

        return answer;
    }
}
