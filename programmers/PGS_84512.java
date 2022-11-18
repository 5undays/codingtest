package programmers;

/**
 * 모음사전
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */
public class PGS_84512 {
    public static void main(String[] args) {
        PGS_84512 pgs_84512 = new PGS_84512();
        //System.out.println(pgs_84512.solution("AAAAE"));
        //System.out.println(pgs_84512.solution("AAAE"));
        System.out.println(pgs_84512.solution("I"));
        //System.out.println(pgs_84512.solution("EIO"));
    }

    int answer = 0;
    int depth = 0;
    /**
     * 이 단어가 사전에서 몇 번째 단어
     *
     * @param word 단어 하나
     * @return
     */
    public int solution(String word) {
        answer = 0;
        dfs("", word);
        return answer;
    }

    private void dfs(String st, String word) {
        if (st.length() > 5) return;
        if (st.equals(word)) {
            answer = depth;
            return;
        }
        depth = depth + 1;
        dfs(st + "A", word);
        dfs(st + "E", word);
        dfs(st + "I", word);
        dfs(st + "O", word);
        dfs(st + "U", word);
    }
}
