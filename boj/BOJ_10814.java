package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 나이순정렬
 * https://www.acmicpc.net/problem/10814
 */
public class BOJ_10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Person> arr = new ArrayList<>();
        while (n-- > 0) {
            arr.add(new Person(sc.nextInt(), sc.next()));
        }
        Collections.sort(arr, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                System.out.println("o1.age - o2.age : "+ (o1.age - o2.age));
                return o1.age - o2.age;
            }

        });
        StringBuilder sb = new StringBuilder();
        for (Person p : arr) {
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }
        System.out.println(sb);
    }

    static class Person {
        int age;
        String name;

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

    }
}
