package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12979
public class BaseStation {
    public static void main(String args[]) {
        BaseStation baseStation = new BaseStation();
        System.out.println(baseStation.solution(11, new int[] { 4, 11 }, 1));
        System.out.println(baseStation.solution(16, new int[] { 9 }, 2));
    }

    /**
     * 증설 기지국 개수
     * 
     * @param n       아파트의 개수
     * @param station 현재 기지국이 설치된 아파트의 번호가 담긴 배열
     * @param w       전파의 도달 거리
     * @return 모든 아파트에 전파를 전달하기 위해 증설해야 할 기지국의 개수
     */
    private int solution(int n, int[] station, int w) {
        int answer = 0;

        // 1번째 기지국 전까지 증설 기지국 개수
        if (station[0] - 1 - w >= 1) {
            answer += addStation(0, station[0] - 1 - w, w);
        }

        // 2번째 기지국 부터 마지막 기지국 까지 증설 기지국 개수
        for (int i = 1; i < station.length; i++) {
            answer += addStation(station[i - 1] + 1 + w, station[i] - w - 1, w);
        }

        // 마지막 기지국에서 마지막 아파트 까지 증설 기지국 개수
        if (station[station.length - 1] + w + 1 <= n) {
            answer += addStation(station[station.length - 1] + w + 1, n, w);
        }
        return answer;
    }

    private int addStation(int startIdx, int endIdx, int w) {
        int addCnt = 0;
        int range = (w * 2) + 1;
        int emptyLength = endIdx - startIdx + 1;
        while (addCnt * range < emptyLength) {
            addCnt++;
        }
        return addCnt;
    }

    // 다른 풀이
    private int solution2(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1;
        // Queue<Integer> station = new LinkedList<>();
        // for (int s: station) { station.add(s); }
        int station = 0;
        while (position <= n) {
            if (stations[station] - w <= position) {
                position += stations[station] + w + 1;
                station++;
            } else {
                answer++;
                position += w * 2 + 1;
            }
        }
        return answer;
    }
}
