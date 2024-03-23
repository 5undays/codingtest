package programmers;

import java.util.HashMap;

public class PGS_178871 {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"mumu", "soe", "poe", "kai", "mine"},
                new String[] {"kai", "kai", "mine", "mine"}));
    }

    public static String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0 ; i < players.length; i++) {
            hm.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            int rank = hm.get(callings[i]);

            hm.replace(players[rank - 1], rank);
            players[rank] = players[rank - 1];

            hm.replace(callings[i], rank - 1);
            players[rank - 1] = callings[i];
        }

        return players;
    }
}
