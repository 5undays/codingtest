package boj;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 오늘 날짜
 * https://www.acmicpc.net/problem/10699
 */
public class BOJ_10699 {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(date));
    }
}
