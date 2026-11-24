import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        StringBuilder sb = new StringBuilder();
        String str = "12345^&*()_\n";
        for(int i=0; i<n; i++)
            sb.append(str);
        System.out.print(sb);
    }
}