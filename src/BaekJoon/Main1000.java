package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1000 {
	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		String string = bReader.readLine();
		string = string.trim();
		
		
		if(string.isEmpty()){
            System.out.println(0);
        } else {
        	System.out.println(string.split(" ").length);
        }
	}
}
