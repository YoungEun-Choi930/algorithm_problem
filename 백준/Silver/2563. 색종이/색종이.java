import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//input
		int N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[100][100];
		int count = 0;

		// solve
		for(int i = 0 ; i < N ; i++) {
			String[] input = br.readLine().split(" ");
			int startx = Integer.parseInt(input[0]);
			int starty = Integer.parseInt(input[1]);
			
			for(int x = startx ; x < startx+10; x++) {
				for(int y = starty ; y < starty+10 ; y++) {
					if(!map[x][y]) {
						map[x][y] = true;
						count++;
					}
				}
			}
			
		}

		// 출력
		System.out.println(count);
	}
}