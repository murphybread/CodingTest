import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();


		
		//수가 얼마 안되니 M버 이진탐색으로 시도 .
		
		int  N =  Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int [] numbersArr = new int [N];
		for (int i = 0; i < N; i++) {
			numbersArr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		int  M =  Integer.parseInt(br.readLine());
		int [] ordersArr = new int [M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			ordersArr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		
		// 이진탐색을 위한 오름차순 정렬수행
		Arrays.sort(numbersArr);
		for (int i = 0; i < ordersArr.length; i++) {
			
			int start =0;
			int end = N-1;
			int target = ordersArr[i];
			
			boolean flag = false;
			while (start <= end) {
				
				int mid = (start+end)/ 2;
				int currentValue = numbersArr[mid];
				
				if(currentValue == target) {
					flag =true;
					break;
				}
				
				if(currentValue < target) {
					start = mid+1;
				} else {
					end = mid-1;
				}
					
				
			}
			if (flag) {
				sb.append(1).append("\n");

			} else {
				sb.append(0).append("\n");
			}
			
			
		}
 
		

		System.out.println(sb);


	}
	






}





