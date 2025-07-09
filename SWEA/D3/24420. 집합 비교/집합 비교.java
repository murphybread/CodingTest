import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int test_case =1 ;  test_case <=T;test_case++) {
			StringTokenizer  st = new StringTokenizer(br.readLine());
			char result ;
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
           int[] a = new int[N];
           st = new StringTokenizer(br.readLine()); 
           
           for (int i=0;i<N;i++) {
        	   a[i] = Integer.parseInt(st.nextToken());
           }
           
           int[] b = new int[M];
           
           st = new StringTokenizer(br.readLine());

           
           for (int i=0;i<M;i++) {
        	   b[i] = Integer.parseInt(st.nextToken());
           }
           

           
           
           Set<Integer> aSet = new HashSet<>();
           Set<Integer> bSet = new HashSet<>();
           
           
           for (int number : a) {
            
               aSet.add(number);
           }
           
           for (int number : b) {
               
               bSet.add(number);
           }
           
           
           if (aSet.equals(bSet)) {
        	   result = '=';
           } else if (aSet.containsAll(bSet)) {
        	   result = '>';
        	   
           } else if (bSet.containsAll(aSet)) {
        	   result = '<';
        	   
           } else {
        	   result = '?';
           }
           
           
           sb.append(result).append("\n");
           
           
        }		
		
		System.out.println(sb);
		
		

		

		
		
		
		

	}
	


}
