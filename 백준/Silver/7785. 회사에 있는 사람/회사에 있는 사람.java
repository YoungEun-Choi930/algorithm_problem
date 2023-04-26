import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		TreeMap<String, Boolean> map = new TreeMap<String, Boolean>((s1,s2)->(s2.compareTo(s1)));
		for(int i = 0 ; i < N; i ++) {
			String[] in = br.readLine().split(" ");
			if(in[1].charAt(0)=='e') {
				map.put(in[0], true);
			}
			else {
				map.put(in[0], false);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Entry<String, Boolean> s : map.entrySet()) {
			if(s.getValue()) sb.append(s.getKey()).append('\n');
		}
		
		
		System.out.println(sb);
	}
}
