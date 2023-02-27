import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int N;
	private static int[] array;
	private static void makeSet() {
		array = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			array[i] = i;
		}
	}
	
	private static int findSet(int a) {
		if(array[a] == a)
			return a;
		
		return array[a] = findSet(array[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot)
			return false;
		
		
		array[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[][] array = new int[M][2];
		for(int i = 0 ; i < M; i++) {
			input= br.readLine().split(" ");
			array[i][0] = Integer.parseInt(input[0]);
			array[i][1] = Integer.parseInt(input[1]);
		}
		
		// ===================================
		int result = 0;
		makeSet();
		for(int i = 0 ; i < M; i++) {
			int a = array[i][0];
			int b = array[i][1];
			if(!union(a,b)) {
				result = i+1;
				break;
			}
			
		}
		
		System.out.println(result);
	}
}