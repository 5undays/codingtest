package programmers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 실패율
 * https://school.programmers.co.kr/learn/courses/30/lessons/42889
 */
public class PGS_42889 {
    public static void main(String[] args) {
        //System.out.println(solution(5, new int[] { 2, 1, 2, 6, 2, 4, 3, 3 }));
        //System.out.println(solution(4, new int[] { 4,4,4,4,4}));
        System.out.println(solution(5, new int[] { 3,3,3,3}));
    }

    /**
     * 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열
     * 
     * @param N      전체 스테이지의 개수
     * @param stages 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열
     * @return
     */
    public static int[] solution(int N, int[] stages) {
        ArrayList<Game> game = new ArrayList<>();
        int[] answer = new int[N];
        int[] failureCnt = new int[N + 1]; // 아직 클리어하지 못한 플레이어의 수
        int[] reached = new int[N + 1]; // 스테이지에 도달한 플레이어 수
        for (int i = 0; i < stages.length; i++) {
            failureCnt[stages[i] - 1]++;
            for (int j = 0; j < stages[i]; j++) {
                reached[j]++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (reached[i] == 0) {
                game.add(new Game(i, 0));
            } else {
                game.add(new Game(i, (double) failureCnt[i] / (double) reached[i]));
            }
        }

        Collections.sort(game);

        for (int i = 0; i < game.size(); i++) {
            answer[i] = game.get(i).stage + 1;
        }
        return answer;
    }

    static class Game implements Comparable<Game> {
        int stage;
        double failurePercent;

        Game(int stage, double failurePercent) {
            this.stage = stage;
            this.failurePercent = failurePercent;
        }

        @Override
        public int compareTo(Game o) {
            if (this.failurePercent - o.failurePercent > 0) {
                return -1;
            } else if (this.failurePercent - o.failurePercent == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
