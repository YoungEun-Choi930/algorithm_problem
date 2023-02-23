import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	private static int[] volumelist;
	private static int N, M, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);	//1 ≤ N ≤ 50
		int S = Integer.parseInt(input[1]);	//0 ≤ S ≤ M
		M = Integer.parseInt(input[2]);	//1 ≤ M ≤ 1,000
		
		volumelist = new int[N];
		input = br.readLine().split(" ");
		for(int i = 0 ; i < N ; i++) volumelist[i] = Integer.parseInt(input[i]);
		
		// solve
		
		Set<Integer> pre = new HashSet<>();
		pre.add(S);
		
		for(int i = 0 ; i < N ; i++) {
			Set<Integer> cur = new HashSet<>();
			
			for(int vol : pre) {
				if(vol+volumelist[i] <= M) cur.add(vol+volumelist[i]);
				if(vol-volumelist[i] >= 0) cur.add(vol-volumelist[i]);
			}
			
			pre = cur;
			if(cur.size() == 0) break;
		}
		
		int result = -1;
		for(int vol : pre) {
			if(result < vol) result = vol;
		}
		System.out.println(result);
		
	}
	
	
}