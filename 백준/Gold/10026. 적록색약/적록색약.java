import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.

class Point {

    int r, c;


    public Point(int r, int c) {
        this.r = r;
        this.c = c;

    }

}

public class Main {

    static int [][]  dir =  {{0,1},{0,-1},{1,0},{-1,0},};
    static int N;
    static String [][] map;
    static int non=0;
    static int on=0;
    static boolean visited [][];
    public static void main(String[] args) throws  Exception{

        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();


        N = Integer.parseInt(br.readLine());

        Deque<Point > deque = new ArrayDeque<>();
        map = new String[N][N];
        visited =  new boolean[N][N];

        for(int i=0;i<N;i++){
            String [] line = br.readLine().split("");
            map[i] = line;


        }

//        for(String[] s: map){
//            System.out.println(Arrays.toString(s));
//
//        }

        //--- 이 두 줄을 추가해서 직접 확인해 보세요 ---
//        System.out.println("첫 번째 줄의 실제 길이: " + map[0].length);
//        System.out.println("map[0][0]의 실제 값: '" + map[0][0] + "'");




        for (int i=0;i<N;i++){

            for(int j=0;j<N;j++){

                if (visited[i][j] == false){
                    deque.offer(new Point(i,j));
                    non+=1;

                }


                while(!deque.isEmpty()){
                    Point p = deque.poll();


                    int x = p.r;
                    int y = p.c;
                    String targetColor = map[x][y];
//                    System.out.printf("x = %d y= %d %n",x,y);



                    for(int [] d: dir){
                        int nx = x +d[0];
                        int ny = y + d[1];

                        if (nx<0 || nx >=N || ny<0 || ny>=N){
                            continue;
                        }

                        if (visited[nx][ny] == true || !(map[nx][ny].equals(targetColor)) ){
                            continue;
                        }
                        visited[nx][ny] = true;
                        deque.offer(new Point(nx,ny));
                    }

                }


            }
        }

        System.out.print(non+" ");

        visited =  new boolean[N][N];
        for (int i=0;i<N;i++){

            for(int j=0;j<N;j++){

                if (visited[i][j] == false){
                    deque.offer(new Point(i,j));
                    on+=1;

                }


                while(!deque.isEmpty()){
                    Point p = deque.poll();


                    int x = p.r;
                    int y = p.c;
                    String targetColor = map[x][y];
                    boolean flag =false;

                    if ("R".equals(targetColor) || "G".equals(targetColor) ){
                        flag = true;

                    }
//                    System.out.printf("x = %d y= %d %n",x,y);



                    for(int [] d: dir){
                        int nx = x +d[0];
                        int ny = y + d[1];

                        if (nx<0 || nx >=N || ny<0 || ny>=N){
                            continue;
                        }

                        if (visited[nx][ny] == true ){
                            continue;
                        }

                        if (flag){
                            if ("B".equals(map[nx][ny])) continue;
                        } else{
                            if (!("B".equals(map[nx][ny]))) continue;
                        }
                        visited[nx][ny] = true;

                        deque.offer(new Point(nx,ny));
                    }

                }


            }
        }

        System.out.print(on);

        //TIP 캐럿을 강조 표시된 텍스트에 놓고 <shortcut actionId="ShowIntentionActions"/>을(를) 누르면
        // IntelliJ IDEA이(가) 수정을 제안하는 것을 확인할 수 있습니다.



    }
}