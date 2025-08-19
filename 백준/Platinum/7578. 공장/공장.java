import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static class SegmentTree {
        int[] tree;
        int n;
        
        public SegmentTree(int size) {
            this.n = size;
            tree = new int[4 * n];  // 4N 크기
        }
        
        // 업데이트: idx 위치에 value만큼 추가
        public void update(int node, int start, int end, int idx, int value) {
            if (start == end) {
                // 리프노드: 값 추가
                tree[node] += value;
            } else {
                int mid = (start + end) / 2;
                if (idx <= mid) {
                    update(2 * node, start, mid, idx, value);
                } else {
                    update(2 * node + 1, mid + 1, end, idx, value);
                }
                // 부모노드 업데이트
                tree[node] = tree[2 * node] + tree[2 * node + 1];
            }
        }
        
        // 쿼리: [left, right] 구간 합 구하기
        public int query(int node, int start, int end, int left, int right) {
            if (right < start || end < left) {
                return 0;  // 범위 밖
            }
            if (left <= start && end <= right) {
                return tree[node];  // 완전 포함
            }
            
            int mid = (start + end) / 2;
            return query(2 * node, start, mid, left, right) + 
                   query(2 * node + 1, mid + 1, end, left, right);
        }
        
        // 편의 메소드
        public void update(int idx, int value) {
            update(1, 0, n - 1, idx, value);
        }
        
        public int query(int left, int right) {
            if (left > right) return 0;
            return query(1, 0, n - 1, left, right);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // A열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // B열 입력
        st = new StringTokenizer(br.readLine());
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        // A의 각 값이 B에서 몇 번째 위치에 있는지 매핑
        Map<Integer, Integer> positionInB = new HashMap<>();
        for (int i = 0; i < N; i++) {
            positionInB.put(B[i], i);
        }
        
        // A를 B에서의 위치로 변환
        int[] transformedA = new int[N];
        for (int i = 0; i < N; i++) {
            transformedA[i] = positionInB.get(A[i]);
        }
        
        // 세그먼트 트리 생성 (0~N-1 범위)
        SegmentTree segTree = new SegmentTree(N);
        
        long answer = 0;
        
        // Inversion Counting
        for (int i = 0; i < N; i++) {
            // transformedA[i]보다 큰 값들이 이미 몇 개 나왔는지 쿼리
            int inversions = segTree.query(transformedA[i] + 1, N - 1);
            answer += inversions;
            
            // 현재 값을 트리에 추가 (등장횟수 1 증가)
            segTree.update(transformedA[i], 1);
        }
        
        System.out.println(answer);
    }
}