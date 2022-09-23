package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * [1차] 프렌즈4블록
 * https://school.programmers.co.kr/learn/courses/30/lessons/17679
 */
public class PGS_17679 {
    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[] { "CCBDE", "AAADE", "AAABF", "CCBBF" }));
    }

    static char[][] map;
    static int N;
    static int M;

    /**
     * 몇 개의 블록이 지워질지 출력
     * 
     * @param m     판의 높이
     * @param n     폭
     * @param board 판의 배치 정보
     * @return
     */
    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        N = n;
        M = m;
        
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            int cnt = checkBlock();
            if (cnt > 0) {
                answer += cnt;
            } else {
                break;
            }
        }

        return answer;

    }
    
    /**
     * 4개 씩 모여 있는 블록인지 체크
     * @param m 폭
     * @param n 높이
     * @return
     */
    static int checkBlock() {
        boolean[][] chk = new boolean[M][N];

        for (int i = 0; i < M - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                char c = map[i][j];
                // c가 블록이 내려 가서 없는 경우에는 다음 문자로 넘어간다
                if (c == '0') {
                    continue;
                }
                // 2 * 2 의 범위가 현재의 index 문자와 같은 경우 체크
                if (c == map[i + 1][j + 1] && c == map[i][j + 1] && c == map[i + 1][j]) {
                    chk[i][j] = true;
                    chk[i + 1][j + 1] = true;
                    chk[i][j + 1] = true;
                    chk[i + 1][j] = true;
                }
            }
        }
        return fallblock(chk);
    }

    /**
     * 블록 떨어뜨리고 떨어뜨린 블록 맞추기
     * @param n 높이
     * @param m 폭
     * @param chk
     * @return
     */
    static int fallblock(boolean[][] chk) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            List<Character> temp = new ArrayList<>(); // 새로 갱신될 열
            for (int j = M - 1; j >= 0; j--) { // 가장 마지막 행부터 탐색한다
                if (chk[j][i] == true) {
                    cnt++;
                    continue;
                }
                temp.add(map[j][i]);
            }

            for (int j = M - 1, k = 0; j >= 0; j--, k++) {
                /**
                 * k : 현재의 행
                 * temp.size() : 블록이 떨어져 생긴 열의 리스트 개수
                 * 문자를 맵에 갱신 해준다
                 */
                if (k < temp.size())
                    map[j][i] = temp.get(k);
                else 
                    map[j][i] = '0'; // 떨어져서 문자가 없다
            }
        }
        return cnt;
    }
}
