import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        int[][] dist = new int[n][n];
        int maxGold = 0;
        for(int startR=0; startR<n; startR++) {
            for(int startC=0; startC<n; startC++) {
                for(int k=0; k<= 2*n-1; k++) {
                    int goldCnt = 0;
                    for(int endR=0; endR<n; endR++) {
                        for(int endC=0; endC<n; endC++) {
                            if(grid[endR][endC] == 1) {
                                if(calculateDist(startR, startC, endR, endC) <= k)
                                    goldCnt++;
                            }
                        }
                    }

                    if(k*k+(k+1)*(k+1) <= goldCnt*m) {
                        if(maxGold < goldCnt)
                            maxGold = goldCnt;
                    }
                }
            }
        }

        System.out.println(maxGold);
    }

    private static int calculateDist(int startR, int startC, int endR, int endC) {
        return Math.abs(endR-startR) + Math.abs(endC-startC);
    }
}