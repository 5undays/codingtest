package programmers;

/**
 * 비밀지도
 * https://school.programmers.co.kr/learn/courses/30/lessons/17681?language=java
 */
public class PGS_17681 {

    public static void main(String[] args) {
        // System.out.println(solution(5, new int[] { 9, 20, 28, 18, 11 }, new int[] {
        // 30, 1, 21, 17, 28 }).toString());
        System.out.println(
                solution(6, new int[] { 46, 33, 33, 22, 31, 50 }, new int[] { 27, 56, 19, 14, 14, 10 }).toString());

    }

    /**
     * 암호해독
     * 
     * @param n    지도 한변의 크기
     * @param arr1 정수 배열
     * @param arr2 정수 배열
     * @return 원래의 비밀지도
     */
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String s = Integer.toBinaryString(arr1[i] | arr2[i]);
            s = String.format("%" + n + "s", s).replaceAll("1", "#").replaceAll("0", " ");
            answer[i] = s;
        }
        return answer;
    }
}
