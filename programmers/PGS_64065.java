package programmers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 튜플
 * https://school.programmers.co.kr/learn/courses/30/lessons/64065
 */
public class PGS_64065 {
    public static void main(String[] args) {
        //solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");

    }

    /**
     * s가 표현하는 튜플
     * 
     * @param s 특정 튜플을 표현하는 집합이 담긴 문자열
     * @return
     */
    public static ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        s = s.replace("{{", "").replace("}}", "");
        String[] str = s.split("\\},\\{");
        Arrays.sort(str, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        for (int i = 0; i < str.length; i++) {
            String[] data = str[i].split(",");
            for (int j = 0; j < data.length; j++) {
                int num = Integer.parseInt(data[j]);
                if (!answer.contains(num)) {
                    answer.add(num);
                }
            }
        }
        return answer;
    }
}
