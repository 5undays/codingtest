package programmers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 오픈채팅방
 * https://school.programmers.co.kr/learn/courses/30/lessons/42888
 */
public class PGS_42888 {
    public static void main(String[] args) {
        solution(new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan" });
    }

    /**
     * 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열
     * @param record 채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열
     * @return
     */
    public static ArrayList<String> solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            String[] dialog = record[i].split(" ");
            if (dialog[0].equals("Enter")) {
                hm.put(dialog[1], dialog[2]);

            } else if (dialog[0].equals("Change")) {
                hm.put(dialog[1], dialog[2]);
            }
        }

        for (int i = 0; i < record.length; i++) {
            String[] dialog = record[i].split(" ");
            if (dialog[0].equals("Enter")) {
                answer.add(hm.get(dialog[1]) + "님이 들어왔습니다.");

            } else if (dialog[0].equals("Leave")) {
                answer.add(hm.get(dialog[1]) + "님이 나갔습니다.");

            }
        }
        return answer;
    }
}
