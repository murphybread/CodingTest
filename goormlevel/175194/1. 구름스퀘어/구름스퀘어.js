// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });

	let lines = []
	for await (const line of rl) {
		lines.push(line)
		
	}

	let table =  lines.slice(1).map(line=>line.split(" ").map(Number))
	
	table.sort((a,b)=>a[1]-b[1])

	let cnt = 0
	let lastEnd = -1

	
	for (const event of table){
		let [s,e] = event
		if (s >= lastEnd+1){
			cnt += 1
			lastEnd = e
		}
		
		
	}

	// console.log(table)
	console.log(cnt)
		
		
	
	process.exit();
})();
