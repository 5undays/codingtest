import java.util.*;

public class Programmers_even {
    
    public static void main(String[] args) {
        int result = solution("17");
        System.out.println("result :" + result);
    }

    public static int solution(String numbers) {
        int answer = 0;
        HashSet<String> hs = new HashSet<>();
        for (int i = 0;i<numbers.length();i++) {
            String num = numbers.charAt(i) + "";
            System.out.print("num :"+num);
            hs.put(num);
            String value = "";
            for (int j=numbers.length()-1;j>0;j--) {
                if (i != j) {
                    value += numbers.charAt(i) + "";
                }
            }
        }
        
        /*for (int i = 0;i<hs.size();i++) {
            if(valid(Integer.parseInt(hs.get(i)))) {
                answer++;
            }
        }*/
        return answer;
    }
    
    public boolean valid(int num) {
        int cnt = 0;
        for (int i =2;i<num;i++) {
            if (num%i) {
                cnt++;
            }
        }
        if (cnt == 1) {
            return false;
        } else {
            return true;
        }
    }
}