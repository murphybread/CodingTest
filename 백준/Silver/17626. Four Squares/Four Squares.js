const input = require("fs").readFileSync("/dev/stdin").toString()

const n = Number(input)
const dp =  new Array(50001).fill(4);
dp[0] = 0 

// 제곱수는 1개로 표현 가능
for(let i = 1; i * i <= 50000; i++) {
    dp[i * i] = 1;
}

// dp 계산
for(let i = 1; i <= n; i++) {
    for(let j = 1; j * j <= i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
    }
}

console.log(dp[n]);