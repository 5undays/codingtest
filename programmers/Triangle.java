package programmers;

/**
 * 정수 삼각형
 * https://programmers.co.kr/learn/courses/30/lessons/43105
 */
public class Triangle {

    public static void main(String args[]) {
        Triangle triangle = new Triangle();
        int answer = triangle.solution1(new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } });
        System.out.println(answer);
    }

    /**
     * 
     * @param triangle
     * @return
     */
    public int solution(int[][] triangle) {
        int answer = 0;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    triangle[i][j] = triangle[i][j] + triangle[i - 1][j];
                } else if (i == j) {
                    triangle[i][j] = triangle[i][j] + triangle[i - 1][j - 1];
                } else {
                    int left = triangle[i][j] + triangle[i - 1][j - 1];
                    int right = triangle[i][j] + triangle[i - 1][j];
                    triangle[i][j] = Math.max(left, right);
                }
                answer = Math.max(answer, triangle[i][j]);
            }
        }
        return answer;
    }

    /**
     * 
     * @param triangle
     * @return
     */
    public int solution1(int[][] triangle) {
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                int left = triangle[i][j] + triangle[i + 1][j];
                int right = triangle[i][j] + triangle[i + 1][j + 1];
                triangle[i][j] = Math.max(left, right);
            }
        }
        return triangle[0][0];
    }
}
