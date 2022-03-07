package programmers;

import java.util.HashMap;
import java.util.HashSet;

public class Camouflage {

    public static void main(String[] args) {
        Camouflage camouflage = new Camouflage();
        int answer1 = camouflage.solution(new String[][] { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
                { "green_turban", "headgear" } });
        int answer2 = camouflage.solution(
                new String[][] { { "crowmask", "face" }, { "bluesunglasses", "face" }, { "smoky_makeup", "face" } });
        System.out.println(answer1);
        System.out.println(answer2);
    }

    private int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> methods = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String method = clothes[i][1];
            methods.put(method, methods.getOrDefault(method, 0) + 1);
        }

        for (String method : methods.keySet()) {
            answer *= methods.get(method) + 1;
        }
        return answer - 1;
    }

}
