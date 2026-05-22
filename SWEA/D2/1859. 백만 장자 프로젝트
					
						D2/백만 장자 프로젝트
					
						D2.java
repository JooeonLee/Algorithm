import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int TC = sc.nextInt();
		
		for(int tc=0; tc<TC; tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i=0; i<n; i++)
				arr[i] = sc.nextInt();
			
			sb.append("#").append(tc+1).append(" ").append(maxProfit(arr));
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	static long maxProfit(int[] arr) {
		long answer = 0;
		int length = arr.length;
		int maxPrice = arr[length-1];
		
		for(int i=length-1; i>=0; i--) {
			if(arr[i] >= maxPrice)
				maxPrice = arr[i];
			
			answer += maxPrice - arr[i];
		}
		
		return answer;
	}

}