import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;



class Solution
{
    
    
    static int [][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; //상 하 좌 우
    static int N,M,K;
    public static void main(String args[]) throws Exception
    {
       //  System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        StringTokenizer st;
        
        int T=  Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++)
        {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            
            // N*N 배열
            
            // 외각 -1, 빈칸 0 , 미샐물있으면 해당 번호위치
            
            int [][] map =new int [N][N];
            
            //빈칸처리
            for (int i = 1; i < N-1; i++) {
                Arrays.fill(map[i], 0);
                
            }
            
            // 상하 약품처리 처리
            Arrays.fill(map[0], -1);
            Arrays.fill(map[N-1], -1);

            //좌우 약품처리
            for (int j = 0; j < N; j++) {
                map[j][0] = -1;
                
            }

            for (int j = 0; j < N; j++) {
                map[j][N-1] = -1;
                
            }

            
            
            int [][] micro = new int [K][4]; // 원소 [ x,y,미생물무리의 수, 현재방향]
            for (int i = 0; i < K; i++) {    
                st = new StringTokenizer(br.readLine());
                
                int x = Integer.parseInt(st.nextToken()); 
                int y = Integer.parseInt(st.nextToken()); 
                int num = Integer.parseInt(st.nextToken()); 
                int dir = Integer.parseInt(st.nextToken()) -1;
                
                micro[i][0] = x;
                micro[i][1] = y;
                micro[i][2] = num;
                micro[i][3] = dir;
                
            }
            
            
            // 기본적인 배열생성 및, 약품처리 및, 미생물 초기위치 설정완료
            
            // M번수행
            // 격리 시간 M은 1이상 1,000이하의 정수이다. (1 ≤ M ≤ 1,000)
            for (int time = 0; time < M; time++) {
                // 미생물 움직이기
                // K는 5이상 1,000이하의 정수이다. (5 ≤ K ≤ 1,000)
                
                for (int i = 0; i <K; i++) {
                	
                    if (micro[i][2] == 0) {
                        continue;
                    }
                    int d = micro[i][3];
                    micro[i][0] += dir[d][0];
                    micro[i][1] += dir[d][1];
                    
                    // 약품이 칠해진 셀에 도착한 경우
                    if (isBorder(micro[i][0], micro[i][1])) {
                        micro[i][2] /= 2; // 미생물 수 절반으로 감소

                        // 이동 방향 반대로 변경
                        if (d == 0) micro[i][3] = 1;
                        else if (d == 1) micro[i][3] = 0;
                        else if (d == 2) micro[i][3] = 3;
                        else if (d == 3) micro[i][3] = 2;
                    }
                    
                }
                
                HashMap<Integer, List<Integer>> positionMap = new HashMap<>();
                
                
                // 미생물위치를 중복없는키값으로 변환후 미생물 번호 업데이트
                for (int i = 0; i < K; i++) {
                    if (micro[i][2] > 0) {
                        int hashKey = micro[i][0] * N + micro[i][1];
                        positionMap.computeIfAbsent(hashKey, key -> new ArrayList<>()).add(i);
                    }
                }                

                
                // 움직인 이후 무리가 합치기 가능하다면 합치기, 단 3개이상 합칠 수 있는데 이떄 방향은 최대값으로
                // <충돌난위치 ,ArrayList<충돌난 벌레번호들>>
                for (List<Integer> microList : positionMap.values()) {
                    // 한 위치에 2개 이상의 군집이 모인 경우에만 합병
                    if (microList.size() > 1) {
                        int totalMicrobes = 0;
                        int maxMicrobes = 0;
                        int maxIdx = -1; // 미생물 수가 가장 많았던 군집의 인덱스
                        int newDir = -1;

                        // 모인 군집들 중 가장 큰 군집을 찾고, 미생물 총합을 계산
                        for (int idx : microList) {
                            totalMicrobes += micro[idx][2];
                            if (micro[idx][2] > maxMicrobes) {
                                maxMicrobes = micro[idx][2];
                                maxIdx = idx;
                                newDir = micro[idx][3];
                            }
                        }

                        // 가장 컸던 군집(maxIdx)을 제외한 나머지 군집들은 소멸 처리
                        for (int idx : microList) {
                            if (idx != maxIdx) {
                                micro[idx][2] = 0;
                            }
                        }

                        // 가장 컸던 군집의 정보를 합쳐진 결과로 갱신
                        micro[maxIdx][2] = totalMicrobes;
                        micro[maxIdx][3] = newDir;
                    }
                }
                
                
                
            }
            
            
        
            sb.append(getSum(micro)).append("\n");


        }
        
        System.out.println(sb);
    }
    
    
    static boolean isBorder(int x, int y) {
            if(x == 0 || x == N-1 ||y ==0 || y==N-1) return true;
            
            return false;
            
        }
    
    
    
    static int getSum(int [][] micro) {
        int count=0;
        for (int[] bug : micro) {
            
            int num = bug[2] ;
            count +=num ;
                    
            
        }
        return count;
        
        
    }
}
