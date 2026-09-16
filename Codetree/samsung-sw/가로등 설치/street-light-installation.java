import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static TreeSet<Integer> lights;
    static ArrayList<Integer> position;
    static PriorityQueue<Gap> pq;

    static class Gap {
        int left;
        int right;

        Gap(int left, int right) {
            this.left = left;
            this.right = right;
        }

        int length() {
            return right - left;
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();

        int Q = fr.nextInt();

        for (int q = 0; q < Q; q++) {
            int command = fr.nextInt();

            if (command == 100) {
                N = fr.nextInt();
                int M = fr.nextInt();

                init();

                for (int i = 0; i < M; i++) {
                    int x = fr.nextInt();

                    lights.add(x);
                    position.add(x);
                }

                Integer prev = null;

                for (int x : lights) {
                    if (prev != null) {
                        pq.offer(new Gap(prev, x));
                    }

                    prev = x;
                }

            } else if (command == 200) {

                addLight();

            } else if (command == 300) {

                int id = fr.nextInt();
                removeLight(id);

            } else if (command == 400) {

                sb.append(getMinPower()).append('\n');
            }
        }

        System.out.print(sb);
    }

    static void init() {
        lights = new TreeSet<>();

        position = new ArrayList<>();

        position.add(-1);

        pq = new PriorityQueue<>((a, b) -> {
            if (a.length() != b.length()) {
                return Integer.compare(b.length(), a.length());
            }

            return Integer.compare(a.left, b.left);
        });
    }

    static void addLight() {

        Gap gap = getMaxGap();

        int left = gap.left;
        int right = gap.right;
        int mid = left + (right - left + 1) / 2;

        lights.add(mid);
        position.add(mid);
        pq.offer(new Gap(left, mid));
        pq.offer(new Gap(mid, right));
    }

    static void removeLight(int id) {

        int x = position.get(id);

        Integer left = lights.lower(x);
        Integer right = lights.higher(x);

        lights.remove(x);

        if (left != null && right != null) {
            pq.offer(new Gap(left, right));
        }
    }

    static int getMinPower() {

        int first = lights.first();
        int last = lights.last();

        int leftPower = 2 * (first - 1);
        int rightPower = 2 * (N - last);

        Gap maxGap = getMaxGap();

        int middlePower = maxGap.length();

        return Math.max(
                Math.max(leftPower, rightPower),
                middlePower
        );
    }

    static Gap getMaxGap() {

        while (!pq.isEmpty()) {

            Gap gap = pq.peek();

            if (isValid(gap)) {
                return gap;
            }

            pq.poll();
        }

        return null;
    }

    static boolean isValid(Gap gap) {

        if (!lights.contains(gap.left)
                || !lights.contains(gap.right)) {
            return false;
        }

        Integer next = lights.higher(gap.left);

        return next != null && next == gap.right;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        int nextInt() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }

            return Integer.parseInt(st.nextToken());
        }
    }
}