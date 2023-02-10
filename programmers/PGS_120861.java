package programmers;

/**
 * 캐릭터의 좌표
 * https://school.programmers.co.kr/learn/courses/30/lessons/120861
 */
public class PGS_120861 {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(solution(new String[]{"left", "right", "up", "right", "right"}, new int[]{11, 11})));
        //System.out.println(Arrays.toString(solution(new String[]{"down", "down", "down", "down", "down"}, new int[]{7, 9})));

    }

    public static int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int midWidth = board[0] / 2;
        int midHeight = board[1] / 2;
        for (int i = 0; i < keyinput.length; i++) {
            if (keyinput[i].equals("left")) {
                if (answer[0] <= -midWidth) {
                    continue;
                }
                answer[0]--;
            } else if (keyinput[i].equals("right")) {
                if (answer[0] < midWidth) {
                    answer[0]++;
                }
            } else if (keyinput[i].equals("up")) {
                if (answer[1] < midHeight) {
                    answer[1]++;
                }
            } else if (keyinput[i].equals("down")) {
                if (answer[1] <= -midHeight) {
                    continue;
                }
                answer[1]--;
            }
        }
        return answer;
    }
}
