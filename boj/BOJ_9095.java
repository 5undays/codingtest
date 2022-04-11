package boj;

public class BOJ_9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(go(0,numbers[i]));
        }
    }

    public int go(int sum, int goal) {
        if (sum > goal) return 0;
        if (sum == goal) return 1;
        int now = 0;
        for (int i = 1; i <= 3; i++) {
            now += go(sum + i, goal)
        }
        return now;
    }
}