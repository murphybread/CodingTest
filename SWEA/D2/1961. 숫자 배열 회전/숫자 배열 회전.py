import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int test_case =1 ;  test_case <=T;test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			
           int[][] a = new int[N][N];
           
           
            
            for (int i = 0; i < N; i++) {
            	StringTokenizer  st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int first90[][] =rotate(a);
            int second180[][] =rotate(first90);
            int third270[][] =rotate(second180);
            
            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(first90[i][j]);
                }
                System.out.print(" ");

                for (int j = 0; j < N; j++) {
                    System.out.print(second180[i][j]);
                }
                System.out.print(" ");

                for (int j = 0; j < N; j++) {
                    System.out.print(third270[i][j]);
                }
                // 한 줄이 모두 완성되면 줄바꿈
                System.out.println();
            }
        }		
		
		

		

		
		
		
		

	}
	
	public static int[][] rotate(int[][] arr) {
		
	    int N = arr.length;
	    int[][] rotated = new int[N][N]; 
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	            rotated[i][j] = arr[N - 1 - j][i];
	        }
	    }

	    return rotated; // 결과 배열을 반환
		
		
	}

}
