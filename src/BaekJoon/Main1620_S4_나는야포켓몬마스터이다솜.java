package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main1620_S4_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		Map<String, Integer> pokemons = new HashMap<>();
		String[] pokemonNum = new String[N+1];
		
		String s;
		for(int i = 1 ; i <= N ; i++) {
			s = br.readLine();
			pokemons.put(s, i);
			pokemonNum[i] = s;
		}
		
		for(int i = 0 ; i < M ; i++) {
			s = br.readLine();
			if(isNum(s)) {
				int n = Integer.parseInt(s);
				sb.append(pokemonNum[n]).append("\n");
				
			}
			else {
				sb.append(pokemons.get(s)).append("\n");
			}
			
		}
		
		System.out.println(sb);
	}
	
	private static boolean isNum(String n) {
		char a = n.charAt(0);
		if(a >= '0' && a <= '9')
			return true;
		return false;
	}
}
