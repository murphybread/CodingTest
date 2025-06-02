// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });

	let N = 0
	const lines = []
	const board= []
	for await (const line of rl) {
		lines.push(line)

		if (lines.length >=2 ){
			board.push(line.split(" ").map(Number))
		}
		rl.close();
	}
	N = Number(lines[0])
	let [x,y] = [0,0]
	for (let i =0 ;i<N;i++){
		for (let j=0; j<N;j++){
			if (board[i][j] === 0){
				[x,y] = [i,j]
				
			}
		}
	}

	const transposed = board[0].map((_, colIdx) =>
  board.map(row => row[colIdx])
);
	let row = board[x].reduce((acc,cur)=>acc+cur)
	let col = transposed[y].reduce((acc,cur)=>acc+cur)
	
	
	console.log(row+col)
	// for ( let arr of lines.slice(1).split(" ")) {
	// 	console.log(arr)
	// }
	
	
	process.exit();
})();
