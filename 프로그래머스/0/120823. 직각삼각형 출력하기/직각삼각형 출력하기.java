import java.util.Scanner;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        StringBuffer sb = new StringBuffer();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++)
                sb.append("*");
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}