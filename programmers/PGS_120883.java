package programmers;

/**
 * 로그인 성공?
 * https://school.programmers.co.kr/learn/courses/30/lessons/120883
 */
public class PGS_120883 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"meosseugi", "1234"}, new String[][]{{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}}));
        System.out.println(solution(new String[]{"meosseugi", "1234"}, new String[][]{{"rardss", "123"}, {"meosseugi", "1234"}, {"yyoom", "1234"}}));
        System.out.println(solution(new String[]{"programmer01", "15789"}, new String[][]{{"programmer02", "111111"}, {"programmer00", "134"}, {"programmer01", "1145"}}));
        System.out.println(solution(new String[]{"rabbit04", "98761"}, new String[][]{{"jaja11", "98761"}, {"krong0313", "29440"}, {"rabbit00", "111333"}}));

    }

    public static String solution(String[] id_pw, String[][] db) {
        String answer = "";
        for (int i = 0; i < db.length; i++) {
            String[] user = db[i];
            if (id_pw[0].equals(user[0]) && id_pw[1].equals(user[1])) {
                answer = "login";
                break;
            } else if (id_pw[0].equals(user[0])) {
                answer = "wrong pw";
                break;
            } else {
                answer = "fail";
            }
        }
        return answer;
    }
}
