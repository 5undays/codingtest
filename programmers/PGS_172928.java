package programmers;

/**
 * 공원 산책
 * https://school.programmers.co.kr/learn/courses/30/lessons/172928
 */
public class PGS_172928 {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"SOO","OOO","OOO"}, new String[] {"E 2","S 2","W 1"}));
    }

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int x = 0, y = 0;
        char[][] map = new char[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                map[i][j] = park[i].charAt(j);
                if (map[i][j] == 'S') {
                    x = i; y = j;
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String[] s = routes[i].split(" ");

            if (s[0].equals("S")) {
                y -= Integer.parseInt(s[1]);
                if (y < 0) y = 0;
            } else if (s[0].equals("E")) {
                x += Integer.parseInt(s[1]);
                if (x < 0) x = 0;
            } else if (s[0].equals("W")) {
                x -= Integer.parseInt(s[1]);
                if (x < 0) x = 0;
            } else if (s[0].equals("N")) {
                y += Integer.parseInt(s[1]);
            }

            //if (x >= 0)
        }

        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}
