// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	const lines =[]
	const M = []
	for await (const line of rl) {

		
		if (lines.length >=1){
			M.push(Number(line))
			
		}
		else {
			lines.push(line)
		}
	}
	let N = Number(lines[0].split(' ')[0])
	// console.log(N)
	// console.log(M,M.length)

	const s = new Set()
	let cnt = 0

	for (let num of M){
		if (!s.has(num)){
			s.add(num)
			
		}
		
		cnt+=1
		if (s.size == N){
			break
		}
	}
	
	console.log(s.size === N ? cnt : -1);
	
	process.exit();
})();
