package programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 주차 요금 계산
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 */
public class PGS_92341 {
    public static void main(String[] args) {
        // System.out.println(solution(new int[] { 180, 5000, 10, 600 },
        // new String[] { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59
        // 5961 OUT", "07:59 0148 IN",
        // "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" }));

        System.out.println(solution(new int[] { 120, 0, 60, 591 },
                new String[] { "16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT",
                        "23:58 3961 IN" }));
    }

    /**
     * 차량 번호가 작은 자동차부터 청구할 주차 요금 정수 배열
     * 
     * @param fees    주차 요금을 나타내는 정수 배열
     * @param records 자동차의 입/출차 내역을 나타내는 문자열 배열
     * @return
     */
    public static int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> parking = new HashMap<>();
        HashMap<String, Integer> record = new HashMap<>();

        for (String r : records) {
            String[] s = r.split(" ");
            int time = getMinute(s[0]);
            String car = s[1];

            if (!record.containsKey(car)) {
                record.put(car, 0);
            }

            if (parking.containsKey(car)) {
                record.put(car, record.get(car) + (time - parking.get(car)));
                parking.remove(car);
            } else {
                parking.put(car, time);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(record.entrySet());
        entryList.sort(Map.Entry.comparingByKey());

        int[] result = new int[record.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : entryList) {
            result[i] = fees[1]; // 기본요금
            int time = record.get(entry.getKey()) - fees[0];
            if (parking.containsKey(entry.getKey()))
                time += getMinute("23:59") - parking.get(entry.getKey());
            if (time > 0)
                result[i] += (Math.ceil(time / (fees[2] * 1.0)) * fees[3]);
            i++;
        }
        return result;
    }

    public static int getMinute(String value) {
        String[] t = value.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}
