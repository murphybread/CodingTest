// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });

	const lines = []
	for await (const line of rl) {
		
		if (lines.length > 0 ){
			lines.push(line.split(" ").map(Number))
		} else {
		lines.push(line)	
		}
		
	}

		const N = Number(lines[0])
		const arr = lines[1]
		// console.log(arr)
		let answer = 0
		for (let i =0 ; i<N ;i++){
			let sub = 0
			sub += arr[i]
			current = arr[i]
			for (let j= i+1;j<N;j++){
				if( arr[j]-current === 1){
					current = arr[j]
					sub += arr[j]
				} else {
					break
				}
			}

				
			
			// console.log(i, sub)
			answer = Math.max(answer , sub)
		}

	console.log(answer)
	process.exit();
})();



