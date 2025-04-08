function solution(n, q, ans) {
    // 결과를 저장할 변수
    let count = 0;
    
    // 조합 생성 함수
    function generateCombinations(arr, start, depth, combination) {
        if (depth === 5) {
            // 모든 시도에 대해 검증
            if (isValidCode(combination)) {
                count++;
            }
            return;
        }
        
        // 조합 생성
        for (let i = start; i <= n; i++) {
            combination[depth] = i;
            generateCombinations(arr, i + 1, depth + 1, combination);
        }
    }
    
    // 비밀 코드 검증 함수
    function isValidCode(code) {
        for (let i = 0; i < q.length; i++) {
            const attempt = q[i];
            const expected = ans[i];
            
            // 현재 시도와 코드 사이의 일치하는 숫자 개수 계산
            let matches = 0;
            for (let j = 0; j < attempt.length; j++) {
                if (code.includes(attempt[j])) {
                    matches++;
                }
            }
            
            // 일치하는 개수가 예상과 다르면 유효하지 않음
            if (matches !== expected) {
                return false;
            }
        }
        
        return true;
    }
    
    // 조합 생성 시작
    generateCombinations([], 1, 0, []);
    
    return count;
}