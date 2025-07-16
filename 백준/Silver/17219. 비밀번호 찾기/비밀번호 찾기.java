
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static String [] orders;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()) ;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> hash = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()) ;
			String id = st.nextToken();
			String pw = st.nextToken();
			hash.put(id,pw);
		}
		
		orders =new String [M];
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()) ;
			orders[i] = st.nextToken();
			
		}
		
		for (int i=0;i<M;i++) {
			
			sb.append(hash.get(orders[i])+"\n");
		}
		
		System.out.println(sb);

		

	}

}
