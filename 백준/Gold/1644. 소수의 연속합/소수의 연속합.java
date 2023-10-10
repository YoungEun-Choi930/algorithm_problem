import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 1. 소수 구하기
		boolean[] arr = new boolean[N+10];
		arr[1] = true;
		for(int i = 2, end = (int) Math.sqrt((double)N)+1; i <= end ; i++) {
			if(arr[i]) continue;
			
			int j = i+i;
			while(j <= N) {
				arr[j] = true;
				j += i;
			}
		}
		
		// 2. 누적합 구하기
		int[] nums = new int[N+1];
		int e = 1;
		for(int i = 1 ; i <= N ; i++) {
			if(!arr[i]) nums[e++] = i;
		}
//		for(int i = 1 ; i < e ; i++) {
//			System.out.println(nums[i]);
//		}
		
		// 3. 연속된 경우의 수인지 경우의수 구하기
		int result = 0;
		int left = 1;
		int right = 1;
		int sum = 0;
//		System.out.println();
		while(left < e && right < e+1) {
			
			if(sum < N) sum+=nums[right++];
			else sum-=nums[left++];
			
			if(sum == N) result++;
//			System.out.println(sum);
		}
		
		System.out.println(result);
	}
}
