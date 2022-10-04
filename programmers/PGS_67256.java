package programmers;

/**
 * 키패드 누르기
 * https://school.programmers.co.kr/learn/courses/30/lessons/67256
 */
public class PGS_67256 {
    public static void main(String[] args) {
        //System.out.println(solution(new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, "right"));
        //System.out.println(solution(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }

    /**
     * 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열
     * 
     * @param numbers 순서대로 누를 번호가 담긴 배열
     * @param hand    왼손잡이인지 오른손잡이인 지를 나타내는 문자열
     * @return
     */
    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left = 10;
        int right = 12;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number % 3 == 0 && number > 0) { // 3, 6, 9 R
                right = number;
                answer.append("R");
            } else if (number % 3 == 1) { // 1, 4, 7 L
                left = number;
                answer.append("L");
            } else { // 2, 5, 8, 0
                int leftLen = getLength(left, number);
                int rightLen = getLength(right, number);
                if (leftLen > rightLen) {
                    answer.append("R");
                    right = number;
                } else if (leftLen < rightLen) {
                    answer.append("L");
                    left = number;
                } else {
                    if (hand.equals("right")) {
                        answer.append("R");
                        right = number;
                    } else {
                        answer.append("L");
                        left = number;
                    }
                }
            }
        }
        return answer.toString();
    }

    /**
     * target 과 현재 손의 거리 구하기
     * @param current 손 위치
     * @param target 목표 숫자
     * @return
     */
    public static int getLength(int current, int target) {
        current = (current == 0) ? 11 : current;
        target = (target == 0) ? 11 : target;

        int x = (current - 1) / 3;
        int y = (current - 1) % 3;
        int targetX = target / 3;
        int targetY = 1;

        return Math.abs(x - targetX) + Math.abs(y - targetY);
    }
}
