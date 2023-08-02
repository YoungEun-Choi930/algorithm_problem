import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0 ; i < N ; i++) {
			String in = br.readLine();
			map.put(in, map.getOrDefault(in, 0)+1);
		}
		
		Map.Entry<String, Integer> max = Collections.max(map.entrySet(), new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				int r1 = o1.getValue() - o2.getValue();
				if(r1 != 0) return r1;
				else return o2.getKey().compareTo(o1.getKey());
			}
		});

		System.out.println(max.getKey());
	}
}
