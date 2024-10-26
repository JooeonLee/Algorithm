import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        keyBoardInit();
        input();
        System.out.println(solution());
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static Map<Character, int[]> keyBoard = new HashMap<>();
    static String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    static int[] leftPos;
    static int[] rightPos;
    static String word;


    static void keyBoardInit() {
        for(int i = 0; i < rows.length; i++) {
            for(int j = 0; j < rows[i].length(); j++) {
                keyBoard.put(rows[i].charAt(j), new int[]{i, j});
            }
        }

    }

    static void input() {
        char leftStart = scan.next().charAt(0);
        char rightStart = scan.next().charAt(0);

        leftPos = keyBoard.get(leftStart);  // 초기 왼손 위치 설정
        rightPos = keyBoard.get(rightStart);
        //String lrstart = scan.nextLine();
        //char leftStart = lrstart.charAt(0);
        //char rightStart =lrstart.charAt(2);
        word = scan.next();
    }

    static int solution() {

        int time = 0;

        // 각 문자를 순차적으로 처리
        for (char c : word.toCharArray()) {
            int[] targetPos = keyBoard.get(c);

            // 왼손으로 눌러야 하는지 오른손으로 눌러야 하는지 판별
            if (isLeftHandKey(c)) {
                time += getDistance(leftPos, targetPos) + 1;
                leftPos = targetPos;
            } else {
                time += getDistance(rightPos, targetPos) + 1;
                rightPos = targetPos;
            }
        }

        return time;
    }

    // 왼손으로 눌러야 하는 키인지 판단하는 함수
    private static boolean isLeftHandKey(char c) {
        return "qwertasdfgzxcv".indexOf(c) != -1;
    }

    // 택시 거리 계산 함수
    private static int getDistance(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }



    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}