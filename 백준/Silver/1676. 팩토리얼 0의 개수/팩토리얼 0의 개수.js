const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .split("\n")
  .map(Number);

const n = input[0];
let count = 0;
let i = 5;

while (i <= n) {
  count += Math.floor(n / i);
  i *= 5;
}

console.log(count);