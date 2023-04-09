import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {		
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String[] string = bReader.readLine().split(" ");

		long result = Long.parseLong(string[0]) + Long.parseLong(string[1]) +Long.parseLong(string[2]) ;
		System.out.println(result);

	}
}