import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int answer = 0;
        for(int rIdx=0; rIdx<n; rIdx++) {
            for(int cIdx=0; cIdx<n; cIdx++) {
                if(isValid(n, rIdx, cIdx)) {
                    int currCnt = 0;
                    for(int i=rIdx-1; i<=rIdx+1; i++) {
                        for(int j=cIdx-1; j<=cIdx+1; j++)
                            if(grid[i][j] == 1)
                                currCnt++;
                    }
                    answer = Math.max(answer, currCnt);
                }
            }
        }
        System.out.println(answer);

    }

    static boolean isValid(int n, int rIdx, int cIdx) {
        return cIdx - 1 >= 0 && cIdx + 1 <= n-1 && rIdx - 1 >= 0 && rIdx + 1 <= n-1;
    }
}