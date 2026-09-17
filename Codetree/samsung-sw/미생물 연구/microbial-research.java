import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static ArrayList<Microbe> microbes = new ArrayList<>();

    static boolean[] removed;

    static int N, Q;

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) {

        FastReader fr = new FastReader();

        N = fr.nextInt();
        Q = fr.nextInt();

        // 좌표는 0 ~ N-1
        map = new int[N][N];

        removed = new boolean[Q + 1];

        // id == index로 맞추기 위해 0번은 비워둠
        microbes.add(null);

        for (int id = 1; id <= Q; id++) {

            int lbR = fr.nextInt();
            int lbC = fr.nextInt();
            int ruR = fr.nextInt();
            int ruC = fr.nextInt();

            // 1. 새로운 미생물 투입
            addMicrobe(id, lbR, lbC, ruR, ruC);

            // 2. 분리된 기존 미생물 제거
            removeSep();

            // 3. 살아있는 미생물의 현재 모양 갱신
            updateMicrobeShape();

            // 4. 새로운 배양 용기로 이동
            moveMicrobes();

            // 5. 점수 계산
            int answer = calculateScore();
            System.out.println(answer);
        }
    }

    static void addMicrobe(int id, int lbR, int lbC, int ruR, int ruC) {

        for (int r = lbR; r < ruR; r++) {
            for (int c = lbC; c < ruC; c++) {
                map[r][c] = id;
            }
        }

        microbes.add(new Microbe(id, lbR, lbC, ruR, ruC));
    }

    static void removeSep() {

        int[] totalCnt = new int[Q + 1];

        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++)
                totalCnt[map[r][c]]++;
        }

        boolean[] checked = new boolean[Q + 1];

        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                int currId = map[r][c];
                if(currId == 0)
                    continue;
                if(checked[currId])
                    continue;
                
                checked[currId] = true;
                int currCnt = bfsCnt(map, currId, r, c);

                if(totalCnt[currId] != currCnt)
                    removed[currId] = true;
            }
        }

        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                int currId = map[r][c];
                if(removed[currId])
                    map[r][c] = 0;
            }
        }
    }

    static int bfsCnt(int[][] map, int id, int startR, int startC) {

        boolean[][] visited = new boolean[N][N];

        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = true;

        int result = 1;

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (!isValidIdx(nr, nc))
                    continue;

                if (visited[nr][nc])
                    continue;

                if (map[nr][nc] != id)
                    continue;

                visited[nr][nc] = true;

                queue.offer(new int[]{nr, nc});

                result++;
            }
        }

        return result;
    }

    static void updateMicrobeShape() {

        ArrayList<int[]>[] positions = new ArrayList[Q + 1];

        for (int id = 1; id <= Q; id++) {
            positions[id] = new ArrayList<>();
        }

        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                int currId = map[r][c];
                if(currId != 0) {
                    positions[currId].add(new int[]{r,c});
                }
            }
        }

        for (int id = 1; id < microbes.size(); id++) {

            Microbe microbe = microbes.get(id);

            if (removed[id]) {
                microbe.isRemoved = true;
                continue;
            }

            // 현재 map에 존재하지 않는 미생물
            if (positions[id].isEmpty()) {
                microbe.isRemoved = true;
                continue;
            }

            int minR = N;
            int minC = N;
            for(int[] position : positions[id]) {
                minR = Math.min(minR, position[0]);
                minC = Math.min(minC, position[1]);
            }

            microbe.relativeCoor.clear();

            for(int[] position : positions[id]) {
                microbe.relativeCoor.add(new int[]{position[0]-minR, position[1]-minC});
            }

            microbe.lbR = minR;
            microbe.lbC = minC;
        }
    }

    static void moveMicrobes() {

        ArrayList<Microbe> movingMicrobes = new ArrayList<>();

        for(int id=1; id<microbes.size(); id++) {
            Microbe m = microbes.get(id);

            if(!m.isRemoved)
                movingMicrobes.add(m);
        }

        movingMicrobes.sort((a, b) -> {
            if(a.size() != b.size())
                return Integer.compare(b.size(), a.size());
            
            return Integer.compare(a.id, b.id);
        });

        int[][] newMap = new int[N][N];
        for(Microbe m : movingMicrobes) {
            boolean placed = false;
            outer: for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    if(!canPlace(newMap, m, r, c))
                        continue;
                    
                    for(int[] relative : m.relativeCoor) {
                        int nr = r + relative[0];
                        int nc = c + relative[1];

                        newMap[nr][nc] = m.id;
                    }

                    m.lbR = r;
                    m.lbC = c;

                    placed = true;
                    break outer;
                }
            }

            if(!placed) {
                m.isRemoved = true;
                removed[m.id] = true;
            }
        }
        map = newMap;
    }

    static boolean canPlace(int[][] newMap, Microbe m, int r, int c) {
        for (int[] relative : m.relativeCoor) {

            int nr = r + relative[0];
            int nc = c + relative[1];

            if (!isValidIdx(nr, nc))
                return false;

            if (newMap[nr][nc] != 0)
                return false;
        }

        return true;
    }

    static int calculateScore() {

        int result = 0;

        // 이미 점수를 계산한 미생물 쌍 저장
        HashSet<Integer> checkedPair = new HashSet<>();

        // 오른쪽, 위쪽만 확인
        int[] checkR = {0, 1};
        int[] checkC = {1, 0};

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {

                int currId = map[r][c];

                if (currId == 0)
                    continue;

                for (int d = 0; d < 2; d++) {

                    int nr = r + checkR[d];
                    int nc = c + checkC[d];

                    if (!isValidIdx(nr, nc))
                        continue;

                    int nextId = map[nr][nc];

                    if (nextId == 0)
                        continue;

                    // 같은 미생물
                    if (currId == nextId)
                        continue;

                    // ex (1, 2), (2, 1)을 같은 쌍으로 처리
                    int minId = Math.min(currId, nextId);
                    int maxId = Math.max(currId, nextId);

                    int key = minId * (Q + 1) + maxId;

                    // 이미 계산한 인접 쌍
                    if (!checkedPair.add(key))
                        continue;

                    // 처음 발견한 인접 쌍
                    result += microbes.get(minId).size() * microbes.get(maxId).size();
                }
            }
        }

        return result;
    }

    static boolean isValidIdx(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static class Microbe {

        int id;

        int lbR;
        int lbC;

        boolean isRemoved;

        // 현재 모양을 상대좌표로 저장
        ArrayList<int[]> relativeCoor;

        public Microbe(int id, int lbR, int lbC, int ruR, int ruC) {

            this.id = id;
            this.lbR = lbR;
            this.lbC = lbC;

            this.isRemoved = false;

            this.relativeCoor = new ArrayList<>();

            for (int r = 0; r < ruR - lbR; r++) {
                for (int c = 0; c < ruC - lbC; c++) {

                    relativeCoor.add(
                            new int[]{r, c}
                    );
                }
            }
        }

        public int size() {

            return relativeCoor.size();
        }
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {

            br = new BufferedReader(
                    new InputStreamReader(System.in)
            );
        }

        String next() {

            while (st == null || !st.hasMoreTokens()) {

                try {

                    st = new StringTokenizer(
                            br.readLine()
                    );

                } catch (Exception e) {

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