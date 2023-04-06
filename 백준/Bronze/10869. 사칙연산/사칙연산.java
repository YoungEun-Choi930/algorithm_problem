import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		
		System.out.printf("%d\n%d\n%d\n%d\n%d",a+b,a-b,a*b,a/b,a%b);
	}
}