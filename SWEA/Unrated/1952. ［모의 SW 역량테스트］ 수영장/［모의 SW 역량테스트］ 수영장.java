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


	
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc);
			int totalPrice = 0;
			
			int oneday, onemonth, threemonth, oneyear;
			
			st = new StringTokenizer(br.readLine());
			oneday = Integer.parseInt(st.nextToken());
			onemonth = Integer.parseInt(st.nextToken());
			threemonth = Integer.parseInt(st.nextToken());
			oneyear = Integer.parseInt(st.nextToken());
			
			
			int [] plan  = new int [13];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
				
			}
			
			
			// dp [1] 은 1월부터시작
			int [] dp = new int [13];
			for (int i = 1; i <= 12; i++) {
                // 1. 1일권 vs 1달권 중 현재 달에 대해 더 저렴한 비용 계산
                int currentMonthCost = Math.min(plan[i] * oneday, onemonth);
                
                // 이전 달까지의 최소 비용에 현재 달 비용을 더함
                dp[i] = dp[i - 1] + currentMonthCost;

                // 2. 3달 이용권을 사용하는 경우와 비교
                
                // 3. 최종적으로 이전달까지 최적화된 값에 일로 사는경우, 월로 사는경우, 3달전 최적값에서 3개월권 산경우
                if (i >= 3) {
                    dp[i] = Math.min(dp[i], dp[i - 3] + threemonth);
                }
				
			}
			
			dp[12] = Math.min(dp[12], oneyear);
			
			sb.append(" ").append(dp[12]).append("\n");
			
			
			
			
			
			
		}
		
		

		System.out.println(sb);



		// 1일 이용권 n개이사이면 1달이 이득 ->명확함
		
		//1달 3개보다 3개월이 더쌈 이득임 명확함.
		
		// 1일만 구매 vs 1달만 구매 vs 3달만 구매 vs 1년 구매 vs 3달 +1달 vs 3달 1일 vs 1달 1일


	}
	






}