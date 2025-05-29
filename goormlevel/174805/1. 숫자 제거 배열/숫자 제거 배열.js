// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	const lines = []
	
	for await (const line of rl) {
		lines.push(line)

	}

	let [N,K] = lines[0].split(" ")
	let arr = lines[1].split(" ")

	// for (let a of arr){
	// 	console.log(a, typeof(a), a.includes(K))
	// }
	let answer =  arr.filter(a=> !a.includes(K))
	console.log(answer.length)
	
	
	process.exit();
})();
