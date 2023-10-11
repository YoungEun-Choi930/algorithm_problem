import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new TreeMap<>();
		for(int i = 0 ; i < N ; i++) {
			String[] in = br.readLine().split("\\.");
			map.put(in[1], map.getOrDefault(in[1], 0)+1);
		}
		
		StringBuilder sb = new StringBuilder();
		for(Entry<String, Integer> item : map.entrySet()) {
			sb.append(item.getKey()+" "+item.getValue()+"\n");
		}
		
		System.out.println(sb);
	}
}
