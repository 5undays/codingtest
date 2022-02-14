package programmers;
import java.util.*;

public class Programmers_even {
    public static int answer = 0;
    static ArrayList<Integer> arr = new ArrayList<>();
    static boolean[] check = new boolean[7];
    public static void main(String[] args) {
        int result = solution("17");
        System.out.println("result :" + result);
    }

    public static int solution(String numbers) {
        String temp = "";
        for (int i = 1;i <=numbers.length();i++) {
            combination(numbers, temp, i);
        }
        for (int n:arr) valid(n);
        return answer;
    }
    
    public static void valid(int num) {
        if (num == 0 || num == 1) return;

        for (int i =2;i<Math.sqrt(num);i++) {
            if (num%i == 0) return;
        }
        answer++;
    }

    public static void combination(String n,String temp, int len) {
        if (temp.length() == len) {
            if (!arr.contains(Integer.parseInt(temp))) {
                arr.add(Integer.parseInt(temp));
            }
        }
        for (int i = 0; i <n.length();i++) {
            if (check[i]) continue;
            temp += n.charAt(i);
            check[i] = true;
            combination(n,temp,len);
            check[i] = false;
            temp = temp.substring(0, temp.length()-1);
        }
    }
}