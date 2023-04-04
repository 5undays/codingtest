package programmers;

/**
 * 안전지대
 * https://school.programmers.co.kr/learn/courses/30/lessons/120866
 */
public class PGS_120866 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}}));
    }

    static int[] dx = {0, 0, -1, -1, -1, 1, 1, 1, 0};
    static int[] dy = {-1, 1, 0, -1, 1, 0, -1, 1, 0};

    public static int solution(int[][] board) {
        int answer = 0;
        int[][] map = new int[board[0].length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < dx.length; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < board[i].length && ny < board.length) {
                            map[nx][ny] = 1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
