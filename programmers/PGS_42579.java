package programmers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 베스트앨범
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 */
public class PGS_42579 {
    public static void main(String[] args) {
        //System.out.println(solution(new String[]{"classic", "pop", "classic", "classic"}, new int[]{500, 600, 150, 800, 2500}));
        System.out.println(solution(new String[]{"classic", "pop", "classic", "classic", "pop", "zazz", "zazz"},
                new int[]{500, 600, 150, 800, 2500, 2000, 6000}));

    }

    /**
     * 베스트 앨범에 들어갈 노래의 고유 번호
     *
     * @param genres 노래의 장르를 나타내는 문자열 배열
     * @param plays  노래별 재생 횟수를 나타내는 정수 배열
     * @return
     */
    public static ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, ArrayList<Music>> hm = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            hm2.put(genres[i], hm2.getOrDefault(genres[i], 0) + plays[i]);
        }


        hm2 = hm2.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Integer> entry : hm2.entrySet()) {
            hm.put(entry.getKey(), new ArrayList<>());
        }

        for (int i = 0; i < genres.length; i++) {
            Music music = new Music(i, plays[i]);
            ArrayList<Music> list = hm.get(genres[i]);
            list.add(music);
            hm.put(genres[i], list);
        }

        for (Map.Entry<String, ArrayList<Music>> entry : hm.entrySet()) {
            Collections.sort(entry.getValue());
        }


        for (Map.Entry<String, Integer> entry : hm2.entrySet()) {
            ArrayList<Music> m = hm.get(entry.getKey());
            for (int i = 0; i < m.size() && i < 2; i++) {
                answer.add(m.get(i).idx);
            }
        }
        return answer;
    }


    static class Music implements Comparable<Music> {
        int idx;
        int plays;

        Music(int idx, int plays) {
            this.idx = idx;
            this.plays = plays;
        }

        @Override
        public int compareTo(Music o) {
            return o.plays - this.plays;
        }
    }
}
