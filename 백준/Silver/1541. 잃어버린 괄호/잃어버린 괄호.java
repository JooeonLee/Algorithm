import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        String inputStr = fr.next();

        boolean flag = false;
        int temp = 0;
        int answer = 0;

        for(int i=0; i<inputStr.length(); i++) {
            if(inputStr.charAt(i) == '+' || inputStr.charAt(i) == '-' || i == inputStr.length()) {
                if(flag) {
                    answer -= temp;
                    //System.out.println(answer);
                }
                else {
                    answer += temp;
                    //System.out.println(answer);
                }
                    
                if(inputStr.charAt(i) == '-')
                  flag = true;
                  
                temp = 0;
            }
            
            else {
                temp *= 10;
                temp += inputStr.charAt(i) - '0';
                //System.out.println(inputStr.charAt(i) - '0');
            }
        }
        
        if(flag)
          answer -= temp;
        else
          answer += temp;

        System.out.println(answer);
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
