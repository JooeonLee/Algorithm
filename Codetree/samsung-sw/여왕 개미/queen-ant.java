import java.util.*;
import java.io.*;

public class Main {
    static Map<Integer, Home> homeMap = new HashMap<>();
    static TreeSet<Gap> gaps = new TreeSet<>((a, b) -> Integer.compare(a.lNb.id, b.lNb.id));
    static TreeSet<Integer> activeHomeId = new TreeSet<>();
    public static void main(String[] args) {
        // Please write your code here.
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();

        int Q = fr.nextInt();
        int N = 0;
        // Map<Integer, Home> homeMap = new HashMap<>();
        // TreeSet<Gap> gaps = new TreeSet<>((a, b) -> {
        //     // if(a.gap != b.gap)
        //     //     return Integer.compare(b.gap, a.gap);
        //     return Integer.compare(a.lNb.id, b.lNb.id);
        // });
        // TreeSet<Integer> activeHomeId = new TreeSet<>();
        
        for(int i=0; i<Q; i++) {
            int opt = fr.nextInt();

            if(opt == 100) {
                N = fr.nextInt();

                int prev = -1;
                for(int j=1; j<=N; j++) {
                    int pos = fr.nextInt();
                    homeMap.put(j, new Home(j, pos));
                    activeHomeId.add(j);
                    
                    if(prev != -1) {
                        Home lNb = homeMap.get(prev);
                        Home rNb = homeMap.get(j);
                        gaps.add(new Gap(lNb, rNb));
                    }
                    prev = j;
                }
            }

            if(opt == 200) {
                int pos = fr.nextInt();
                N++;
                Home currHome = new Home(N, pos);
                homeMap.put(N, currHome);
                
                if (!activeHomeId.isEmpty()) {
                    int prevId = activeHomeId.last();
                    gaps.add(new Gap(homeMap.get(prevId), currHome));
                }
                activeHomeId.add(N);
            }

            if(opt == 300) {
                int removeId = fr.nextInt();

                // 삭제할 값의 lNb, rNb id -> null 처리 필요 어떻게 깔끔하게?
                Integer lNbId = activeHomeId.lower(removeId);
                Integer rNbId = activeHomeId.higher(removeId);

                Home removeHome = homeMap.get(removeId);

                if(lNbId != null) {
                    Home lNbHome = homeMap.get(lNbId);
                    gaps.remove(new Gap(lNbHome, removeHome));
                }
                if(rNbId != null) {
                    Home rNbHome = homeMap.get(rNbId);
                    gaps.remove(new Gap(removeHome, rNbHome));
                }
                // activeHome에서 삭제
                activeHomeId.remove(removeId);

                // 새로운 gap 추가
                if(lNbId != null && rNbId != null) {
                    Home lNb = homeMap.get(lNbId);
                    Home rNb = homeMap.get(rNbId);
                    gaps.add(new Gap(lNb, rNb));
                }
            }

            if(opt == 400) {
                int r = fr.nextInt();
                int answer = paramSearch(r);
                sb.append(answer).append('\n');
            }
        }
        System.out.println(sb);
    }

    static int paramSearch(int r) {
        if(activeHomeId.isEmpty())
            return 0;
        else {
            int lastHomeId = activeHomeId.last();
            Home lastHome = homeMap.get(lastHomeId);

            int left = 0;
            int right = lastHome.pos;

            int answer = -1;
            while(left <= right) {
                int mid = left + (right - left)/2;

                if(canVisit(mid, r)) {
                    answer = mid;
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }

            return answer;
        }
    }
    static boolean canVisit(int time, int r) {
        if(activeHomeId.isEmpty())
            return true;
        
        int cnt = 1;
        int sum = 0;

        for(Gap gap : gaps) {
            if(sum + gap.gap <= time)
                sum += gap.gap;
            else {
                cnt++;
                sum = 0;

                if(cnt > r)
                    return false;
            }
        }
        return true;
    }


    static class Home {
        int id;
        int pos;

        public Home(int id, int pos) {
            this.id = id;
            this.pos = pos;
        }
    }
    static class Gap {
        Home lNb;
        Home rNb;
        int gap;

        public Gap(Home lNb, Home rNb) {
            this.lNb = lNb;
            this.rNb = rNb;
            this.gap = rNb.pos - lNb.pos;
        }

        public boolean containsId(int id) {
            return lNb.id == id || rNb.id == id;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st==null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(Exception e) {
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