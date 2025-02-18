const input = require('fs').readFileSync("/dev/stdin").toString().split("\n")


const n = Number(input[0])
const stairs = input.slice(1,n+1).map(el=>Number(el))


stairs.unshift(0)
const dp = Array(n+1).fill(0)

dp[0] = 0 
dp[1] = stairs[1]
if (n >=2){
    dp[2] = Math.max(stairs[2], dp[1]+stairs[2])

    for (i = 3 ; i <= n ; i ++){
        dp[i] = Math.max(
        dp[i-2] + stairs[i],
        dp[i-3] + stairs[i-1] + stairs[i]
        )
    }
    
}

console.log(dp[n]);