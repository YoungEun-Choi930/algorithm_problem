import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력파일 객체화
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int tN = N;	// 출력을 위한 temp
		int K = Integer.parseInt(input[1]);
		List<Integer> list = new LinkedList<>();
		for(int i = 1; i <= N ; i++) {
			list.add(i);
		}
		
		// solve
		int cnt = 0;	//result에 입력하는 index
		int cur = 0;	//현재 list를 가르키는 curser
		int[] result = new int[N];
		while(N > 0) {

			cur += K-1;
			while(cur >= N) {
				cur %= N;
			}
			
			result[cnt++] = list.remove(cur);
			N--;
		}
		
		
		//출력
		sb.append("<");
		for(int i = 0 ; i < tN-1 ; i++) {
			sb.append(result[i]).append(", ");
		}
		sb.append(result[tN-1]);
		sb.append(">");
		
		System.out.println(sb);
	}
}
