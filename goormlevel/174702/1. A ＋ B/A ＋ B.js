// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });

	const lines =[]

	for await (const line of rl) {
		lines.push(line)
		
	}
	
	const [a, b] = lines[0].split(" ");
	
	console.log(Number(a)+ Number(b))
	process.exit();
})();
