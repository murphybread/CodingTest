// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });


	
	
	let K = 0
	for await (const line of rl) {
		
		K =  Number(line)
		rl.close();
	}

	let dp = Array.from({length: K+1}, ()=>-1)
	// console.log(dp)
	const MOD = 1_000_000_007
	if (K >= 1) dp[1] = 0;   
  if (K >= 2) dp[2] = 1;   

  for (let i = 3; i <= K; i++) {
    dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
  }

	console.log(dp[K])

	process.exit();
})();
