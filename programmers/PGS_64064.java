package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;

/**
 * 불량 사용자
 * https://school.programmers.co.kr/learn/courses/30/lessons/64064
 */
public class PGS_64064 {
    public static void main(String[] args) {
        System.out.println(solution(new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" },
                new String[] { "fr*d*", "abc1**" }));
    }

    static ArrayList<ArrayList<String>> arr;
    static HashSet<HashSet<String>> answer;

    /**
     * 당첨에서 제외되어야 할 제재 아이디 목록은 몇가지 경우의 수
     * 
     * @param user_id   전체 사용자 아이디
     * @param banned_id 불량 사용자 아이디
     * @return
     */
    public static int solution(String[] user_id, String[] banned_id) {
        arr = new ArrayList<>();
        answer = new HashSet<>();

        for (String ban : banned_id) {
            ArrayList<String> temp = new ArrayList<>();
            for (String user : user_id) {
                if (user.length() != ban.length()) {
                    continue;
                } else if (Pattern.matches(ban.replace('*', '.'), user)) {
                    temp.add(user);
                }
            }
            arr.add(temp);
        }

        dfs(new HashSet<String>(), 0);
        return answer.size();
    }

    private static void dfs(HashSet<String> s, int depth) {
        if (depth == arr.size()) {
            answer.add(new HashSet<>(s));
            return;
        }

        for (String user : arr.get(depth)) {
            if (s.add(user)) {
                dfs(s, depth + 1);
                s.remove(user);
            }
        }
    }

}
