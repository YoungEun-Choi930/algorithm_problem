import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	private static class Point implements Comparable<Point>{
		int y;
		boolean open;
		
		public Point(int y, boolean open) {
			this.y = y;
			this.open = open;
		}
		
		

		@Override
		public String toString() {
			return "Point [y=" + y + ", open=" + open + "]";
		}



		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.y, o.y);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		// 입력받기. 왼쪽 아래 꼭짓점 찾기
		int[][] pointer = new int[N][2];
		int left = Integer.MAX_VALUE;
		int bottom = Integer.MAX_VALUE;
		int startidx = 0;
		StringTokenizer st ;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			pointer[i][0] = y1;
			pointer[i][1] = x1;
			
			if(left >= y1 && bottom >= x1) {
				left = y1;
				bottom = x1;
				startidx = i;
			}
		}
		

		List<Point> list = new ArrayList<>();
		int x1, y1, x2, y2;
		int count = 0;
		int[] selected = new int[2];
		
		// 리스트에 넣기
		int nextidx = startidx, curidx = startidx;
		while(true) {
			if(++nextidx == N) nextidx = 0;
			
			y1 = pointer[curidx][0];
			x1 = pointer[curidx][1];
			y2 = pointer[nextidx][0];
			x2 = pointer[nextidx][1];
			
			if((x1 > 0 && x2 < 0) || (x1 < 0 && x2 > 0)) {
				selected[count++] = y1;
				if(count == 2) {
					count = 0;
					boolean flag = false;
					
					if(selected[0] < selected[1]) flag = true;
					list.add(new Point(selected[0], flag));
					list.add(new Point(selected[1], !flag));
				}
			}
			if(++curidx == N) curidx = 0;
			if(curidx == startidx) break;
		}
		
		// y좌표 순으로 정렬
		Collections.sort(list);
		
		
		
		// solve
		int count1 = 0;	//다른 봉우리에 의해 포함되지 않는 봉우리 개수. 제일 바깥
		int count2 = 0;	//다른 봉우리를 포함하지 않는 봉우리 개수. 제일 안. 
		
		Stack<Point> stack = new Stack<>();
		for(int i = 0 ; i < list.size(); i++) {
			Point p = list.get(i);
			
			if(p.open) {
				if(stack.isEmpty()) count1++;
				
				stack.push(p);
				
				if(!list.get(i+1).open) count2++;
			}
			else {
				stack.pop();
			}
			
		}
		
		System.out.println(count1+" "+count2);
		
	}

}
