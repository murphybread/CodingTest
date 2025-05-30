// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });

	let lines= [ ]
	for await (const line of rl) {
		lines.push(line)
		
	}

	let arr = lines[1].split(" ")
	let dec = arr.map(Number).reduce((acc,cur)=>acc+cur, 0)
	console.log(dec.toString(8))
	
	process.exit();
})();
