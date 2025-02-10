function solution(x, y, n) {
    // dp[i] = x에서 i를 만들기 위한 최소 연산 횟수
    const dp = new Array(y + 1).fill(Infinity);
    dp[x] = 0;
    
    for (let i = x; i <= y; i++) {
        if (dp[i] === Infinity) continue;
        
        // n을 더하는 경우
        if (i + n <= y) {
            dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
        }
        
        // 2를 곱하는 경우
        if (i * 2 <= y) {
            dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
        }
        
        // 3을 곱하는 경우
        if (i * 3 <= y) {
            dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
        }
    }
    
    return dp[y] === Infinity ? -1 : dp[y];
}