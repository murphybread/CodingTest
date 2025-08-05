import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    // 위치의 최대값 상수
    static final int MAX_POS = 100000;

    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int k = Integer.parseInt(st.nextToken()); // 동생 위치

        // 각 위치까지의 최단 시간을 저장할 배열
        // -1은 아직 방문하지 않았음을 의미
        int[] dist = new int[MAX_POS + 1];
        Arrays.fill(dist, -1); // 모든 값을 -1로 초기화

        // 0-1 BFS를 위한 덱(Deque) 생성
        Deque<Integer> q = new ArrayDeque<>();

        // 시작점 설정
        dist[n] = 0;
        q.add(n); // 시작 위치를 덱에 추가

        while (!q.isEmpty()) {
            int currentPos = q.poll(); // 덱의 가장 앞에서 원소를 꺼냄
//            System.out.println("현재 확인하는 위치: " + currentPos + " / 남은 큐: " + q);

            // 동생 위치에 도착했다면 최단 시간이므로 출력 후 종료
            if (currentPos == k) {
                System.out.println(dist[currentPos]);
                return; // 프로그램 종료
            }

            // 1. 순간이동 (비용 0)
            int nextPos = currentPos * 2;
            if (nextPos >= 0 && nextPos <= MAX_POS && dist[nextPos] == -1) {
                dist[nextPos] = dist[currentPos]; // 시간은 그대로
                q.addFirst(nextPos); // 비용이 0이므로 덱의 맨 앞에 추가
            }

            // 2. 뒤로 걷기 (비용 1)
            nextPos = currentPos - 1;
            if (nextPos >= 0 && nextPos <= MAX_POS && dist[nextPos] == -1) {
                dist[nextPos] = dist[currentPos] + 1; // 1초 추가
                q.addLast(nextPos); // 비용이 1이므로 덱의 맨 뒤에 추가
            }

            // 3. 앞으로 걷기 (비용 1)
            nextPos = currentPos + 1;
            if (nextPos >= 0 && nextPos <= MAX_POS && dist[nextPos] == -1) {
                dist[nextPos] = dist[currentPos] + 1; // 1초 추가
                q.addLast(nextPos); // 비용이 1이므로 덱의 맨 뒤에 추가
            }
        }
    }
}