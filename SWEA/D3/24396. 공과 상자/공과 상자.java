import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		
		
		for (int tc = 1;tc<=T;tc++) {
			StringTokenizer st =  new StringTokenizer(br.readLine());
			
			
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int Z = Integer.parseInt(st.nextToken());
			
			
			
			int normal = B*X + W*Y;
			int small = Math.min(B, W);
			
			
			int bS = B - small;
			int wS = W - small;
			
			int changeCase = (bS *X) + (wS*Y)  +  (small *2 *Z);
			
					
			
			
			sb.append( Math.max(normal, changeCase) ).append("\n");
			
			
		}
		
		System.out.println(sb);
		
		

	}

}
