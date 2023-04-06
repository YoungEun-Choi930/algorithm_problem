import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static char[][] tree;	// 입력받은 트리
	private static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		// 입력파일 객체화
		int N = Integer.parseInt(br.readLine());
		tree = new char[26][2];
		String input;
		for(int i = 0 ; i < N ; i++) {
			input = br.readLine();
			int idx = input.charAt(0)-'A';
			tree[idx][0] = input.charAt(2);
			tree[idx][1] = input.charAt(4);
		}

		// solve
		
		for(curDelNum = 0 ; curDelNum < 3 ; curDelNum++) {
			travel(0);
			sb.append("\n");
		}

		// 출력
		System.out.println(sb);
	}
	// -1 : 현재 노드 출력. 0 : 좌, 1 : 우
	private static int[][] delta = {{-1,0,1},{0,-1,1},{0,1,-1}};
	private static int curDelNum = 0;
	
	private static void travel(int index) {
		
		for(int i = 0 ; i < 3 ; i++) {
			int order = delta[curDelNum][i];
			
			if(order == -1) {		// 현재 노드 방문인 경우
				sb.append((char)(index+'A'));
			}
			else if(tree[index][order] != '.'){	//좌 우 방문이 가능하면
				int nextidx = tree[index][order] - 'A';
				travel(nextidx);
			}
		}
	}
}
