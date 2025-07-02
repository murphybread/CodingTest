import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException { // BufferedReader/Writer는 예외 처리가 필요합니다.

        // 1. 빠른 입력을 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2. 빠른 출력을 위한 BufferedWriter 객체 생성
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 3. br.readLine()으로 한 줄("1 2")을 통째로 읽어옴
        //    StringTokenizer로 공백을 기준으로 문자열을 분리
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 4. st.nextToken()으로 분리된 문자열을 하나씩 꺼내고,
        //    Integer.parseInt()로 숫자로 변환
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 5. 계산 결과를 문자열로 변환하여 BufferedWriter에 쓰기
        bw.write(String.valueOf(A + B));
        
        // 6. 버퍼에 남아있는 모든 내용을 출력
        bw.flush();

        // 7. 사용이 끝난 스트림들을 닫아줌
        bw.close();
        br.close();
    }
}