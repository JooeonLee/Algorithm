import java.util.*;

/**
상범이의 우울
N=100_000
N^2 X

1. 일단 우울 기간 구하기
2. 모든 우울 기간의 2T만큼 꽃주기
3. 최장 우울 기간 중에 가장 많이 꽃을 줄 수 있는 경우 찾아서 꽃주기
*/
public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int[] fArr = new int[N];
      boolean[] flowers = new boolean[N];
      for(int i=0; i<N; i++)
        fArr[i] = sc.nextInt();
      
      ArrayList<int[]> dPeriods = new ArrayList<>();

      // 우울 기간 구하기
      boolean flag = false;
      int startIdx = -1;
      int len = 0;
      int maxLen = 0;
      for(int i=0; i<N; i++) {
        if(fArr[i] < 0) {
          if(!flag) {
            flag = true;
            startIdx = i;
          }
          len++;
        }
        else {
          if(flag) {
            dPeriods.add(new int[]{startIdx, len});
            maxLen = Math.max(maxLen, len);
          }
          flag = false;
          startIdx = -1;
          len = 0;
        }
      }
      if(flag) {
        dPeriods.add(new int[]{startIdx, len});
        maxLen = Math.max(maxLen, len);
      }
      
      // for(int[] p : dPeriods)
      //   System.out.printf("%d %d\n", p[0], p[1]);

      // 모든 우울 기간에 2*len 만큼 꽃주기
      for(int[] p : dPeriods) {
        for(int i=Math.max(0, p[0]-2*p[1]); i<p[0]; i++)
          flowers[i] = true;
      }

      // for(boolean b : flowers)
      //   System.out.print(b + " ");
      // System.out.println();
      // System.out.println(maxLen);

      // 최장 우울 기간 중 최대로 줄 수 있는 수 찾기
      int maxCnt = 0;
      for(int[] p : dPeriods) {
        int cnt=0;
        if(p[1] != maxLen)
          continue; 
        for(int i=Math.max(0, p[0]-3*p[1]); i<Math.max(0, p[0]-2*p[1]); i++) {
          if(!flowers[i])
            cnt++;
        }
        maxCnt = Math.max(maxCnt, cnt);
      }
      
      // System.out.println(maxCnt);

      // 정답
      int answer = 0;
      for(int i=0; i<N; i++)
        if(flowers[i])
          answer++;
      answer += maxCnt;

      System.out.println(answer);
    }
}