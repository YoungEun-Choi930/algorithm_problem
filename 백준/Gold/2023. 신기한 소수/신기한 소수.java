import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	private static int N;
	private static List<Integer> resultArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력파일 객체화
		N = Integer.parseInt(br.readLine());	// N(1 ≤ N ≤ 8)

		
		resultArr = new ArrayList<Integer>();
		
		int[] start = {2,3,5,7};
		
		for(int i = 0; i < start.length; i++) {
			make(1, start[i]);
		}
		
		// 출력
		Collections.sort(resultArr);
		for(int num : resultArr) {
			sb.append(num).append("\n");
		}

		System.out.println(sb);
	}
	private static boolean isSosu(int n) {
		
		int len = (int) Math.sqrt(n);
		for(int i = 2; i <= len; i++) {
			if(n % i == 0) return false;
		}
		return true;
	}
	
	private static void make(int depth, int num) {
		if(depth == N) {
			if(isSosu(num))
				resultArr.add(num);
			return;
		}
		
		int n = num * 10;
		for(int i = 1 ; i < 10 ; i = i+2) {	//짝수는 넘김.
			if(isSosu(n+i))
				make(depth+1, n+i);
		}
	}
}