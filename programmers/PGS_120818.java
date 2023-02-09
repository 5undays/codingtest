package programmers;

/**
 * 옷가게 할인 받기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120818
 */
public class PGS_120818 {
    public static void main(String[] args) {
        System.out.println(solution(150000));
    }

    public static int solution(int price) {
        int answer = 0;
        if (price >= 500000) {
            answer = (int) Math.floor(price * 0.8);
        } else if (price >= 300000) {
            answer = (int)  Math.floor(price * 0.9);
        } else if (price >= 100000) {
            answer = (int)  Math.floor(price * 0.95);
        } else {
            answer = price;
        }
        return answer;
    }
}
