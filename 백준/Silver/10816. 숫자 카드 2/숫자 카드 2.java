import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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
		
		// 개수를 담을 배열
		int [] answer = new int [M];
		
		// 중복된게 여러개있음으로 가장먼저 해당숫자가 나오는 위치 s와 target보다큰 수가 처음 나오는 e구하기
		for (int i = 0; i < ordersArr.length; i++) {
			
			int start = 0;
			int end = N-1;
			int target = ordersArr[i];
			
			
			//값이하인경우 계속진행하다 처음으로 자기보다 큰수에서 막힘.
			int upperBound= N;
			
			while (start <= end) {
				
				int mid = (start+end)/ 2;
				int currentValue = numbersArr[mid];
				
				// target보다 처음으로 큰수나오는 index
				if(currentValue <= target) {
					start  = mid +1;
				} else {
					upperBound = mid;
					end = mid - 1;
				}
				

					
				
			}
			
			
			int lowerBound= -1;
			start = 0;
			end = N-1;
			while (start <= end) {
				
				int mid = (start+end)/ 2;
				int currentValue = numbersArr[mid];
				
				// target보다 처음으로 큰수나오는 index
				if(currentValue < target) {
					start  = mid +1;
				} else {
			        lowerBound = mid;
			        end = mid - 1;
				}

					
				
			}
			
			
			
			if (lowerBound != -1 ) {
				answer[i] = upperBound - lowerBound;

			}
			
			
			
			
		}
 
		sb.append(answer[0]);
		for (int j = 1; j < answer.length; j++) {
			sb.append(" ").append(answer[j]);
			
		}

		System.out.println(sb);


	}
	






}





