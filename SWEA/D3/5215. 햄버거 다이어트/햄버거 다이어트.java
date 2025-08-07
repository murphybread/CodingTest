import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

	static int N,K,M ;
	static int T;
	static ArrayList<int []> recipe = new ArrayList<int[]>(); // 모든 조합을 총 맛과 칼로리형태로저장 저장
	static ArrayList<Integer> [] temp;
	
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		


		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int high =0; //각 케이스 최고점수
			st = new StringTokenizer(br.readLine());
			recipe.clear();
			
			// 현재 맛, 칼로리 조합정보저장
			ArrayList<int []> menu = new ArrayList<int[]>();
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			//N번 맛 칼로리 쌍 입력받기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int score = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());
				
				menu.add(new int[] {score,cal});
				
				
				
				
			}
			
			// 단순하게 NCR을 R을 1부터 N까지 수행하기
			for (int i = 0; i <= N; i++) {
				int []  base = new int [] {0,0};
				

				comb(0,0,base,i,menu);

			
				
				
			}
			
			for (int [] r: recipe) {
				
				if(r[1]<=K) {
					high = Math.max(r[0], high);
				}
				
			}
			

			
			sb.append(high).append("\n");
			
			
			
		}
		
		

		System.out.println(sb);





	}
	
	
	// 혀cnt 현재 개수, start 시도할 시작 수, end몇개까지넣을지
	static void comb (int cnt, int start,int [] current, int end,ArrayList<int []> menu ) {
//		System.out.printf("cnt : %d %n",cnt);
		if(cnt == end) {
//			System.out.printf("current %s", Arrays.toString(current));

			recipe.add(new int[]{current[0], current[1]});
			return;
		}
		
		for (int i = start; i < N; i++) {
			
//			System.out.printf("menu.get(i)[0] : %d  menu.get(i)[1] %d %n",menu.get(i)[0],menu.get(i)[1]);

			current[0] += menu.get(i)[0];
			current[1] += menu.get(i)[1];
			
			comb(cnt+1,  i+1,current,end,menu);
			
	        // 백트래킹
	        current[0] -= menu.get(i)[0]; //  상태 복원
	        current[1] -= menu.get(i)[1];
			
			
			
			
		}
	}
	





}