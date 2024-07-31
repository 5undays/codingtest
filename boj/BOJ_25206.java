package boj;

import java.util.Scanner;

public class BOJ_25206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0;
        double hap = 0;
        for (int i = 0; i < 20; i++) {
            String s = sc.next();
            double score = sc.nextDouble();
            String d = sc.next();
            if (!d.equals("P")) {
                switch (d) {
                    case "A+" : total += 4.5 * score; break;
                    case "A0" : total += 4.0 * score; break;
                    case "B+" : total += 3.5 * score; break;
                    case "B0" : total += 3.0 * score; break;
                    case "C+" : total += 2.5 * score; break;
                    case "C0" : total += 2.0 * score; break;
                    case "D+" : total += 1.5 * score; break;
                    case "D0" : total += score; break;
                    case "F" : total += 0.0; break;
                }
                hap += score;
            }
        }
        System.out.println(total / hap);
    }
}
