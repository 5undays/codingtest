package boj;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 오늘의 날짜는?
 * https://www.acmicpc.net/problem/16170
 */
public class BOJ_16170 {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
        String year = sdf.format(date);
        sdf = new SimpleDateFormat("MM");
        String month = sdf.format(date);
        sdf = new SimpleDateFormat("dd");
        String day = sdf.format(date);
        System.out.println(year + "\n" + month + "\n" + day);
    }
}
