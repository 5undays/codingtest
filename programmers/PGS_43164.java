package programmers;

import java.sql.Array;
import java.util.*;
import java.util.stream.IntStream;

/**
 * 여행경로
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 */
public class PGS_43164 {
    public static void main(String[] args) {
        PGS_43164 pgs_43164 = new PGS_43164();
        //ArrayList<String> answer = pgs_43164.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        String[] answer2 = pgs_43164.solution2(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
        //System.out.println(answer);
        System.out.println(answer2);
        String[] answer3 = pgs_43164.solution2(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
    }

    boolean[] check;
    ArrayList<String> answer = new ArrayList<>();

    /**
     * 방문하는 공항 경로
     *
     * @param tickets 항공권 정보가 담긴 2차원 배열
     * @return
     */
    public String[] solution(String[][] tickets) {
        check = new boolean[tickets.length];
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(answer);
        return answer.get(0).split(" ");
    }

    private void dfs(String next, String visit, String[][] tickets, int depth) {
        if (tickets.length == depth) {
            answer.add(visit);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(next) && !check[i]) {
                check[i] = true;
                dfs(tickets[i][1], visit + " " + tickets[i][1], tickets, depth + 1);
                check[i] = false;
            }
        }
    }

    /**
     * 방문하는 공항 경로 2
     * @param tickets
     * @return
     */
    public String[] solution2(String[][] tickets) {
        ArrayList<String> answer = new ArrayList<>();
        Queue<Ticket> q = new LinkedList<>();
        q.add(new Ticket("ICN", "ICN", new boolean[tickets.length]));
        while (!q.isEmpty()) {
            Ticket t = q.poll();
            long c = IntStream.range(0, t.count.length).mapToObj(idx -> t.count[idx]).filter(x -> x == true).count();
            if (c == tickets.length) {
                answer.add(t.visited);
                continue;
            }
            for (int j = 0; j < tickets.length; j++) {
                boolean[] count = t.count.clone();
                if (t.current.equals(tickets[j][0]) && !count[j]) {
                    count[j] = true;
                    q.add(new Ticket(tickets[j][1], t.visited + " " + tickets[j][1], count));
                }
            }
        }
        Collections.sort(answer);
        return answer.get(0).split(" ");
    }

    class Ticket {
        String current;
        String visited;
        boolean[] count;

        Ticket(String current, String visited, boolean[] count) {
            this.current = current;
            this.visited = visited;
            this.count = count;
        }
    }
}
