import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	
	static int [][] map;
	static int white =0, green=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
      //System.setIn(new FileInputStream("input.txt"));
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      StringTokenizer st;	
      
      
      int N =  Integer.parseInt(br.readLine());
      
 
      map = new int[N][N];
      for (int i = 0; i < N; i++) {
    	  char [] input =   br.readLine().toCharArray();
    	  
    	  for (int j = 0; j < N; j++) {
    		  map[i][j] =  input[j]  - '0';
			
		}
		
	}
      
      
      // static으로 하얀색과 파란생 영역의 숫자를 저장 static int blue, static int white


      System.out.println(devideSquare(0,0,N));
      // sb ( part1 + part2 + part3 + part4 )
	}
	
    // N이 작은 만큼 배열에 완전탐색
    

	
	static String devideSquare (int r, int c, int size) {
		StringBuilder resultAll = new StringBuilder();
		
		int blackBlock= 0, whiteBlock = 0;
		
		


		for (int i = r; i <  r +size; i++) {
			for (int j = c; j < c +size; j++) {
				if (map[i][j] == 0) {
					blackBlock +=1;
				} else {
					whiteBlock +=1;
				}
				
			}
		}
		
		if( (whiteBlock == 0 ||  blackBlock == 0) ) {
			
			if(whiteBlock > blackBlock) {
				return "1";
			}else{
				return "0";
			
			}



			
		} else {

			resultAll.append("(");
			int halfSize = size/ 2;
			String first = devideSquare(r,c,halfSize);
			String second = devideSquare(r,c+halfSize,halfSize);
			String third = devideSquare(r+halfSize,c,halfSize);
			String fourth =devideSquare(r+halfSize,c+halfSize,halfSize);
			
			resultAll.append(first).append(second).append(third).append(fourth);
			
			resultAll.append(")");
			
			return resultAll.toString();
		}
		

		
	}

}
