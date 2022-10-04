package programmers;

import java.util.Stack;

/**
 * 크레인 인형뽑기 게임
 * https://school.programmers.co.kr/learn/courses/30/lessons/64061
 */
public class PGS_64061 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 },
                { 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } }, new int[] { 1, 5, 3, 5, 1, 2, 1, 4 }));
    }

    /**
     * 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수
     * 
     * @param board 게임 화면의 격자의 상태가 담긴 2차원 배열
     * @param moves 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열
     * @return
     */
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();
        for (int move : moves) {
            int k = move - 1;
            for (int i = 0; i < board.length; i++) {
                if (board[i][k] > 0) {
                    if (!bucket.isEmpty() && bucket.peek() == board[i][k]) {
                        bucket.pop();
                        answer += 2;
                    } else {
                        bucket.push(board[i][k]);
                    }
                    board[i][k] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
