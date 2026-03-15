import java.io.*;
import java.util.*;

public class Main {

    static char[][] gears = new char[4][8];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = s.charAt(j);
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNumber = Integer.parseInt(st.nextToken()) - 1; // 0-based
            int direction = Integer.parseInt(st.nextToken());      // 1: 시계, -1: 반시계

            int[] rotateDir = new int[4];
            rotateDir[gearNumber] = direction;

            for (int left = gearNumber - 1; left >= 0; left--) {
                if (gears[left][2] != gears[left + 1][6]) {
                    rotateDir[left] = -rotateDir[left + 1];
                } else {
                    break;
                }
            }

            for (int right = gearNumber + 1; right < 4; right++) {
                if (gears[right - 1][2] != gears[right][6]) {
                    rotateDir[right] = -rotateDir[right - 1];
                } else {
                    break;
                }
            }

            for (int g = 0; g < 4; g++) {
                if (rotateDir[g] == 1) {
                    rotateClockwise(g);
                } else if (rotateDir[g] == -1) {
                    rotateCounterClockwise(g);
                }
            }
        }

        int score = 0;
        if (gears[0][0] == '1') score += 1;
        if (gears[1][0] == '1') score += 2;
        if (gears[2][0] == '1') score += 4;
        if (gears[3][0] == '1') score += 8;

        System.out.println(score);
    }

    static void rotateClockwise(int idx) {
        char temp = gears[idx][7];
        for (int i = 7; i >= 1; i--) {
            gears[idx][i] = gears[idx][i - 1];
        }
        gears[idx][0] = temp;
    }

    static void rotateCounterClockwise(int idx) {
        char temp = gears[idx][0];
        for (int i = 0; i < 7; i++) {
            gears[idx][i] = gears[idx][i + 1];
        }
        gears[idx][7] = temp;
    }
}