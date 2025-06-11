// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });

	let N =  0
	
	for await (const line of rl) {
		N = Number(line)
		
	}
	const dp = Array.from({ length: N+1 }, () => 0);
	// console.log(dp)
	dp[1] = 1
	dp[2] = 1
	dp[3] = 2
	
	const L =1_000_000_007
	for (let i =4; i<=N ;i++){
		dp[i] = (dp[i-1]+ dp[i-3])% L
	}
	
	
	console.log(dp[N])

	
	process.exit();
})();
