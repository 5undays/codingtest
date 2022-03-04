package programmers;

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
        int answer = 0;
        HashSet<String> methods = new HashSet<>();
        for (int i = 0; i < clothes.length; i++) {
            String name = clothes[i][0];
            String method = clothes[i][1];
            if (!methods.contains(method)) {
                 methods.add(method);
            }
            //cl.put(method + "," +name, name);
        }

        //answer = clothes.length + (methods.size() * );
        return answer;
    }

    // private int solution(String[][] clothes) {
    //     int answer = 0;
    //     HashSet<String> methods = new HashSet<>();
    //     HashMap<String, String> cl = new HashMap<>();
    //     for (int i = 0; i < clothes.length; i++) {
    //         String name = clothes[i][0];
    //         String method = clothes[i][1];
    //         if (!methods.contains(method)) {
    //              methods.add(method);
    //         }
    //         cl.put(method + "," +name, name);
    //     }

    //     HashSet<String> resultSet = new HashSet<>();
    //     for (int i = 0; i < cl.size(); i++) {
    //         String[] a = cl.get(i).split(",");
    //         for (int j = 0 ; j < methods.size(); j ++ ) {
    //             if (methods.equals(a[0])) {
    //                 resultSet.add(a[0] +"," + a[1]);
    //             }
    //         }
    //     }
    //     return answer;
    // }
}
