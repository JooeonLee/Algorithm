import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        // Please write your code here.
        boolean flag = true;
        ArrayDeque<Integer> os = new ArrayDeque<>();
        ArrayDeque<Integer> qs = new ArrayDeque<>();
        char[] cArr = str.toCharArray();
        for(int i=0; i<cArr.length; i++) {
            char c = cArr[i];
            if(c == '(')
                os.push(i);
            else if(c == '?')
                qs.push(i);
            else {
                if(!os.isEmpty())
                    os.pollFirst();
                else if(!qs.isEmpty())
                    qs.pollFirst();
                else {
                    flag = false;
                    break;
                }
            }
        }

        if(!flag) {
            System.out.print("No");
            return;
        }
        else {
            if(!os.isEmpty() && qs.isEmpty()) {
                System.out.print("No");
                return;
            }
            else if(os.isEmpty()) {
                if(qs.size() % 2 == 0)
                    System.out.print("Yes");
                else
                    System.out.print("No");
                
                return;
            }
            else {
                while(!os.isEmpty()) {
                    int oIdx = os.pollFirst();
                    Integer qIdx = qs.peekFirst();

                    if(qIdx == null || qIdx < oIdx) {
                        System.out.print("No");
                        return;
                    }
                    else {
                        qs.pollFirst();
                    }
                }
            }
        }

        if(qs.isEmpty()) {
            System.out.print("Yes");
            return;
        }
        else {
            int size = qs.size();
            if(size % 2 == 0)
                System.out.print("Yes");
            else
                System.out.print("No");
        }
    }
}