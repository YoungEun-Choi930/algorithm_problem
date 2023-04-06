import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int r = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);
		
		int result = 0;
		int line = (int) Math.pow(2, N-1);	//한 줄의 갯수/2
		
		
		for(int dep = 0 ; dep < N ; dep++) {
			int count = line * line;	//1/4크기의 갯수
			
			if(r >= line && c >= line) {	//4
				result += count*3;
				r = r - line;
				c = c - line;
			}
			else if(r >= line) {		//3
				result += count*2;
				r = r - line;
			}
			else if(c >= line) {		//2
				result += count;
				c = c - line;
			}
			else {		//1
				
			}
			
			line = line/2;
		}
		if(r == 1 && c == 1) result += 3;
		else if(r == 1) result += 2;
		else if(c == 1) result += 1;
		
		System.out.println(result);
	}
}
