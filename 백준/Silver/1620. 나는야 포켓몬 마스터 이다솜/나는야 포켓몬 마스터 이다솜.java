import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		Hashtable str2num = new Hashtable(200_009);
		String[] num2str = new String[N+1];
		String in;
		for(int i = 1 ; i <= N; i++) {
			in = br.readLine();
			num2str[i] = in;
			str2num.add(in, i);
		}
		
		for(int i = 0 ; i < K; i++) {
			
			in = br.readLine();
			if(in.charAt(0) <= '9') {
				sb.append(num2str[Integer.parseInt(in)]).append('\n');
			}
			else {
				sb.append(str2num.find(in)).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
}


class Hashtable
{
    class Hash {
        String key;
        int data;
        Hash link;
		public Hash(String key, int data, Hash link) {
			this.key = key;
			this.data = data;
			this.link = link;
		}
    }
 
    int capacity;
    Hash tb[];
     
    public Hashtable(int capacity){
        this.capacity = capacity;
        tb = new Hash[capacity];
    }
     
    private int hash(String str)
    {
        int hash = 5381;
         
        for (int i = 0; i < str.length(); i++)
        {
            int c = (int)str.charAt(i);
            hash = ((hash << 5) + hash) + c;
        }
        if (hash < 0) hash *= -1;
        return hash % capacity;
    }
     
    public int find(String key){
        int h = hash(key);
        
        for(Hash cur = tb[h]; cur != null; cur = cur.link) {
        	if(cur.key.equals(key)) return cur.data;
        }
        
        return -1;
    }
     
    boolean add(String key, int data)
    {
        int h = hash(key);
        tb[h] = new Hash(key, data, tb[h]);
        
        return true;
    }
}