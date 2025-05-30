// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });

	let N = 0
	for await (const line of rl) {
		N = Number(line)
	}

	const arr = Array.from({length: N} , ()=>Array(N).fill(0))
	// console.log(arr)
	let value = 1
	for (let i =0 ; i<N;i++){
		for (let j =0;j<N;j++){
			arr[i][j] = value
			value+=1
		}
	}

	for (let i =0 ; i<N;i++){
		console.log(...arr[i])
	}
	
	
	
	
	process.exit();
})();
