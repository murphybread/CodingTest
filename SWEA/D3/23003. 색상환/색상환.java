import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] colors = {"red","orange", "yellow", "green", "blue", "purple"};
		
		
		StringBuilder sb = new StringBuilder();
		List<String> colorList = Arrays.asList(colors);
		
		int T = Integer.parseInt(br.readLine()); 
		
		for (int tc=0;tc<T;tc++) {
			char answer;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String a = st.nextToken();
			String b = st.nextToken();
			
			int aIdx = colorList.indexOf(a);
			int bIdx = colorList.indexOf(b);
			
			
			if (a.equals(b)) {
				answer = 'E';
				
			}
			
			
			else if (Math.abs(aIdx-bIdx) == 1 || Math.abs(aIdx-bIdx) == 5  ) {
				
				answer = 'A';
				
				
			}
			
			else if (Math.abs(aIdx-bIdx) == 3) {
				answer = 'C';
				
			} else {
				answer = 'X';
			}
			
			
			
			
			sb.append(answer).append("\n");
		}
        
        		System.out.println(sb);

	}

}
