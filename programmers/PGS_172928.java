package programmers;

/**
 * 공원 산책
 * https://school.programmers.co.kr/learn/courses/30/lessons/172928
 */
public class PGS_172928 {
    public static void main(String[] args) {

    }

    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int[][] map = new int[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                map[i][j] = park[i].charAt(j);
            }
        }


        return answer;
    }
}
