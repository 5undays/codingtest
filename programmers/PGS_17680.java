package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [1차] 캐시
 * https://school.programmers.co.kr/learn/courses/30/lessons/17680
 */
public class PGS_17680 {
    public static void main(String[] args) {
        // int answer = solution(3,
        // new String[] { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju",
        // "Pangyo", "Seoul" });
        int answer = solution(0,
                new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA" });
        // int answer = solution(2,
        // new String[] { "Jeju", "Pangyo", "NewYork", "newyork" });
        System.out.println(answer);
    }

    /**
     * 총 실행시간
     * 
     * @param cacheSize 캐시크기 (0~30)
     * @param cities    도시이름 (최대 100,000개)
     * @return 실행시간
     */
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        if (cacheSize == 0)
            return cities.length * 5;
        for (String city : cities) {
            city = city.toLowerCase();
            if (q.contains(city)) { // cache hit
                q.remove(city);
                q.add(city);
                answer++;
            } else { // cache miss
                if (q.size() == cacheSize) {
                    q.remove();
                }
                q.offer(city);
                answer += 5;
            }
        }
        return answer;
    }
}
