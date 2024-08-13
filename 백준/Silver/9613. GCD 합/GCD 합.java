import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    static FastReader scanner = new FastReader();
    static StringBuilder builder = new StringBuilder();

    static int caseNum;
    static int num;
    static Vector<Integer>[] nums;
    static Vector<Long> answers;

    static void input() {
        caseNum = scanner.nextInt();
        nums = new Vector[caseNum];
        answers = new Vector<>();

        for(int i = 0; i < caseNum; i++) {
            num = scanner.nextInt();
            nums[i] = new Vector<>();

            for(int j = 0; j < num; j++) {
                nums[i].add(scanner.nextInt());
            }
        }

    }

    static void printAnswers() {
        for(int i = 0; i < caseNum; i++) {
            System.out.println(answers.get(i));
        }
    }

    static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }

    static void gcd_sum() {
        for(int i = 0; i < caseNum; i++) {
            long answer = 0;
            Collections.sort(nums[i]);
            for(int j = 0; j < nums[i].size(); j++) {
                for(int k = j + 1; k < nums[i].size(); k++) {
                    answer += gcd(nums[i].get(j), nums[i].get(k));
                }
            }
            answers.add(answer);
        }
    }
    public static void main(String[] args) {
        input();
        gcd_sum();
        printAnswers();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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