import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		Set<String> set = new TreeSet<>();
		
		for(int i = 0 ; i < N ; i++) {
			set.add(br.readLine());
		}
		
		List<String> twice = new ArrayList<String>();
		for(int i = 0 ; i < M ; i++) {
			String s = br.readLine();
			if(set.contains(s))
				twice.add(s);
		}
		
		Collections.sort(twice);
		sb.append(twice.size()).append("\n");
		for(String s : twice) {
			sb.append(s).append("\n");
		}
		
		System.out.println(sb);
	}
}