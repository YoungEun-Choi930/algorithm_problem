import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력파일 객체화
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i = 0 ; i < N ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		if(N == 1) {
			System.out.println(map[0][0]);
		}
		else {
		// 출력
			System.out.println(splitQuad(N,0,0));
		}
	}
	
	private static StringBuilder splitQuad(int length, int startX, int startY) {
		//length : 배열의 가로길이
		if(length == 2) {
			char a = map[startX][startY];
			char b = map[startX][startY+1];
			char c = map[startX+1][startY];
			char d = map[startX+1][startY+1];
			if(a == b && c == d && a == c) {
				return new StringBuilder().append(a);
			}
			else {
				return new StringBuilder("(").append(a).append(b).append(c).append(d).append(")");
			}
		}
		
		
		StringBuilder sa = splitQuad(length/2, startX, startY);
		String a = sa.toString();
		String b = splitQuad(length/2, startX, startY + length/2).toString();
		String c = splitQuad(length/2, startX + length/2, startY).toString();
		String d = splitQuad(length/2, startX + length/2, startY + length/2).toString();
		
		if((a.equals("1")||a.equals("0")) && a.equals(b)&&c.equals(d)&& a.equals(c)) {
			return sa;
		}
		else {
			return new StringBuilder("(").append(a).append(b).append(c).append(d).append(")");
		}
		
	}
}
