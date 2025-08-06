import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {


	static int ROUND =9;
	static int T;
	static int [] arr;
	static int [] op;
	static boolean []visited;
	static int [] temp;
	static int win =0;
	static int lose =0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;


		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());



		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			arr =new int[ROUND];
			op =new int[ROUND];

			visited=  new boolean[ROUND];
			temp = new int[ROUND];

			for(int i=0;i<ROUND;i++) {
				arr[i] = Integer.parseInt(st.nextToken());

			}

			int j =0;


			for(int num =1;num<=ROUND*2;num++) {

				boolean flag = true;
				for (int a: arr) {

					if (a == num) {
						flag=false;

					}

				}
				if(!flag) {
					continue;
				}


				op[j++]= num;


			}
			
			
			makePermutation(0);




			sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
//			System.out.println(win + " " + lose);
			win =0;
			lose =0;


		}
		System.out.println(sb);




	}




	static void makePermutation(int depth) {
		if (depth == 9) {

			calculate(temp); // 이 순서로 규영이와 승부 계산
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = op[i];  // 한 장씩 선택
				makePermutation(depth + 1);   // 다음 자리 선택
				visited[i] = false;           // 백트래킹
			}
		}
	}

	static void calculate(int[] temp) {
		int aSum = 0;
		int bSum = 0;
		for(int i=0;i<ROUND;i++) {

			if(arr[i]>temp[i]) {
				aSum+= arr[i] + temp[i];
			} else if (temp[i] > arr[i]) {
				bSum+= arr[i] + temp[i];
			}

		}

		if (aSum > bSum) {
			win +=1;
		} else if (bSum>aSum) {
			lose +=1;
		}
	}
}