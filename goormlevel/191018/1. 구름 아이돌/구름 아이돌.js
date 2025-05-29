// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let lines = []
	for await (const line of rl) {
		lines.push(line)
		
	}
	
	let arr = lines[1].split(" ")
	let B = arr.map((el,idx)=> [el,idx+1])
	
	B.sort((a, b) => Number(b[0]) - Number(a[0]));
	// console.log(B)
	
	let answer = B.slice(0,3).map(el => el[1])
	console.log(...answer)
	
	
	
	process.exit();
})();
