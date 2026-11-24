import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<5; i++) {
            for(int j=0; j<10; j++)
                sb.append('*');
            sb.append('\n');
        }

        System.out.print(sb);
    }
}