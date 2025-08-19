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


	static int [][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
	static int N,K;
	static int [][] map;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			 N = Integer.parseInt(st.nextToken());
			 K = Integer.parseInt(st.nextToken());
			 
			 count = 0;
			
			map =new int [N][N];
			
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			
			int high = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					high = Math.max(high, map[i][j]);
					
				}
			}
			
			
			ArrayList<int []> pos = new ArrayList<int[]>();
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					
					if (map[i][j] == high) {
						pos.add(new int [] {i,j});
					}
				}
			}
			
			
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					
					int before = map[i][j];
					
					for (int k = 1; k <= K; k++) {
						map[i][j] = before - k;
						
						for (int[] ls : pos) {
							int x = ls[0];
							int y = ls[1];
							dfs(x,y,1);
							
						}
						
					}
					
					
					map[i][j] = before;
				}
			}
			
			
			
			sb.append(count).append("\n");

			 
			 
			
		}
		
			
		

		System.out.println(sb);
			
		}
	
		static void dfs (int i, int j,int current) {
			
			int v = map[i][j];
			
			
			for (int[] d : dir) {
				
				int nx = i+ d[0];
				int ny = j+ d[1];
				
				
				if(nx <0 || nx >=N || ny<0 || ny>=N) continue;
				
				if (map[nx][ny] >= v) continue;
				
				dfs(nx,ny,current+1);
				
			}
			
			count = Math.max(count, current);
			
			
			
			
		
		}
		
		





	}
	






