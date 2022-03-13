package programmers;

public class CodingTest {
    public static void main(String args[]) {
        CodingTest codingTest = new CodingTest();
        int[][] answer = codingTest.solution(3, 4, 2,
                new int[][] { { 3, 2 }, { 3, 2 }, { 2, 2 }, { 3, 2 }, { 1, 4 }, { 3, 2 }, { 2, 3 }, { 3, 1 } });
        System.out.println(answer);
    }

    int[][] answer;
    int rows;
    int columns;

    /**
     * 
     * @param rows      배열의 행 길이
     * @param columns   배열의 열 길이
     * @param max_virus 최대 세균의 개수
     * @param queries   세균 증식 배열
     * @return
     */
    public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        answer = new int[rows][columns];
        this.rows = rows;
        this.columns = columns;
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int virus_x = query[0] - 1;
            int virus_y = query[1] - 1;
            if (answer[virus_x][virus_y] == max_virus) {
                    addMaxVirus(virus_x - 1, virus_y, max_virus);
                    addMaxVirus(virus_x, virus_y - 1, max_virus);
                    addMaxVirus(virus_x + 1, virus_y, max_virus);
                    addMaxVirus(virus_x, virus_y + 1, max_virus);
            } else {
                answer[virus_x][virus_y]++;
            }
        }
        return answer;
    }

    private void test(int x, int y, int max_virus) {
        if (x > 0 && y > 0 && x < rows && y < columns) {
            if (answer[x][y] < max_virus) {
                answer[x][y]++;
            }
        }
    }
    private void addMaxVirus(int x, int y, int max_virus) {
        if (x > 0 && y > 0 && x < rows && y < columns) {
            if (answer[x][y] < max_virus) {
                answer[x][y]++;
            } else if (answer[x][y] == max_virus){
                test(x - 1, y, max_virus);
                test(x, y - 1, max_virus);
                test(x + 1, y, max_virus);
                test(x, y + 1, max_virus);
            }
        }
    }
}
