package programmers;

/**
 * 단어 변환
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 */
public class PGS_43163 {
    public static void main(String[] args) {
        PGS_43163 pgs_43163 = new PGS_43163();
        System.out.println(pgs_43163.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(pgs_43163.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    int answer = 51;
    boolean[] check;

    /**
     * begin에서 target으로 변환하는 가장 짧은 변환 과정
     *
     * @param begin
     * @param target
     * @param words
     * @return
     */
    public int solution(String begin, String target, String[] words) {
        check = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer == 51 ? 0 : answer;
    }

    private void dfs(String begin, String target, String[] words, int depth) {
        if (begin.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (check[i]) continue;
            String word = words[i];
            int diff = 0;

            for (int j = 0; j < word.length(); j++) {
                if (begin.charAt(j) != word.charAt(j)) {
                    diff++;
                }
            }

            if (diff == 1) {
                check[i] = true;
                dfs(word, target, words, depth + 1);
                check[i] = false;
            }
        }
    }
}
