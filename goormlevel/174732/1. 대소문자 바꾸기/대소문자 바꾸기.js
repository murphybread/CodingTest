// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	const lines = []
	for await (const line of rl) {
		lines.push(line)
		
		
	}

	// console.log(lines)
	let s  = [...lines[1]]

	let answer = s.map(c => {
			return c === c.toUpperCase()
      ? c.toLowerCase()
      : c.toUpperCase();
	})
	console.log(answer.join(''))
	// lines 사용해서 문제해결
	
	process.exit();
})();
