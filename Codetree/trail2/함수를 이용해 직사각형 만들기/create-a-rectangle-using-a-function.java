import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowNum = sc.nextInt();
        int colNum = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        // Please write your code here.
        for(int i=0; i<rowNum; i++) {
            for(int j=0; j<colNum; j++)
                sb.append('1');
            sb.append('\n');
        }
        System.out.print(sb);
    }
}