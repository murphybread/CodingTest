

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

	static int N,M;
	static int INF = 1_000_000_000;



	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		N = Integer.parseInt( br.readLine());
		M = Integer.parseInt( br.readLine());
		StringBuilder sb =new StringBuilder();
		
		
		//다익스트라
		
		
		
		//단 A점에서 B점까지 가능 경로와 코스트를 반환하기
		
		

		
		ArrayDeque<int []> []  adj = new ArrayDeque[N+1];
		
		for (int i=0;i<N+1;i++) {
			adj[i] = new ArrayDeque<>(); 
		}
		
		// adj는 그대로 adj[u].add(new int [] {v,c})
		
		
		for (int i =0 ; i<M;i++) {
			
			String [] input = br.readLine().split(" "); 
			
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			int cost = Integer.parseInt(input[2]);
			
			
			adj[from].add(new int [] {to, cost});
			
		}

		
		// 마지막 A B 입력받기
		String [] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		
		
		// 기존의 dist구조 A에서 모든 노드로 가기위한 최소비용 배열 + 추가로 해당 경로를 가기위한 노드경로 배열따로
		int[] dist = new int[N+1];
		int[] parent = new int[N + 1];
		
		Arrays.fill(dist, INF);
		dist[A] = 0;
		
		PriorityQueue<int []> queue =new PriorityQueue<>((a,b) -> a[1]-b[1]);
		queue.add(new int []{A,0});
		 
		// dist[1][] = {{0}, {1,0}, {1 ... 2,cost} , {1 ... 3 , cost}}
		// 이런 dist의모음 allDist [dist[][]]  =
	
		
				
		while(!queue.isEmpty()) {
			int [] current = queue.poll();
			
			int nextNode =current[0];
			int nextCost =current[1];
			
			if (dist[nextNode] < nextCost ) {
				continue;
			}
			
			for ( int []  next : adj[nextNode]) {
				
				if ( next[1]+ nextCost < dist[next[0]]) {
					
					dist[next[0]] = next[1]+ nextCost ;
					parent[next[0]] = nextNode; 
					queue.add(new int [] {next[0], dist[next[0]]});
				}
				
			}
			
			
		}
		
		ArrayDeque<Integer> path = new ArrayDeque<>(N+1);
		path.add(B);
		int checkNode = parent[B];
		while(checkNode != A) {
			path.add(checkNode);
			checkNode= parent[checkNode];
			
		}
		path.add(A);
		
		
		
		System.out.println(dist[B]);
		System.out.println(path.size());
		
		while (!path.isEmpty()) {
		    sb.append(path.pollLast()).append(" ");
		}

		System.out.println(sb);
		


		//계속움직이기에 어떻게든 시간안에 끝남




	}



}
