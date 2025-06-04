// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	const lines = []
	for await (const line of rl) {
		// console.log('Hello Goorm! Your input is', line);
		lines.push(line.split(" "))
	}
	const queue = []
	const [N,K] = lines[0].map(Number)
	const orders = lines.slice(1)

	for (let o of orders){
		if (o[0] == "push"){
			if (queue.length < K){
				queue.push(Number(o[1]))
				
			} else{
				console.log("Overflow")
			}
		} else {
			if (queue.length > 0) {
				console.log(queue.shift())
			} else{
				console.log("Underflow")
			}
		}
	}

	
	
	
	process.exit();
})();
