// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });

	const lines = []
	for await (const line of rl) {
		// console.log('Hello Goorm! Your input is', line);
		if (lines.length <= 0 ){
			lines.push(line)	
		}
		else{
			lines.push(line.split(" ").map(Number))
		}
		
	}
	

	let arr = lines.slice(1).map((el,idx)=> [...el,idx+1])
	// console.log(arr)

	// 무게/부피 | 무게 | 번호작은순
	arr.sort((a,b) => (b[0] / b[1]) - (a[0] / a[1]) || (b[0]-a[0]) || a[2] - b[2] )
	// console.log(arr)
	
	


	console.log(arr[0][2])
	
	
	process.exit();
})();
