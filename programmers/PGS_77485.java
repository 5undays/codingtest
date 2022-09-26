package programmers;

/**
 * 행렬 테두리 회전하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/77485
 */
public class PGS_77485 {
    public static void main(String[] args) {
        System.out.println(solution(6, 6, new int[][] { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } }));
    }

    /**
     * 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열
     * 
     * @param rows    행렬의 세로 길이
     * @param columns 가로 길이
     * @param queries 회전들의 목록
     * @return
     */
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int number = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = number++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            int temp = map[x1][y1];
            int minNumber = temp;
            for (int j = x1 + 1; j <= x2; j++) {
                minNumber = Math.min(minNumber, map[j][y1]);
                map[j - 1][y1] = map[j][y1];
            }
            for (int j = y1 + 1; j <= y2; j++) {
                minNumber = Math.min(minNumber, map[x2][j]);
                map[x2][j - 1] = map[x2][j];
            }
            for (int j = x2 - 1; j >= x1; j--) {
                minNumber = Math.min(minNumber, map[j][y2]);
                map[j + 1][y2] = map[j][y2];
            }
            for (int j = y2 - 1; j > y1; j--) {
                minNumber = Math.min(minNumber, map[x1][j]);
                map[x1][j + 1] = map[x1][j];
            }
            map[x1][y1 + 1] = temp;
            answer[i] = minNumber;
        }
        return answer;
    }

    
}
