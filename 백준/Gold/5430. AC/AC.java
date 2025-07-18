import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        // 테스트를 위해 파일 입력을 사용합니다. 실제 제출 시에는 이 줄을 주석 처리하거나 삭제해야 합니다.
         /// System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        // 최종 정답을 한번에 출력하기 위한 StringBuilder
        StringBuilder finalAnswer = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            char[] orders = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String arrString = br.readLine();

            // LinkedList보다 Deque 연산에 더 효율적인 ArrayDeque 사용을 권장합니다.
            Deque<Integer> deque = new ArrayDeque<>();

            // 문제점 2 해결: n > 0 일 때만 파싱을 진행합니다.
            if (n > 0) {
                String[] nums = arrString.substring(1, arrString.length() - 1).split(",");
                for (String s : nums) {
                    deque.add(Integer.parseInt(s));
                }
            }

            // 문제점 1 해결: 방향 플래그 사용
            boolean isReversed = false;
            boolean errorFlag = false;

            for (char order : orders) {
                if (order == 'R') {
                    isReversed = !isReversed; // 방향만 전환 (O(1))
                } else { // order == 'D'
                    if (deque.isEmpty()) {
                        errorFlag = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast(); // 뒤집혔을 땐 뒤에서 제거
                    } else {
                        deque.pollFirst(); // 정방향일 땐 앞에서 제거
                    }
                }
            }

            if (errorFlag) {
                finalAnswer.append("error\n");
            } else {
                // 문제점 3 해결: StringBuilder로 출력 형식 직접 만들기
                finalAnswer.append("[");
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    if (isReversed) {
                        finalAnswer.append(deque.pollLast());
                    } else {
                        finalAnswer.append(deque.pollFirst());
                    }
                    // 마지막 요소가 아니라면 쉼표 추가
                    if (i < size - 1) {
                        finalAnswer.append(",");
                    }
                }
                finalAnswer.append("]\n");
            }
        }
        System.out.print(finalAnswer);
    }
}