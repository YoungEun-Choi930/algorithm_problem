package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1991_S1_트리순회 {
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
		
		/*
		 * 재귀로도 풀 수 있고 반복문으로도 할 수 있을 것 같은데
		 * 
		 * 그냥 풀 수 있을 것 같았는데 입력되는 순서가 ABCD... 이렇게 순서대로 들어오는게 아니라서
		 * 정렬 과정이 필요했다. 이를 입력받을 때 index 차리를 찾아서 넣는 걸로 만들어주었다.
		 * 
		 * 3개 과정이 비슷한 과정인데 각각을 메소드로 만드니까 코드가 길어지는 것 같아서
		 * 코드를 줄이기 위해 delta를 사용하기로 하였다.
		 */
		
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
			int direction = delta[curDelNum][i];
			
			if(direction == -1) {		// 현재 노드 방문인 경우
				sb.append((char)(index+'A'));
			}
			else if(tree[index][direction] != '.'){	//좌 우 방문이 가능하면
				int nextidx = tree[index][direction] - 'A';
				travel(nextidx);
			}
		}
	}
	/*
	private static void preorder(int index) {
		sb.append((char)(index+'A'));
		
		if(tree[index][0] != '.') {
			int nextidx = tree[index][0] - 'A';
			preorder(nextidx);
		}
		
		if(tree[index][1] != '.') {
			int nextidx = tree[index][1] - 'A';
			preorder(nextidx);
		}
	}
	
	private static void inorder(int index) {
		if(tree[index][0] != '.') {
			int nextidx = tree[index][0] - 'A';
			inorder(nextidx);
		}
		
		sb.append((char)(index+'A'));
		
		if(tree[index][1] != '.') {
			int nextidx = tree[index][1] - 'A';
			inorder(nextidx);
		}
	}
	
	private static void postorder(int index) {
		if(tree[index][0] != '.') {
			int nextidx = tree[index][0] - 'A';
			postorder(nextidx);
		}
		
		if(tree[index][1] != '.') {
			int nextidx = tree[index][1] - 'A';
			postorder(nextidx);
		}

		sb.append((char)(index+'A'));
	}
	*/
}
