import java.util.*;

public class Solution {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();
            int[] buildings = new int[N];

            for (int i = 0; i < N; i++) {
                buildings[i] = sc.nextInt();
            }

            int answer = 0;

            for (int i = 2; i < N - 2; i++) {
                int maxNeighbor = Math.max(
                    Math.max(buildings[i - 2], buildings[i - 1]),
                    Math.max(buildings[i + 1], buildings[i + 2])
                );

                if (buildings[i] > maxNeighbor) {
                    answer += buildings[i] - maxNeighbor;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
        
        sc.close();
    }
}
