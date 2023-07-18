import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	private static class Emoji {
		int display, clipboard;

		public Emoji(int display, int clipboard) {
			this.display = display;
			this.clipboard = clipboard;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		
		System.out.println(getMinTime(S));
	}

	private static int getMinTime(int S) {

		boolean[][] visited = new boolean[1500][1500];
		Queue<Emoji> queue = new ArrayDeque<>();
		queue.offer(new Emoji(1, 0));
		visited[1][0] = true;
		visited[0][0] = true;
		
		int time = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(--size >= 0) {
				Emoji cur = queue.poll();
				int d = cur.display;
				int c = cur.clipboard;
				
				if(d == S) return time;
				
				// 1. 복사
				if(!visited[d][d]) {
					visited[d][d] = true;
					queue.offer(new Emoji(d,d));
				}
				
				// 2. 붙여넣기
				if(d+c < 1500 && !visited[d+c][c]) {
					visited[d+c][c] = true;
					queue.offer(new Emoji(d+c,c));
				}
				
				// 3. 삭제
				if(d>0 && !visited[d-1][c]) {
					visited[d-1][c] = true;
					queue.offer(new Emoji(d-1, c));
				}
			}
			++time;
		}
		
		return 0;
	}
}
