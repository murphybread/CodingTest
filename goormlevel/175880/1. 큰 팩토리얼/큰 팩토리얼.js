// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });

	let N = 0
	const MOD  = 1_000_000_007n
	for await (const line of rl) {
		N = Number(line)
		
	}
	let answer = 1n
	for (let i =1n; i<=N; i++){
		answer =  (answer * i) % MOD;
	}
	

	console.log(answer.toString());

	
	process.exit();
})();
