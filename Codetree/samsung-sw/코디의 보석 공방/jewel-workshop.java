
import java.util.*;
import java.io.*;

public class Main {

    static class Jewel {
        int weight, value;
        boolean active;

        Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.active = true;
        }
    }

    static ArrayList<Jewel> jewels = new ArrayList<>();

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();

        int Q = fr.nextInt();

        jewels.add(null);

        for (int q = 0; q < Q; q++) {
            int cmd = fr.nextInt();

            if (cmd == 1) {
                int N = fr.nextInt();

                for (int i = 0; i < N; i++) {
                    int w = fr.nextInt();
                    int v = fr.nextInt();

                    jewels.add(new Jewel(w, v));
                }
            }

            else if (cmd == 2) {
                int w = fr.nextInt();
                int v = fr.nextInt();

                jewels.add(new Jewel(w, v));
            }

            else if (cmd == 3) {
                int id = fr.nextInt();

                if (id <= 0 || id >= jewels.size()
                        || !jewels.get(id).active) {
                    sb.append(-1).append('\n');
                    continue;
                }

                Jewel jewel = jewels.get(id);
                jewel.active = false;

                sb.append(jewel.value).append('\n');
            }

            else if (cmd == 4) {
                int W = fr.nextInt();

                long[] dp = new long[W + 1];

                for (int i = 1; i < jewels.size(); i++) {
                    Jewel jewel = jewels.get(i);

                    if (!jewel.active || jewel.weight > W)
                        continue;

                    for (int w = W; w >= jewel.weight; w--) {
                        dp[w] = Math.max(
                            dp[w],
                            dp[w - jewel.weight] + jewel.value
                        );
                    }
                }

                sb.append(dp[W]).append('\n');
            }

            else if (cmd == 5) {
                int K = fr.nextInt();

                int[] weights = new int[jewels.size() - 1];
                int size = 0;

                for (int i = 1; i < jewels.size(); i++) {
                    Jewel jewel = jewels.get(i);

                    if (jewel.active) {
                        weights[size++] = jewel.weight;
                    }
                }

                Arrays.sort(weights, 0, size);

                long answer = 0;
                int left = 0;

                for (int right = 0; right < size; right++) {
                    while (weights[right] - (long) weights[left] > K) {
                        left++;
                    }

                    answer += right - left;
                }

                sb.append(answer).append('\n');
            }
        }

        System.out.print(sb);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(s));
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
    }
}
