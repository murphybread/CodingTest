// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });

	let N = 0
	let cnt = 0
	const moneys = [40,20,10,5,1]
	for await (const line of rl) {
		N = Number(line)
		
		
	}

	for (const charge of moneys){
		if (N<=0){
			break
		}
		cnt += Math.floor(N / charge);
		N = N %charge
		
	}
	console.log(cnt)

	
	// console.log(N)
	
	
	process.exit();
})();
