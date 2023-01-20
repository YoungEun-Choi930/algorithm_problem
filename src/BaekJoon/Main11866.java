package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main11866 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		
		
		//solve
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1 ; i <= N ; i++) {
			list.add(i);
		}
		
		sb.append("<");
		K--;
		N--;
		int index = K;		// 첫번째에 3이 들어오면 index 2번을 꺼내야 해서
		sb.append(list.remove(K));
		
		while(N > 0) {
			sb.append(", ");
			index += K;
			
			while(index >= N)
				index -= N;
			
			int n = list.remove(index);
			N--;
			sb.append(n);
			//ystem.out.println(list.toString()+" i"+index+" s"+n);
			
		}
		
		sb.append(">");
		System.out.println(sb);
		
	}
}
