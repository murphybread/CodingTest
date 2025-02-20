const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, s] = input.shift().split(" ").map(Number);
const arr = input[0].split(" ").map(Number);

let count = 0;
function backtracking(depth, sum) {
  if (depth >= n) return;
  if (sum + arr[depth] === s) count++;

  backtracking(depth + 1, sum + arr[depth]);
  backtracking(depth + 1, sum);
}

backtracking(0, 0);

console.log(count);
