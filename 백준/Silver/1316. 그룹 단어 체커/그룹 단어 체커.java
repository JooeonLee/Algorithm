import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        input();
        System.out.println(solution());
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static char[][] word;
    static boolean[] checked;


    static void input() {
        N = scan.nextInt();
        word = new char[N][100];
        for (int i = 0; i < N; i++) {
            word[i] = scan.next().toCharArray();
        }
    }

    static int solution() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            if(isGroupWord(word[i]))
                count++;
        }

        return count;
    }

    static boolean isGroupWord(char[] word) {
        initChecked();
        char prev = word[0];
        checked[prev - 'a'] = true;
        for (int i = 1; i < word.length; i++) {
            if (word[i] != prev) {
                if(checked[word[i] - 'a'])
                    return false;
                checked[word[i] - 'a'] = true;
                prev = word[i];
            }
        }
        return true;
    }

    static void initChecked() {
        checked = new boolean[26];
        for (int i = 0; i < 26; i++) {
            checked[i] = false;
        }
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