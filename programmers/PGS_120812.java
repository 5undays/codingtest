package programmers;

/**
 * 최빈값 구하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120812
 */
public class PGS_120812 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 2, 2, 3, 3, 3}));
    }

    public static int solution(int[] array) {
        if (array.length > 2) {
            int length = 0;
            // 가장 큰 숫자를 고른다
            for (int i = 0; i < array.length; i++) {
                length = Math.max(length, array[i]);
            }
            // 가장 큰 숫자가 들어간 VALUE의 INDEX가 최빈값이다.
            int[] arr = new int[length + 1];
            for (int i = 0; i < array.length; i++) {
                arr[array[i]]++;
            }
            int maxCnt = 0;
            int index = 0;
            boolean flag = true;
            // 해당 배열 중 가장 큰 값이 들어있는 인덱스가 답이 된다
            for (int i = 0; i <= length; i++) {
                if (maxCnt < arr[i]) {
                    maxCnt = arr[i];
                    index = i;
                    flag = true;
                } else if (maxCnt == arr[i]) {
                    flag = false;
                }
            }
            if (flag) {
                return index;
            } else {
                return -1;
            }
        } else {
            return array[0];
        }
    }
}