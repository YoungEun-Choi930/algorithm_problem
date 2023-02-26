import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	private static int N, result;
	private static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		
		// solve
		result = Integer.MAX_VALUE;
		combination(0, 0, new int[N/2]);
		
		System.out.println(result);
	}

	private static void combination(int start, int count, int[] selected) {
		if(count == selected.length) {
			int e1 = getability(selected);
			int[] another = getanother(selected);
			int e2 = getability(another);
			
			int r = Math.abs(e1 - e2);
			if(result > r) result = r;
			return;
		}
		
		for(int i = start; i < N; i++) {
			selected[count] = i;
			combination(i+1, count+1, selected);
		}
		
	}
	
	private static int[] getanother(int[] selected) {
		boolean[] sarray = new boolean[N];
		
		for(int i = 0 ; i < selected.length; i++) {
			sarray[selected[i]] = true;
		}
		
		int[] another = new int[selected.length];
		
		for(int i = 0 , c = 0; i < N ; i++) {
			if(!sarray[i]) another[c++] = i;
		}
		return another;
	}

	private static int getability(int[] selected) {
		int sum = 0;
		for(int i = 0 ; i < selected.length-1; i++) {
			int a = selected[i];
			for(int j = i ; j < selected.length; j++) {
				int b = selected[j];
				
				sum += map[a][b];
				sum += map[b][a];
			}
		}
		
		return sum;
	}
}
