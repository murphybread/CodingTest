const input = require('fs').readFileSync("/dev/stdin").toString().split("\n")


const n = Number(input.shift());
const arr = input.slice(0, n);
let flag = false;
arr.sort((a, b) => b - a);

for (let i = 0; i< n - 2; i++) {
  let a = Number(arr[i]);
  let b = Number(arr[i + 1]);
  let c = Number(arr[i + 2]);

  if (a < b + c) {
    flag = true;
    console.log(a + b + c);
    break;
  }
}
if (!flag) console.log(-1);