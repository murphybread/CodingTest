import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] trees = new int[N];
            int max = 0;

            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, trees[i]);
            }

            int need1 = 0; 
            int need2 = 0; 

            for (int i = 0; i < N; i++) {
                int diff = max - trees[i];
                if (diff > 0) {
                    need2 += diff / 2;
                    need1 += diff % 2;
                }
            }
            
            while (need2 - need1 > 1) {
                need2--;
                need1 += 2;
            }

            long day = 0;
            if (need1 > need2) {
                day = (long)need1 * 2 - 1;
            } else { // need2 == need1 이거나 need2 == need1 + 1 인 경우
                day = (long)need2 * 2;
            }
            
            sb.append(day).append("\n");
        }
        System.out.println(sb);
    }
}