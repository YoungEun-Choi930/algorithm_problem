import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		MinHeap heap = new MinHeap();
		
		for(int i = 0 ; i < N; i++) {
			int in = Integer.parseInt(br.readLine());
			if(in == 0) sb.append(heap.pop(in)).append('\n');
			else heap.push(in);
		}
		
		System.out.println(sb);
	}

}

class MinHeap {
	int[] heap;
	int size;
	
	public MinHeap() {
		heap = new int[100_000];
		size = 0;
	}
	
	public void push (int n) {
		int index = ++size;
		heap[index] = n;
		
		int p, t;
		while(index > 1 && heap[index] < heap[index/2]) {
			p = index / 2;
			
			t = heap[p];
			heap[p] = heap[index];
			heap[index] = t;
			
			index /= 2;
		}
		
	}
	
	public int pop(int n) {
		if(size == 0) return 0;
		
		int r = heap[1];
		heap[1] = heap[size];
		size--;
		
		int cur = 1, child;
		while(cur <= size && cur * 2 <= size) {
			if(cur*2+1 > size) child = cur*2;
			else child = heap[cur * 2] < heap[cur * 2 + 1] ? cur * 2 : cur * 2 + 1;
			
            if (heap[cur] < heap[child]) break;
            
            int temp = heap[cur];
            heap[cur] = heap[child];
            heap[child] = temp;
            
            cur = child;
		}
		
		return r;
	}
}

