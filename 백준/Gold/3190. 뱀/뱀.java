

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	static int N;
	static int K;
	static int L;
	static ArrayList<int []> apples;
	static String [][] orders;
	static boolean [][] tracks;
	static ArrayDeque<int []> queue = new ArrayDeque<>();


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	//	System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		N = Integer.parseInt( br.readLine());
		K = Integer.parseInt( br.readLine());




		tracks = new boolean [N][N];

		int [][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

		apples = new ArrayList<>(K);

		for(int i=0;i<K;i++) {
			String [] line = br.readLine().split(" ");

			apples.add(new int[] {Integer.parseInt(line[0])-1,Integer.parseInt(line[1])-1});


		}

		L = Integer.parseInt( br.readLine());
		orders = new String[L][2];
		int orderIdx = 0;


		for(int i=0;i<L;i++) {
			String [] line = br.readLine().split(" ");

			orders[i] = line;
		}

		// 시작위치 00고정 시간 고정

		int time = 0;
		int currentDir = 0;
		

		//초기 머리
		queue.offerLast(new int[] {0,0});
		tracks[0][0]= true;




		while (!queue.isEmpty()) {
			int[] head = queue.peekLast();
			time +=1;


			int nextX = head[0] + dir[currentDir][0];
			int nextY = head[1] + dir[currentDir][1];

			// 벽부딪히면 끝
			if (nextX < 0 || nextX >=N || nextY < 0 || nextY >=N) {
				break;
			}

			// 자기 몸 부딪히면 끝
			if(tracks[nextX][nextY] == true) {
				break;
			}

			queue.offerLast(new int[] {nextX,nextY});
			tracks[nextX][nextY] = true;


			
			boolean ateApple= false ;
			for (int j =0;j<apples.size();j++) {
				int [] pos = apples.get(j);
				
				if (pos[0] == nextX && pos[1] == nextY) {
					apples.remove(j);
					ateApple = true;
					break;


					
				}
				
			}


			// 이동 후 사과인경우 그대로 유지, 사과가 아닌 경우 꼬리 한칸 옮기기.
			if (!ateApple) { 
			
				int [] moved = queue.pollFirst();
				tracks[moved[0]][moved[1]] = false;
				
			}

			//오른쪽 왼쪽 회전

//			showTrakc();


			if( orderIdx < L && Integer.parseInt(orders[orderIdx][0]) == time) {


				if ("D".equals(orders[orderIdx][1])) {
					currentDir  = (currentDir +1) % 4; 
				} else {
					currentDir  = (currentDir - 1 + 4) % 4;
				}
				orderIdx +=1;

			}








		}


		System.out.println(time);

		//계속움직이기에 어떻게든 시간안에 끝남




	}

	static void showTrakc() {
		for(int k=0;k<N;k++) {
			System.out.println(Arrays.toString(tracks[k]));

		}
	}

}
