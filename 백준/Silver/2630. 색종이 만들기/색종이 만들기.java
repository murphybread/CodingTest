import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	static int [][] map;
	static int white =0, green=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      StringTokenizer st;	
      
      
      int N =  Integer.parseInt(br.readLine());
      
 
      map = new int[N][N];
      for (int i = 0; i < N; i++) {
    	  st=  new StringTokenizer(br.readLine());
    	  
    	  for (int j = 0; j < N; j++) {
    		  map[i][j] =  Integer.parseInt(st.nextToken());
			
		}
		
	}
      devideSquare(0,0,N);
      
      // static으로 하얀색과 파란생 영역의 숫자를 저장 static int blue, static int white

      
      System.out.println(white);
      System.out.println(green);
	}
	
    // N이 작은 만큼 배열에 완전탐색
    
    // 4등분의 경우 (int r, int c, int size)의 함수를 분할정복
    // 조건은 0과 1을 전부세서 만약 개수가 다르다면 다음의 분할정복 4개 수행
    	// (r , c , halfSzie)   halfSzie
	      // (r + halfSzie , c  , halfSzie)
	      // (r , c +halfSzie , halfSzie)
	      // (r+ halfSzie , c +halfSzie , halfSzie)
	
	static void devideSquare (int r, int c, int size) {
		int whiteBlock = 0, greenBlock = 0;
		


		for (int i = r; i <  r +size; i++) {
			for (int j = c; j < c +size; j++) {
				if (map[i][j] == 0) {
					whiteBlock +=1;
				} else {
					greenBlock +=1;
				}
				
			}
		}
		
		if( (whiteBlock == 0 ||  greenBlock == 0) ) {
			if(whiteBlock > greenBlock) {
				white +=1;
			}else{
				green +=1;
			
			}



			
		} else {

			int halfSize = size/ 2;
			devideSquare(r,c,halfSize);
			devideSquare(r,c+halfSize,halfSize);
			devideSquare(r+halfSize,c,halfSize);
			devideSquare(r+halfSize,c+halfSize,halfSize);
		}
		

		
	}

}
