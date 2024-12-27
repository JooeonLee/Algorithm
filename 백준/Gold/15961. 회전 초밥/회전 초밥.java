import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        input();
        System.out.println(solution());
    }

    static FastReader scan = new FastReader();

    static int n, d, k, c;
    static int[] sushi, count;

    static void input() {
        n = scan.nextInt();
        d = scan.nextInt();
        k = scan.nextInt();
        c = scan.nextInt();

        sushi = new int[n];
        count = new int[d+1];

        for (int i = 0; i < n; i++) {
            sushi[i] = scan.nextInt();
        }
    }

    static int solution() {
        int windowCount = 0;
        int maxCount = 0;

        for(int i=0; i<k; i++)  {
            if(count[sushi[i]] == 0)
                windowCount++;
            count[sushi[i]]++;
        }
        maxCount = windowCount;

        for(int i=0; i<n; i++) {
            int start = sushi[i];
            count[start]--;
            if(count[start] == 0)
                windowCount--;

            int end = sushi[(i+k)%n];
            if(count[end] == 0)
                windowCount++;
            count[end]++;

            if(count[c] == 0)
                maxCount = Math.max(maxCount, windowCount + 1);
            else
                maxCount = Math.max(maxCount, windowCount);
        }
        return maxCount;
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