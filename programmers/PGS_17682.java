package programmers;

/**
 * [1차] 다트 게임
 * https://school.programmers.co.kr/learn/courses/30/lessons/17682
 */
public class PGS_17682 {
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
        System.out.println(solution("1D2S3T*"));
    }

    /**
     * 3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력
     * 
     * @param dartResult 점수|보너스|[옵션]
     * @return
     */
    public static int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        int index = 0;
        int number = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char x = dartResult.charAt(i);
            if (Character.isDigit(x)) {
                if (x == '1' && dartResult.charAt(i + 1) == '0') {
                    number = 10;
                    i++;
                } else {
                    number = Character.getNumericValue(x);
                }
            } else {
                if (x == 'S') {
                    score[index++] = (int) Math.pow(number, 1);
                } else if (x == 'D') {
                    score[index++] = (int) Math.pow(number, 2);
                } else if (x == 'T') {
                    score[index++] = (int) Math.pow(number, 3);
                } else if (x == '*') {
                    int j = (index - 2) < 0 ? 0 : index - 2;
                    for (; j < index; j++) {
                        score[j] *= 2;
                    }
                } else if (x == '#') {
                    score[index - 1] *= -1;
                }
            }
        }

        for (int s : score) {
            answer += s;
        }

        return answer;
    }
}
