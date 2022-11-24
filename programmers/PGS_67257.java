package programmers;

import java.util.*;

/**
 * 수식 최대화
 * https://school.programmers.co.kr/learn/courses/30/lessons/67257
 */
public class PGS_67257 {
    public static void main(String[] args) {
        System.out.println(solution("1-2+3"));
        //System.out.println(solution("100-200*300-500+20"));
        //System.out.println(solution("50*6-3*2"));
    }

    static ArrayList<String> arr = new ArrayList<>();
    static boolean[] check = new boolean[3];
    static String[] oper = {"+", "-", "*"};
    static long answer = 0;

    public static long solution(String expression) {
        int index = 0;
        for (int i = 0; i < expression.length() - 1; i++) {
            char c = expression.charAt(i);
            if (!Character.isDigit(c)) {
                arr.add(expression.substring(index, i));
                arr.add(c + "");
                index = i + 1;
            }
        }
        arr.add(expression.substring(index));

        dfs(3, 0, new ArrayList<>());
        return answer;
    }

    private static void dfs(int n, int depth, ArrayList<String> order) {
        if (depth == n) {
            operation(order);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!check[i]) {
                check[i] = true;
                ArrayList<String> arr = (ArrayList<String>) order.clone();
                arr.add(oper[i]);
                dfs(n, depth + 1, arr);
                check[i] = false;
            }
        }
    }

    private static void operation(ArrayList<String> order) {
        ArrayList<String> arr2 = (ArrayList<String>) arr.clone();
        for (int j = 0; j < order.size(); j++) {
            String o = order.get(j);
            while(arr2.contains(o)) {
                int i = arr2.indexOf(o);
                long a = Long.parseLong(arr2.get(i - 1));
                long b = Long.parseLong(arr2.get(i + 1));
                String operation = arr2.get(i);
                arr2.remove(i - 1);
                arr2.remove(i - 1);
                arr2.remove(i - 1);
                long result = calc(a, b, operation);
                arr2.add(i - 1, String.valueOf(result));
            }
        }
        answer = Math.max(answer, Math.abs(Long.parseLong(arr2.get(0))));
    }

    private static long calc(long a, long b, String oper) {
        if (Objects.equals(oper, "*")) {
            return a * b;
        } else if (Objects.equals(oper, "-")) {
            return a - b;
        } else {
            return a + b;
        }
    }
}
