import java.util.Scanner;
import java.io.FileInputStream;

class Solution {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) throws Exception {

        // 제출 시 주석 처리
        // System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int N = sc.nextInt();

            Point[] points = new Point[N];

            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                points[i] = new Point(x, y);
            }

            int answer = 0;

            for (int i = 0; i < N; i++) {
                Point base = points[i];

                int maxWidth = 0;
                int maxHeight = 0;

                for (int j = 0; j < N; j++) {
                    if (i == j) continue;

                    Point other = points[j];

                    // 같은 y좌표이면 x축과 평행한 변을 만들 수 있음
                    if (base.y == other.y) {
                        maxWidth = Math.max(maxWidth, Math.abs(base.x - other.x));
                    }

                    // 같은 x좌표이면 y축과 평행한 변을 만들 수 있음
                    if (base.x == other.x) {
                        maxHeight = Math.max(maxHeight, Math.abs(base.y - other.y));
                    }
                }

                answer = Math.max(answer, maxWidth * maxHeight);
            }

            System.out.println(answer);
        }

        sc.close();
    }
}