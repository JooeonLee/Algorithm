import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int money;
    static int[] stockPrices = new int[14];

    public static void main(String[] args) {
        input();
        solution();
    }

    static FastReader scan = new FastReader();

    static void input() {
        money = scan.nextInt();
        for(int i=0; i<14; i++)
            stockPrices[i] = scan.nextInt();
    }

    static void solution() {
        int BNP_money = money;
        int BNP_stock_count = 0;

        for(int stockPrice: stockPrices) {
            if(BNP_money >= stockPrice) {
                int buy = BNP_money/stockPrice;
                BNP_stock_count += buy;
                BNP_money -= stockPrice * buy;
            }
        }
        int BNP_Result = BNP_stock_count * stockPrices[13] + BNP_money;

        int TIMING_money = money;
        int TIMING_stock_count = 0;

        for(int i=3; i<14; i++) {
            if(stockPrices[i] > stockPrices[i-1] && stockPrices[i-1] > stockPrices[i-2] && stockPrices[i-2] > stockPrices[i-3]) {
                TIMING_money += TIMING_stock_count * stockPrices[i];
                TIMING_stock_count = 0;
            }
            else if(stockPrices[i] < stockPrices[i-1] && stockPrices[i-1] < stockPrices[i-2] && stockPrices[i-2] < stockPrices[i-3]) {
                int buy = TIMING_money/stockPrices[i];
                TIMING_stock_count += buy;
                TIMING_money -= stockPrices[i] * buy;
            }
        }
        int TIMING_Result = TIMING_stock_count * stockPrices[13] + TIMING_money;

        if(BNP_Result == TIMING_Result) {
            System.out.println("SAMESAME");
        }
        else if(BNP_Result > TIMING_Result) {
            System.out.println("BNP");
        }
        else {
            System.out.println("TIMING");
        }
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