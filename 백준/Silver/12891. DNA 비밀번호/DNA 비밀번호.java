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

    static int N, P;
    static ArrayList<Integer>[] graph;
    static int[] atgc = new int[4];
    static int count = 0;
    static char[] dnaInput;
    
    // 전역 변수로 현재 윈도우의 문자 개수 추적
    static int A = 0, C = 0, G = 0, T = 0;
    
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = 0;

        StringBuilder sIn = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        dnaInput = new char[N];

        for (int i = 0; i < N; i++) {
            dnaInput[i] = s.charAt(i);
        }

        st = new StringTokenizer(br.readLine());
        atgc[0] = Integer.parseInt(st.nextToken());
        atgc[1] = Integer.parseInt(st.nextToken());
        atgc[2] = Integer.parseInt(st.nextToken());
        atgc[3] = Integer.parseInt(st.nextToken());

        // 첫 번째 윈도우 (0 ~ P-1) 초기화
        for (int i = 0; i < P; i++) {
            addChar(dnaInput[i]);
        }
        checkCurrentWindow(); // 첫 번째 윈도우 체크

        // 슬라이딩 윈도우 (P ~ N-1)
        for (int i = P; i < N; i++) {
            removeChar(dnaInput[i - P]); // 왼쪽 끝 문자 제거
            addChar(dnaInput[i]);        // 오른쪽 끝 문자 추가
            checkCurrentWindow();        // 현재 윈도우 체크
        }

        System.out.println(count);
    }

    // 문자를 윈도우에 추가
    static void addChar(char c) {
        if (c == 'A') A++;
        else if (c == 'C') C++;
        else if (c == 'G') G++;
        else if (c == 'T') T++;
    }

    // 문자를 윈도우에서 제거
    static void removeChar(char c) {
        if (c == 'A') A--;
        else if (c == 'C') C--;
        else if (c == 'G') G--;
        else if (c == 'T') T--;
    }

    // 현재 윈도우가 조건을 만족하는지 체크 (기존 checkPassword 로직 활용)
    static void checkCurrentWindow() {
        if (A >= atgc[0] && C >= atgc[1] && G >= atgc[2] && T >= atgc[3]) {
            count++;
        }
    }
}