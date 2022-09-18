package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [1차] 뉴스 클러스터링
 * https://school.programmers.co.kr/learn/courses/30/lessons/17677
 */
public class PGS_17677 {
    static final int jakad = 65536;

    public static void main(String[] args) {
        // int a = solution("FRANCE", "french");
        // int a1 = solution("aa1+aa2", "AAAA12");
        // int a2 = solution("E=M*C^2", "e=m*c^2");
        // int a3 = solution("handshake", "shake hands");
        // int a3 = solution("ab cd cd cd cd", "ab ab ab ef");
        // int a3 = solution("a a b b c", "a b b d e");
        // int a3 = solution("ABDDD", "DDEFGHH");
        int a3 = solution("abccc", "ccdefgg");

        // System.out.println(a);
        // System.out.println(a1);
        System.out.println(a3);
    }

    /**
     * 문자열의 자카드 유사도
     * 
     * @param str1
     * @param str2
     * @return
     */
    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        List<String> str1Pair = makePairs(str1);
        List<String> str2Pair = makePairs(str2);

        Collections.sort(str1Pair);
        Collections.sort(str2Pair);

        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersect = new ArrayList<>();

        for (String s : str1Pair) {
            if (str2Pair.remove(s)) {
                intersect.add(s);
            }
            union.add(s);
        }

        for (String s : str2Pair) {
            union.add(s);
        }

        // 집합의 크기가 하나인경우
        if (union.size() == 0) {
            return jakad;
        } else {
            return (int) (((double) intersect.size() / (double) union.size()) * jakad);
        }
    }

    /**
     * 문자열 쌍 리스트
     * 
     * @param str 문자열
     * @return
     */
    public static ArrayList<String> makePairs(String str) {
        ArrayList<String> pair = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            char a = str.charAt(i);
            char b = str.charAt(i + 1);
            if (Character.isLetter(a) && Character.isLetter(b)) {
                pair.add(a + "" + b);
            }
        }
        return pair;
    }
}