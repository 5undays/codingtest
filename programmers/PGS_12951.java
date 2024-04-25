package programmers;


public class PGS_12951 {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        //System.out.println(solution("AAAAA"));
    }

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == ' ') {
                first = true;
                answer.append(" ");
            } else {
                if (first) {
                    answer.append(c.toString().toUpperCase());
                } else {
                    answer.append(c.toString().toLowerCase());
                }
                first = false;
            }
        }
        return answer.toString().trim();
    }
}
