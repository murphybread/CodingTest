import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T  = Integer.parseInt(br.readLine());
		
		for (int tc=1 ;tc<=T;tc++) {
			StringTokenizer st;
			
			
			int count=0;
			
			
			String  line = br.readLine();
			
			int n =line.length();
	
			int [] nums =new int[n];
			
			for (int i=0;i<n;i++) {
				
				nums[i] = (int)line.charAt(i) - '0';
			}
			
			
			StringBuilder si = new StringBuilder();
			for (int i=0 ; i < n ;i++) {
				si.append("0");
				
			}
			
			String current = sb.toString(); 
			
			
			int head = 0;
			
			
			for (int i =0;i<n;i++) {
				
				if (head !=nums[i]) {
					count +=1;
					
					
//					current = current.substring();
					
					if (head ==0) {
//						
//						
//					String front  = current.substring(0, i);
//					String back = "1".repeat(n-i);
//					current = front+back;	
//						
						
						head = 1;
					} else {
						head = 0;
					}
					
				}
			}
				
				

			sb.append('#').append(tc).append(" ").append(count).append("\n");
				
			}
			

		System.out.println(sb);				
			
		}

}
