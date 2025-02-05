const input  = require("fs").readFileSync("/dev/stdin").toString().trim().split('\n')

const [n, m] = input[0].split(' ').map(Number);
const nSet = new Set(input.slice(1, n+1));
const mArray = input.slice(n+1);
let answer= 0

for(let word of mArray){
    if(nSet.has(word)) {
        answer++;
    }
}

console.log(answer)

