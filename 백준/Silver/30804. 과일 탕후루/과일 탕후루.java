import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main  {

	public static void main(String[] args) throws Exception {
		
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N  = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] arr   = new int[N];
		 
		
		for (int i =0 ; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left= 0; 
		
		int kindCount = 0;
		int maxLength = 0;
		
		int [] kindFruits = new int[10];
		
		for (int right=0; right<N;right++) {
			int currentFruit = arr[right];
			
			
			if (kindFruits[currentFruit] == 0) {
				kindCount++;
				
			}
			kindFruits[currentFruit]++;
			
			while (kindCount >2) {
				
				int leftFruit = arr[left];
				kindFruits[leftFruit]--;
				
				if (kindFruits[leftFruit] == 0) {
	                kindCount--;
	            }
	            
	            left++;
			}
            
            maxLength = Math.max(maxLength, right - left + 1);
			
			
			
		}
		
		
		
		
		System.out.println(maxLength);
		
		// TODO Auto-generated method stub

	}

}
